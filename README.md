![Quick Build](https://github.com/schemacrawler/SchemaCrawler-Web-Application/workflows/Quick%20Build/badge.svg)
[![codecov](https://codecov.io/gh/schemacrawler/SchemaCrawler-Web-Application/branch/master/graph/badge.svg?token=9cG2hav7Av)](https://codecov.io/gh/schemacrawler/SchemaCrawler-Web-Application)

<img src="https://raw.githubusercontent.com/schemacrawler/SchemaCrawler/master/schemacrawler-website/src/site/resources/images/schemacrawler_logo.png" height="100px" width="100px" align="right" />

# SchemaCrawler Web Application

> **Please see the [SchemaCrawler website](https://www.schemacrawler.com/) for more details.**


## Web Application

> To access the application, open a browser to
[https://schemacrawler-webapp.herokuapp.com/](https://schemacrawler-webapp.herokuapp.com/)

SchemaCrawler Web Application makes SchemaCrawler accessible on the web. You can generate a schema diagram of your SQLite database.

-----

## Technologies

This is a Spring Boot 2.1 web application with a Bootstrap user interface, with source code control in GitHub, which is automatically built on every commit by Travis CI using a Maven build, tests are run, and coverage measured with JaCoCo and Coveralls, and then immediately deployed to Heroku using a Docker image, which generates an crows-foot ERD of a SQLite database.


## To Build and Run

### Build

Install [Graphviz](http://www.graphviz.org), which is a prerequisite for SchemaCrawler

Make sure that Docker is available and running

Modify `schemacrawler.webapp.storage-root` in `src/main/resources/application.properties` 
to point to a temporary directory on your system. 

Build and start application from Maven, run
```
mvn clean package
```

### Start the Server

Start the application from Maven, run
```
mvn spring-boot:run
```

Start application from the jar file, run
```
java -jar target/schemacrawler-webapp-16.11.7.5.jar
```

### Use the Application

Then, after you ensure that the web server is running, either from the command-line,
or the Docker container.

To access the application, open a browser to
[http://localhost:8080](http://localhost:8080)


## Docker Container

### Run Docker Image Locally

Run the local image in a Docker container, using
```
docker run -p 8080:8080 -t schemacrawler/schemacrawler-webapp
```

To access the application, open a browser to
[http://localhost:8080](http://localhost:8080)


### Access Application on Heroku

To access the application, open a browser to
[https://schemacrawler-webapp.herokuapp.com/](https://schemacrawler-webapp.herokuapp.com/)
