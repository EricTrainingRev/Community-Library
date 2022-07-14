package com.revature.service;

import java.util.List;

import com.revature.entities.Book;
import com.revature.repository.BookDAOInterface;

public class BookService implements BookServiceInterface {

    /*
        Because my service class is gate-keeping for the repository layer, it needs to have some way
        of sending data that has been validated to the repository layer. This is accomplished by using 
        dependency injection: I create a field of the proper data access object interface, and then I used
        the consutrctor at runtime to create the proper implementation object for said interface.
    */
    private BookDAOInterface bookDao;

    public BookService(BookDAOInterface bookDao){
        // the bookDao field is part of the object scope, so make sure to use the this keyword
        this.bookDao = bookDao;
    }



    @Override
    public boolean checkBookForTolkien(Book bookToCheck) {
        /*
            This method is checking to see if the book being entered/updated is following business
            rules: if it is, a true is returned because it is following the rules and the data can be
            sent into the repository layer. If the book is not following business rules a false is 
            returned and the data should NOT be sent to the repository layer
        */

        // make sure to use the equals method when comparing strings
        if(bookToCheck.getAuthor().equals("J. R. R. Tolkien")){
            // if the business rule is broken we return false
            return false;
        } else {
            // if the business rule is being followed we return true
            return true;
        }
    }

    @Override
    public Book serviceCreateBook(Book newBook) {
        if(this.checkBookForTolkien(newBook)){
            return this.bookDao.createBook(newBook);
        } else {
            return null; // this is not a great option, I will want to switch it at some point
        }
    }

    @Override
    public List<Book> serviceGetAllBooks() {
        /*
            because there are no business rules associated with this service method, and because we have 
            already tested the getAllBooks method in the repository layer, we can skip writing any unit
            tests for this service method and just return the results of the dao method
        */
        return this.bookDao.getAllBooks();
    }

    @Override
    public Book serviceUpdateBook(Book updatedBook) {
        if(this.checkBookForTolkien(updatedBook)){
            return this.bookDao.updateBook(updatedBook);
        } else {
            return null; // not a great option: will adjust when there is more time
        }
    }

    @Override
    public boolean serviceRemoveBook(Book bookToBeDeleted) {
        /*
            because there are no business rules associated with this service method, and because we have 
            already tested the removeBook method in the repository layer, we can skip writing any unit
            tests for this service method and just return the results of the dao method
        */
        return this.bookDao.removeBook(bookToBeDeleted);
    }
    
}
