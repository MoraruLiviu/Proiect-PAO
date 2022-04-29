package com.company.services;


import com.company.users.Author;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AuthorSingleton {

    private static AuthorSingleton single_instance = null;

    private List<Author> authors = new ArrayList<Author>();

    public static AuthorSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new AuthorSingleton();
        return single_instance;
    }

    public void setLimitedBooks(List<Author> authors) {
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }


    public static void writeAuthor(Author author) throws FileNotFoundException {
        File csvOutputFile = new File("Proiect-PAO/src/com/company/resources/author.csv");
        String formattedAuthor = author.toCSV();

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvOutputFile, true))) {
            pw.append(formattedAuthor);
        }
        catch (FileNotFoundException e){
            System.out.println("No file exists");
        }
    }
}
