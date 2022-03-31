package com.company.users;

public class User {
    protected static int idCounter = 0;
    protected final int id;
    protected String name = "NAME";
    protected String email = null;
    protected String password = null;

    public User(){
        idCounter++;
        this.id=idCounter;
    }

    public User(String name, String email, String password){
        idCounter++;
        this.id=idCounter;
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public int getUserId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }
}
