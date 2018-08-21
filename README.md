# spring-boot-micro-service

Step by step user guide on https://github.com/PiyushChaudhari/spring-boot-micro-service/wiki

How to implement spring boot micro service. Pleases follow below step to implements.

  1.  [Create Notification Service](../../wiki/Create-Notification-Service)
 1.  [Create Account Create Service](../../wiki/Create-Account-Create-Service)
 1.  [Create Create Eureka Server](../../wiki/Create-Eureka-Server)
 1.  [Register account create service to eureka server](../../wiki/Register-Account-Create-Service-To-Eureka-Server)
 1.  [Register notification service to eureka server](../../wiki/Register-Notification-Service-To-Eureka-Server)
 1.  [Create zuul gateway](../../wiki/Create-Zuul-Gateway)
 1.  [Call notification service from account create service](../wiki/Call-Notification-Service-From-Account-Create-Service)
 1.  Run Eureka Server http://localhost:8761
 1.  Run Account Create Service with multiple instance as below: <br>
     `java -jar -Dserver.port=8080 account-create-service-0.0.1-SNAPSHOT.jar` <br>
     `java -jar -Dserver.port=8081 account-create-service-0.0.1-SNAPSHOT.jar` <br>
 1.  Run Notification Service with multiple instance as below: <br>
     `java -jar -Dserver.port=8082 notification-service-0.0.1-SNAPSHOT.jar` <br>
     `java -jar -Dserver.port=8083 notification-service-0.0.1-SNAPSHOT.jar` <br>     
 1.  Run zuul gateway http://Dynamic IP ADDRESS:8762
 1.  Check Account Create Service,Notification Service, zuul gateway are registered with Eureka Server or not.

 1. Call user registration api via zuul gateway
    **URL**: http://Dynamic IP ADDRESS:8762/registration/user/createAccount <br>
    **Method**: POST <br>
    **Content-Type**: application/json <br>
    **Body**:
    `{
	"firstName":"Piyush",
	"lastName":"Chaudhari",
	"email":"piyu181203@gmail.com",
	"password":"XXX",
	"age":25
    }` <br>
