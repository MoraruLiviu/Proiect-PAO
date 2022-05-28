package com.company.users;

public class Author  extends User{
    private int age = 0;
    private String country = "COUNTRY";

    public Author(){
        super();
    }

    public Author(String name, String email, String password){
        super(name, email, password);
    }

    public Author(String name, String email, String password, int age, String country) {
        super(name, email, password);
        this.age=age;
        this.country=country;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public String toCSV(){
        return this.getUserId() +
                "," + age +
                "," + country +
                "\n";
    }

}
