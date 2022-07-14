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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Book serviceCreateBook(Book newBook) {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean serviceRemoveBook(Book bookToBeDeleted) {
        /*
            because there are no business rules associated with this service method, and because we have 
            already tested the getAllBooks method in the repository layer, we can skip writing any unit
            tests for this service method and just return the results of the dao method
        */
        return this.bookDao.removeBook(bookToBeDeleted);
    }
    
}
