package com.company.services;

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
