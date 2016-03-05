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

You will see the error page. Thats fine because you accessing the wrong path. To correcting it, try to type 

    http://localhost:8080/user
    
You will see the output of empty array.

    []
    
This is because there is no data yet in this apps. Ok, now we will add some data. Try to download the postman restclient (i assume you use the chrome browser, if you use another browser you can)


curl -i -X POST -H "Content-Type: application/json" -d '{"name":"tika","address":"bandung"}' http://localhost:8080/user
