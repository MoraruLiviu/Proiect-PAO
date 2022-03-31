package com.company.users;

import com.company.books.Book;

import java.util.List;

public class Reader extends User{
    private int age =0;
    private List<Book> wishlist;

    public Reader(){
        super();
    }

    public Reader(String name, String email, String password){
        super(name, email, password);
    }

    public Reader(String name, String email, String password, int age, List<Book> wishlist){
        super(name, email, password);
        this.age=age;
        this.wishlist=wishlist;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public List<Book> getWishlist(){
        return wishlist;
    }

    public void setWishlist(List<Book> wishlist){
        this.wishlist=wishlist;
    }
}
