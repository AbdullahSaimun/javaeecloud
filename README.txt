1. To set Tomcat user: <user password="sami" roles="manager-gui, manager-script, manager-jmx, manager-status, admin-gui, admin-script" username="sami"/>

2. To generate maven project: mvn archetype:generate \
  -DgroupId=com.javaee \
  -DartifactId=javaee \
  -Dversion=1.0.1 \
  -DarchetypeArtifactId=maven-archetype-webapp \
  -DinteractiveMode=false


 3. mkdir -p src/main/java
    mkdir -p src/test/java

 . For Linux docker run --name mysql-container \
        --network host \
        -e MYSQL_ROOT_PASSWORD=arafinN \
        -d mysql:8.0

     For Mac
     docker run --name mysql-container \
         -e MYSQL_ROOT_PASSWORD=arafinN \
         -p 3306:3306 \
         -d mysql:8.0
 4. docker exec -it mysql-container mysql -u root -p

 5. CREATE DATABASE javaee;

 6. use javaee;

 6. CREATE TABLE country (
         country_id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(255) NOT NULL,
         continent VARCHAR(255) NOT NULL
     );

     INSERT INTO country (name, continent) VALUES
         ('United States', 'North America'),
         ('Canada', 'North America'),
         ('Mexico', 'North America'),
         ('Brazil', 'South America'),
         ('Argentina', 'South America'),
         ('Chile', 'South America'),
         ('Colombia', 'South America'),
         ('Peru', 'South America'),
         ('Germany', 'Europe'),
         ('France', 'Europe'),
         ('Italy', 'Europe'),
         ('Spain', 'Europe'),
         ('United Kingdom', 'Europe'),
         ('Netherlands', 'Europe'),
         ('Switzerland', 'Europe'),
         ('Poland', 'Europe'),
         ('Portugal', 'Europe'),
         ('Sweden', 'Europe'),
         ('Norway', 'Europe'),
         ('Denmark', 'Europe'),
         ('Belgium', 'Europe'),
         ('Austria', 'Europe'),
         ('Czech Republic', 'Europe'),
         ('Finland', 'Europe'),
         ('Ireland', 'Europe'),
         ('Hungary', 'Europe');