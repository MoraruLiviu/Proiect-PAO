package com.company.services;


import com.company.books.LimitedBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LimitedBookCSVService {

    private static LimitedBookCSVService single_instance = null;

    private List<LimitedBook> limitedBooks = new ArrayList<LimitedBook>();

    public static LimitedBookCSVService getInstance()
    {
        if (single_instance == null)
            single_instance = new LimitedBookCSVService();
        return single_instance;
    }

    public void setLimitedBooks(List<LimitedBook> limitedBooks) {
        this.limitedBooks = limitedBooks;
    }

    public List<LimitedBook> getLimitedBooks() {
        return limitedBooks;
    }


    public static void writeLimitedBook(LimitedBook limitedBook) throws FileNotFoundException {
        File csvOutputFile = new File("src/main/java/com/company/resources/limitedbook.csv");
        String formattedLimitedBook = limitedBook.toCSV();

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvOutputFile, true))) {
            pw.append(formattedLimitedBook);
        }
        catch (FileNotFoundException e){
            System.out.println("No file exists");
        }
    }
}
