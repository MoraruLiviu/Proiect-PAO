package com.company.services;

import com.company.books.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books =new ArrayList<>();
    private static BookService instance;

    private BookService(){}

    public static BookService getInstance(){
        if (instance==null){
            instance = new BookService();
        }
        return instance;
    }

    public List<Book> getBooks(){
        List<Book> allBooks= new ArrayList<>();
        allBooks.addAll(this.books);
        return allBooks;
    }

    public void addBook(Book book){
        this.books.add(book);
    }


}
