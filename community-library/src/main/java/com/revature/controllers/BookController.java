package com.revature.controllers;

import io.javalin.http.Handler;

public class BookController {

    /*
        This BookController is going to parse the information recieved in HTTP request bodies, send the information
        to the appropriate service method, and craft an HTTP Response for us based upon the data recieved from
        the service methods
    */

    /*
        This is the basic setup for how to handle HTTP requests via Javalin: you create a variable that is a 
        reference to a lambda, provide an argument called ctx (stands for context, provided by Javalin), and then
        you write your code to handle the request
    */
    public Handler getHelloWorld = ctx -> {
        ctx.result("Hello world!");
        ctx.status(200);
    };
    
}
