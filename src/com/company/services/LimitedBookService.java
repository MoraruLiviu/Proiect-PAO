package com.company.services;

import com.company.books.LimitedBook;

import java.util.ArrayList;
import java.util.List;

public class LimitedBookService {
    private List<LimitedBook> limitedBooks = new ArrayList<>();
    private static LimitedBookService instance;

    public LimitedBookService(){}

    public static LimitedBookService getInstance(){
        if (instance==null){
            instance = new LimitedBookService();
        }
        return instance;
    }

    public List<LimitedBook> getBooks(){
        List<LimitedBook> allBooks= new ArrayList<>();
        allBooks.addAll(this.limitedBooks);
        return allBooks;
    }

    public void addBook(LimitedBook limitedBook){
        this.limitedBooks.add(limitedBook);
    }

    public int sizeOfBooks(){
        return this.limitedBooks.size();
    }

    public List<LimitedBook> sortByDiscYear(List<LimitedBook> books){
        books.sort(new LimitedBookDateComparator());
        return books;
    }

    public static String limitedBookToString(LimitedBook limitedBook){
        return "Name="+ limitedBook.getTitle() + " | Publisher="+ limitedBook.getPublisher().getName() + " | Author= " + limitedBook.getAuthor().getName() + "| Discontinue date=" + limitedBook.getDiscontinueDate();
    }

    public static void printAllBooks(List<LimitedBook> books){
        for(int i =0; i<books.size(); i++){
            System.out.println(limitedBookToString(books.get(i)));
        }
    }
}
