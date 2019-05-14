### About project

Project's aim is interesting highload testing with different protocols,
easy deployment and gamification of working process.

We have modules to perform attacks

Modules of web in react

And module of web-server

### Build and Run executable

1 Run command
````
gradle build
````
2 Go to ./api/build/libs/

3 Run
````
java -jar name.jar
````

### Run

1 run docker image of postgres docker run 
````
docker run -it -d --name test postgres
````
2 create in postgres console a database with name - bomber
```sql
psql -U postgres
CREATE DATABASE bomber
```
3 run docker image of arangodb, expose ports to localhost
````
docker run -it -d -p 8529:8529 --name arango -e ARANGO_RANDOM_ROOT_PASSWORD=0 -e ARANGO_NO_AUTH=1 arangodb
````


### About current version

Now we need to support rest in different modules of our project.

### Technologies

Arangodb [https://github.com/arangodb/arangodb]

SpringBoot [https://github.com/spring-projects/spring-boot]

Kotlin [https://github.com/JetBrains/kotlin]
