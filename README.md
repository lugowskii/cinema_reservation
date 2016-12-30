#How to run application?<hr>
1. Import project as a Maven Project.  
2. An application works with MySQL database. If you don't have MySQLServer, you could download installer for Windows (https://dev.mysql.com/downloads/file/?id=466291) or install in preffered way. After installation completion, start MySQL service.  
3. Connect to database (e.g. using MySQLWorkbench) with ip=127.0.0.1 and default port(3306) or change connection settings in application properties.  
4. Import schema and data from dump (.sql file in root directory). To do this you can use Workbench. Choose Server->Data Import and load .sql file. Create new schema named cinema or change the schema name in application.properties. Then you could start import.  
5. You will be able to start application. Enjoy!
