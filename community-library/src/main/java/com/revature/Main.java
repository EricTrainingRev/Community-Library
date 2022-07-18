package com.revature;

import com.revature.controllers.BookController;
import com.revature.repository.BookDAO;
import com.revature.repository.BookDAOInterface;
import com.revature.service.BookService;
import com.revature.service.BookServiceInterface;
import com.revature.utils.BusinessRules;

import io.javalin.Javalin;

public class Main {

    // reminder: the main method is the entry point for your application
    public static void main(String[] args) {
        
        // inside of the create method we call a lambda that Javalin can use to configure our web server
        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        /*
            For our controller class to be able to send information to the service layer for validation it
            must be given a service object. However, that service object requires its own dependencies to work
            correctly, so this is where we create our official objects for our repository and service layers so
            that our API can correctly send information where it needs to go
        */

        BookDAOInterface bookDao = new BookDAO();
        BusinessRules businessRules = new BusinessRules();
        BookServiceInterface bookService = new BookService(bookDao, businessRules);
        BookController bookController = new BookController(bookService);


        app.get("/hello", bookController.getHelloWorld);

        /*
            notice that my path strings all include book in them: this is part of creating a restful web service, something we will talk
            more about tomorrow
        */

        app.get("/book", bookController.getAllBooks);

        app.delete("/book", bookController.deleteBook);

        app.patch("/book", bookController.updateBook);

        app.post("/book", bookController.createBook);

        app.start();

    }
    
}
