package com.cp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        DbHibernate dbHibernate = new DbHibernate();

        server.createContext("/", (exchange) -> {
            Class clazz = Server.class;
            File file = new File(clazz.getResource("/customer.html").getFile());
            exchange.sendResponseHeaders(200, file.length());
            try (OutputStream os = exchange.getResponseBody()) {
                Files.copy(file.toPath(), os);
            }
        });

        server.createContext("/api/customers", (exchange -> {

            if ("GET".equals(exchange.getRequestMethod())) {
                String responseText = objectMapper.writeValueAsString(dbHibernate.getCustomers());
                exchange.sendResponseHeaders(200, responseText.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(responseText.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));

        server.createContext("/api/customer", new CustomerHandler(dbHibernate));

        server.createContext("/api/download", new FileHandler(dbHibernate));

        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server is running on port: 8080");

        if (server != null) {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                dbHibernate.close();
                server.stop(0); // Stop the server gracefully
                System.out.println("Server is stopped.");
            }));
        }

    }

    static class CustomerHandler implements HttpHandler {

        private final DbHibernate dbHibernate;

        CustomerHandler(DbHibernate dbHibernate) {
            this.dbHibernate = dbHibernate;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                ObjectMapper objectMapper = new ObjectMapper();
                InputStream requestBody = exchange.getRequestBody();

                try {
                    // Deserialize the JSON request into a Java object
                    Customer customer = objectMapper.readValue(requestBody, Customer.class);
                    // Respond with a success message
                    String response = "{\"CustomerId\": "+String.valueOf(dbHibernate.addCustomer(customer))+"}";
                    Headers headers = exchange.getResponseHeaders();
                    headers.add("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, response.length());
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    exchange.sendResponseHeaders(500, -1); // Server error
                }
            } else {
                // Respond with an error for non-POST requests
                String response = "This endpoint only accepts POST requests.";
                exchange.sendResponseHeaders(405, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }


    static class FileHandler implements HttpHandler {

        private final DbHibernate dbHibernate;

        public FileHandler(DbHibernate dbHibernate) {
            this.dbHibernate = dbHibernate;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            new PdfFile(dbHibernate).savePdf();
            OutputStream os = exchange.getResponseBody();
            ClassLoader classLoader = Server.class.getClassLoader();

            File resourcesDirectory = new File(classLoader.getResource("").getFile());

            // Create a new file in the resources directory
            File file = new File(resourcesDirectory, "data.csv");

            if (file.exists() && file.isFile()) {
                // Set response headers
                exchange.getResponseHeaders().set("Content-Disposition", "attachment; filename=" + file.getName());
                exchange.sendResponseHeaders(200, file.length());

                // Read the file and send its content in the response
                try (FileInputStream fileInputStream = new FileInputStream(file);
                     BufferedInputStream bis = new BufferedInputStream(fileInputStream)) {
                    byte[] buffer = new byte[8192];
                    int count;
                    while ((count = bis.read(buffer)) > 0) {
                        os.write(buffer, 0, count);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }


            } else {
                String response = "File not found.";
                exchange.sendResponseHeaders(404, response.length());
                os.write(response.getBytes());
            }

            os.close();
        }
    }

}