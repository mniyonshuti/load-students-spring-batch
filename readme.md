# Students batch application
After the application is open, open the terminal and change directory to the location where the file has been saved.
1. Run the command (to access the docker compose file)
```sh
$ cd load-students-spring-batch
```
2. Then run the command (to create the image of the application).
```sh
$ sudo docker build . -t students_batch_file
```
3. Run the command (to create the image of mysql).
```sh
$ sudo docker pull mysql
```
4. Run the command (to create the docker containers for mysql and the application).
```sh
$ sudo docker-compose up -d;
```
5. Run the command (to start the docker compose containers).
```sh
$ sudo docker-compose up
```
# Loging into the application
After the application has started in docker access it from the url http://localhost:8081/
Login with the credentials 
Username: **admin**
Password: **test1234**
Click the start job button to start the batch file execution
# Accessing the MySQL databse
1. To access the MySQL database container run the command 
```sh
sudo docker exec -it mysql_database_container bash
```
2. To log into the MySQL database the command
```sh
mysql -u admin -p 
```
and enter password **test1234** to log into mysql database

3. To check the  students table in the databse record run the command 
run the command 
```sh
SELECT * FROM students_db.student;
```
4. checking the tables in the database 
```sh
use students_db;
show tables;
```
Thank you
