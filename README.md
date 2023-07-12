# create-pdf-document

In this project you can find out how to create the fastest and simplest (for my actual knowledge) way a PDF document.
The project is written in Java language with Quarkus framework. To create the PDF i used the following library:
https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox
```
<dependency>
  <groupId>org.apache.pdfbox</groupId>
  <artifactId>pdfbox</artifactId>
  <version>2.0.28</version>
</dependency>
```

### test

Once you've copied this project, to try it out just write in the terminal (navigate first into the project path) the following command:
```
mvn clean quarkus:dev
```
and the application will run. Once running just make a GET request (possibly using Postman) to the following endpoint:
```
http://localhost:8080/api/pdf
```
you will get as response a 200 OK with the written pdf.

