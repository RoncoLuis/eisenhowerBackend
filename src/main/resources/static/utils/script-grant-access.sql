--This script creates a new user to grant access to databases
-- we can use this user to create/manage connections to the db
CREATE USER '<username>'@'localhost' IDENTIFIED BY '<username>';
GRANT ALL PRIVILEGES ON * . * TO '<username>'@'localhost';

--there are minor changes recent version of mysql we need a user and password
alter user '<username>'@'localhost' identified with mysql_native_password by '<username/password>';

-- connection name: webapp-vacantesdb
-- dbname: webappempleos
-- username: vacantesdev
-- password: vacantesdev

    --(Chad Darby)
-- connection resource: JSP, Servlets and JDBC for Beginners: Build a Database App: lecture 80