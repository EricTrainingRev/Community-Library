package com.revature.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.entities.Book;
import com.revature.repository.BookDAO;
import com.revature.repository.BookDAOInterface;

public class BookServiceTests {

    public static BookDAOInterface bookDao;
    public static BookServiceInterface bookService;

    @BeforeClass
    public static void setup(){
        bookDao = new BookDAO();
        bookService = new BookService(bookDao);
    }

    /*
        This is a negative test because we are checking that our service method correctly identifies
        that a business rule is being broken and responds with the apprpriate return value
    */
    @Test
    public void checkBookForTolkienNegativeTest(){
        Book badBook = new Book("The Fellowship of the Ring","J. R. R. Tolkien");
        boolean result = bookService.checkBookForTolkien(badBook);
        Assert.assertFalse(result);
    }

    /*
        This is a positive test because we are checking that our service method correctly identifies
        that all relevant business rules are being adhered to and responds with the apprpriate return 
        value 
    */
    @Test
    public void checkBookForTolkienPositiveTest(){
        Book goodBook = new Book("Crime and Punishment", "I cant spell this name");
        boolean result = bookService.checkBookForTolkien(goodBook);
        Assert.assertTrue(result);
    }
    
}
