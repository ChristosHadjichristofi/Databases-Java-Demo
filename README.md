# Databases-Java-Demo

## Demo created with other Languages and Technologies
1. [NodeJS](https://github.com/ChristosHadjichristofi/Databases-NodeJS-Demo)
2. [Python](https://github.com/DimK19/Databases-Python-Demo)
3. [PHP](https://github.com/cpefkianakis/Databases-PHP-Demo)

## Dependencies
1. [NodeJS](https://nodejs.org/en/)
2. [MySQL for Windows](https://dev.mysql.com/downloads/installer/)

## Useful Tools
1. Database Administration Tools like [Dbeaver](https://dbeaver.io/), [Navicat](https://www.navicat.com/en/), [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
2. [IntelliJ](https://www.jetbrains.com/community/education/)

## Initialize Project in IntelliJ
1. File > New > Project > Java Enterprise
2. Select Application Server the latest [Tomcat Server](https://tomcat.apache.org/) from the dropdown menu
3. Build Tool - Maven, Test runner - JUnit, Languages Java. Press Next
4. Choose Web Profile. Press Next
5. Name the project, Name the Group (package)

## Project Structure
1. ```src/main/java/<package-name>/``` - contains the Java Classes (Controllers - Logic of the WebApp)
2. ```src/main/java/webapp``` - contains the assets (css, images), WEB-INF folder, JSP pages
3. ```src/main/java/webapp/WEB-INF``` - must add lib folder and inside the [MySQL connector jar file](https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.28.zip)

## Tips
1. JSP pages - is a Java standard technology that enables you to write dynamic, data-driven pages for your Java web applications, basically HTML with code snippets (can contain variables, for loops, etc)
2. To add the MySQL connector jar file:
    1. Create a new directory under ```WEB-INF``` named ```lib```
    2. Unzip the file that you've downloaded
    3. Insert the ```.jar``` file inside ```lib``` folder
3. When you start the project you will notice that the url is ```localhost:8080/<project_name>_war_exploded```, to remove ```<project_name>_war_exploded```:
    1. Stop the Server if it is Running;
    2. In the Menu Bar Above Press -> Run
    3. Debug
    4. Edit Configurations
    5. Select your server (Tomcat or etc.)
    6. Deployment
    7. In the Application Context Bar: delete ```(packageName)_war_exploded/```
    8. Press Apply and Debug


![landing](https://user-images.githubusercontent.com/40044042/159064916-aac1a816-33ff-4e6f-9e63-45c31c7044a3.png)

![add-student](https://user-images.githubusercontent.com/40044042/159064953-cf6b808a-062a-48c7-b140-67b141b50604.png)

![students](https://user-images.githubusercontent.com/40044042/156389596-a409b129-e9cb-4946-9d9d-47f113c1d8f3.png)

![grades](https://user-images.githubusercontent.com/40044042/156389628-1653aba7-c033-48d0-ac3a-df37374f0d1e.png)
