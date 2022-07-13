package com.revature.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.entities.Book;

public class BookTests {

    // here is where I am going to test my BookDAO

    // I declared the type as an Interace here
    public static BookDAOInterface bookDao;

    @BeforeClass
    public static void setup(){
        // but I initialized the field as a BookDAO object here
        // this is called coding to the interface: it makes our code more modual and easier
        // to adjust if necessary
        bookDao = new BookDAO();
    }

    @Test // Make sure to add this @Test annotation
    public void createBookPositiveTest(){ // This is a positive test, so I note it in the test name
        Book testBook = new Book("test book title","test book author");
        Book result = bookDao.createBook(testBook);
        Assert.assertNotNull(result.getId());
    }

    @Test
    public void getAllBooksPositiveTest(){
        List<Book> bookList = bookDao.getAllBooks();
        Assert.assertTrue(bookList.size() >= 2);
    }
    
}
