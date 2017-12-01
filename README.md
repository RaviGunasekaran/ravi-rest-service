# ravi-rest-service

<p>
This is Test - Rest WebSerive.<BR>
You can do GET / POST /DELETE using this service<BR>

Clone this Repo and goto repo path<BR>
and <BR>
Run - mvn clean package<BR>
Then<BR>
You will get employee-rest-service-1.0.0.jar inside /target folder.<BR>
Start your web service by running this - java -jar target/employee-rest-service-1.0.0.jar --server.port=8086<BR>
Then Access 
1. http://localhost:8086/greeting => This is Simple API<BR>
2. http://localhost:8086/rest/employee/get/all => Employee API<BR>

These are URI for test<BR>

GET =>  http://localhost:8086/rest/employee/dummy<BR>
GET =>  http://localhost:8086/rest/employee/get/all<BR>
POST =>  http://localhost:8086/rest/employee/create<BR>

Payload for POST<BR>
<BR>
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
<BR>
GET =>  http://localhost:8086/rest/employee/get/id/2<BR>
DELETE =>  http://localhost:8086/rest/employee/delete/id/2<BR>
</p>


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
