package com.company.services;


import com.company.users.Publisher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PublisherSingleton {

    private static PublisherSingleton single_instance = null;

    private List<Publisher> publishers = new ArrayList<Publisher>();

    public static PublisherSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new PublisherSingleton();
        return single_instance;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }


    public static void writePublisher(Publisher publisher) throws FileNotFoundException {
        File csvOutputFile = new File("Proiect-PAO/src/com/company/resources/publisher.csv");
        String formattedPublisher = publisher.toCSV();

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvOutputFile, true))) {
            pw.append(formattedPublisher);
        }
        catch (FileNotFoundException e){
            System.out.println("No file exists");
        }
    }


}
