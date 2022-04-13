package com.company.books;

import com.company.users.Author;
import com.company.users.Publisher;

import java.util.Date;

public class PermanentBook extends Book{
    private Date publishingDate = null;

    public PermanentBook(){
        super();
    }

    public PermanentBook(String title, Publisher publisher, Author author, String genre){
        super(title,publisher,author,genre);
    }

    public PermanentBook(String title, Publisher publisher, Author author, String genre, Date publishingDate){
        super(title,publisher,author,genre);
        this.publishingDate = publishingDate;
    }

    public Date getPublishingDate(){
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate){
        this.publishingDate=publishingDate;
    }

}
