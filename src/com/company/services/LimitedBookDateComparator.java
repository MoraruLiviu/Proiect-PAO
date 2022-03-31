package com.company.services;

import com.company.books.LimitedBook;

import java.util.Comparator;

public class LimitedBookDateComparator implements Comparator<LimitedBook> {
    @Override
    public int compare(LimitedBook book1, LimitedBook book2){
        return book1.getDiscontinueDate().compareTo(book2.getDiscontinueDate());
    }

}
