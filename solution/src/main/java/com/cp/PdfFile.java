package com.cp;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.List;

public class PdfFile {
    private final DbHibernate dbHibernate;

    public PdfFile(DbHibernate dbHibernate) {
        this.dbHibernate = dbHibernate;
    }

    public void savePdf() {

        String fileName = "data.csv";
        ClassLoader classLoader = PdfFile.class.getClassLoader();
        File resourcesDirectory = new File(classLoader.getResource("").getFile());

        // Create a new file in the resources directory
        File file = new File(resourcesDirectory, fileName);

        try (FileWriter fileWriter = new FileWriter(file);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("CustomerId", "CustomerFname", "CustomerMname", "CustomerLname", "CustomerMobile", "CustomerEmail", "CustomerLAddress",
                    "CustomerLAddrDistrict", "CustomerLAddrState", "CustomerLAddrCountry", "CustomerPAddress", "CustomerPAddrDistrict",
                    "CustomerPAddrState", "CustomerPAddrCountry", "CustomerStatus");
            for (Customer customer : dbHibernate.getCustomers()) {
                csvPrinter.printRecord(customer.getCustomerId(), customer.getCustomerFname(),
                        customer.getCustomerMname(), customer.getCustomerLname(), customer.getMobile(), customer.getEmail(),
                        customer.getlAddress(), customer.getlAddressDist(), customer.getlAddressState(), customer.getlAddressCountry(),
                        customer.getpAddress(), customer.getpAddressDist(), customer.getpAddressState(), customer.getpAddressCountry(),
                        customer.getStatus().toString());
            }

            System.out.println("Data has been written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
