## Steps to run locally
1. Run Mysql in local machine
  - One way is make use of docker
    ```
        docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=q1 -d mysql
    ```
2. Build the code using mvn
    ```
        mvn clean install
   ```
3. Run as Java program from IDE in Main method present in Server Class.