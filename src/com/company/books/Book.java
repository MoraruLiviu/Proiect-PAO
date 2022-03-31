package com.company.books;


import com.company.users.Author;
import com.company.users.Publisher;

public class Book {
    protected static int idCounter = 0;
    protected final int id;
    protected String title = "TITLE";
    protected Publisher publisher;
    protected Author author;
    protected String genre = "GENRE";

    public Book(){
        idCounter++;
        this.id=idCounter;
    }

    public Book(String title, Publisher publisher,Author author, String genre) {
        idCounter++;
        this.id = idCounter;
        this.title = title;
        this.publisher = publisher;
        this.author=author;
        this.genre = genre;
    }

    public int getBookId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher(){
        return publisher;
    }

    public void setPublisher(Publisher publisher){
        this.publisher = publisher;
    }

    public Author getAuthor(){
        return author;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre=genre;
    }
}
