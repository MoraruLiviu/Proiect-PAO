package com.company.services;

import com.company.books.Book;

import java.util.List;

public class ReaderService {
    private static ReaderService instance;

    private ReaderService(){}

    public static ReaderService getInstance(){
        if (instance==null){
            instance = new ReaderService();
        }
        return instance;
    }


}
