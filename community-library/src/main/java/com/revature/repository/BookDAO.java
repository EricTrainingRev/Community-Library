package com.revature.repository;

import java.util.List;

import com.revature.entities.Book;
import com.revature.utils.HibernateUtil;

public class BookDAO implements BookDAOInterface {

    @Override
    public Book createBook(Book newBook) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newBook);
        HibernateUtil.endTransaction();
        return newBook;

    }

    @Override
    public List<Book> getAllBooks() {
        HibernateUtil.beginTransaction();
        List<Book> bookList = HibernateUtil.getSession().createQuery("from Book", Book.class).getResultList();
        HibernateUtil.endTransaction();
        return bookList;
    }
    
}
