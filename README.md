# ravi-rest-service

This is Test - Rest WebSerive.
You can do GET / POST /DELETE using this service

Clone this Repo and goto repo path
and 
Run - mvn clean package
Then
You will get employee-rest-service-1.0.0.jar inside /target folder.
Start your web service by running this - java -jar target/employee-rest-service-1.0.0.jar --server.port=8086
Then Access 
1. http://localhost:8086/greeting => This is Simple API
2. http://localhost:8086/rest/employee/get/all => Employee API

These are URI for test

GET =>  http://localhost:8086/rest/employee/dummy
GET =>  http://localhost:8086/rest/employee/get/all
POST =>  http://localhost:8086/rest/employee/create

Payload for POST

{
    "employeeFirstName": "TESTER",
    "employeeLastName": "API",
    "departmentName": "IT",
    "empAddress": "ANY WHERE",
    "salary": 1000,
    "contactNumbers": [
        1234,
        5432
    ],
    "createdDate": null,
    "id": 1
}

GET =>  http://localhost:8086/rest/employee/get/id/2
DELETE =>  http://localhost:8086/rest/employee/delete/id/2



WORKING REQUESTS:
<P>
    
http://localhost:8085/greeting <BR>
http://localhost:8085/rest/employee/dummy<BR>
http://localhost:8085/rest/employee/create<BR>
http://localhost:8085/rest/employee/get/all<BR>
http://localhost:8085/rest/employee/get/id/1<BR>
http://localhost:8085/rest/employee/get/name/TESTER<BR>
http://localhost:8085/rest/employee/delete/id/0<BR>
http://localhost:8085/rest/employee/delete/name/API

</P>
