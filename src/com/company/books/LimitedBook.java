package com.company.books;

import com.company.users.Author;
import com.company.users.Publisher;

import java.util.Date;

public class LimitedBook extends Book{
    private Date releaseDate = null;
    private Date discontinueDate = null;

    public LimitedBook(){
        super();
    }

    public LimitedBook(String title, Publisher publisher, Author author, String genre){
        super(title,publisher,author,genre);
    }

    public LimitedBook(String title, Publisher publisher, Author author, String genre, Date releaseDate, Date discontinueDate){
        super(title,publisher,author,genre);
        this.releaseDate = releaseDate;
        this.discontinueDate = discontinueDate;
    }

    public Date getReleaseDate(){
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
    }

    public Date getDiscontinueDate(){
        return discontinueDate;
    }

    public void setDiscontinueDate(Date discontinueDate){
        this.discontinueDate = discontinueDate;
    }

}
