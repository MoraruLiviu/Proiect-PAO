package com.company.books;

import com.company.users.Author;
import com.company.users.Publisher;

public class LightNovel extends Book{
    private int pages = 0;

    public LightNovel(){
        super();
    }

    public LightNovel(String title, Publisher publisher, Author author, String genre){
        super(title,publisher,author,genre);
    }

    public LightNovel(String title, Publisher publisher, Author author, String genre, int pages){
        super(title,publisher,author,genre);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages){
        this.pages = pages;
    }
}
