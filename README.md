# spring-boot-angularjs

This is the boilerplate code that i use to create an application in spring and angularjs.

first of all download all the code.

go to server/ directory

    cd server/

then type 

    mvn spring-boot:run

Maven will download all jar dependency that required. If this is your first time using maven, it will take some time. You can create a and enjoy the coffee while waiting.

After you see "Started MyappApplication in xxx seconds" you can open your browser then at the address bar type  

    http://localhost:8080

You will see the "Whitelabel Error Page". Thats fine because you accessing the wrong path. To correcting it, try to type 

    http://localhost:8080/user
    
You will see the output of empty array.

    []
    
This is because there is no data yet in this apps. Ok, now we will add some data. Try to download the postman restclient extension or plugin. I assume you use the chrome browser. If you use another browser you can download the appropriate restclient plugin or just download the standalone restclient apps.

try to **POST** the data

    {"name":"mirza","address":"bandung"}

to 

    http://localhost:8080/user

make sure you use **content type JSON**

    Content-Type: application/json
    
If you familiar using a curl try to type the this into your terminal

    curl -i -X POST -H "Content-Type: application/json" -d '{"name":"mirza","address":"bandung"}' http://localhost:8080/user

then try to type back in your address bar

    http://localhost:8080/user
    
you will get some output like this

	[
		{
	    	"id": 1,
			"name": "mirza",
			"address": "bandung"
		}
	]
	
Congratulation you have successfully used this rest api apps..!
Now we will try to add some more data

