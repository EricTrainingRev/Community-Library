package com.revature;

import com.revature.controllers.BookController;

import io.javalin.Javalin;

public class Main {

    // reminder: the main method is the entry point for your application
    public static void main(String[] args) {
        
        // inside of the create method we call a lambda that Javalin can use to configure our web server
        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        BookController bookController = new BookController();


        app.get("/hello", bookController.getHelloWorld);

        app.start();

    }
    
}
