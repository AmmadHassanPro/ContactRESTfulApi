# ContactRESTfulApi
Contact Rest Api Documentation


The app is deployed on GCP , please use the following url:

https://javarestapi-1234.appspot.com

and append the method name at the end and use the provided sample request and response to make requests. Postman is suggested to test the api.

Overview:


The Contact Rest Api is a Spring Boot with Spring MVC developed api which is capable of performing CRUD operation on a Contact Entity. It is using in memory h2 database instance for persistence. It using using Hibernate as an ORM and String Data JPA as a DAO layer. I have written some JUnit tests using Mockito and Spring Mock MVC to test some endpoints. It is using JSON for request and response.

It has the following methods:

 /Create
 
 
This method is responsible for creating contacts and presisting it on the database.
Sample Input (JSON):

{
"name":"name2",
"company":"compay",
"image":"image",
"email":"email",
"birthday":"1-1-1",
"phoneWork":"123",
"phonePersonal":"3221",
"streetAddress":"streetAdd",
"city":"city",
"state":"il",
"zipcode":"zipcode"
}

Sample output:

{"status":"200","comments":"Contact Added Successfully","date":"2018-04-28T11:17:36.888"}







/findByName

This method is responsible for accepting name field as a JSON and return the full contact details if the contact is found as JSON.

Sample Input (JSON):

{
	"name":"name2"
}
Sample Output(JSON);

{
    "contact": {
        "id": 1,
        "name": "name2",
        "company": "compay",
        "image": "image",
        "email": "email",
        "birthday": "1-1-1",
        "phoneWork": "123",
        "phonePersonal": "3221",
        "streetAddress": "streetAdd",
        "city": "city",
        "state": "il",
        "zipcode": "zipcode"
    },
    "status": "Record Found"
}





/findByEmail

This methods find contacts based on the email

Sample Input(JSON):

{
	"email":"email"
}
Sample Output (JSON):

{
    "contact": {
        "id": 1,
        "name": "name2",
        "company": "compay",
        "image": "image",
        "email": "email",
        "birthday": "1-1-1",
        "phoneWork": "123",
        "phonePersonal": "3221",
        "streetAddress": "streetAdd",
        "city": "city",
        "state": "il",
        "zipcode": "zipcode"
    },
    "status": "Record Found"
}




/findAllByState

This method is responsible for returning all the contacts which have the same state.

Sample Request (JSON):


{
	"state":"il"
	
}

Sample Response(JSON):

{
    "contactList": [
        {
            "id": 1,
            "name": "name2",
            "company": "compay",
            "image": "image",
            "email": "email",
            "birthday": "1-1-1",
            "phoneWork": "123",
            "phonePersonal": "3221",
            "streetAddress": "streetAdd",
            "city": "city",
            "state": "il",
            "zipcode": "zipcode"
        }
    ],
    "status": "Record Found"
}



/DeleteContactByName

This method is for deleting a contact from persistence based on name.

Sample Request(JSON):

{
	"name":"name1"
	
}

{
    "status": "200",
    "comments": "Contact Removed Successfully",
    "date": "2018-04-28T10:53:20.626"
}



/updateContactByName

This method is for updating a contact based on the name, any value could be changed.

Sample Request (JSON):

{
"name":"name2",
"company":"compay2233",
"image":"image",
"email":"email",
"birthday":"1-1-1",
"phoneWork":"123",
"phonePersonal":"3221",
"streetAddress":"streetAdd",
"city":"city222",
"state":"il",
"zipcode":"zipcode222"
}



Response:

{
    "status": "200",
    "comments": "Contact Updated Successfully",
    "date": "2018-04-28T11:17:57.618"
}
