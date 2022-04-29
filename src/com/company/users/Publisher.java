package com.company.users;

public class Publisher  extends User{
    private String location = "COUNTRY";

    public Publisher(){
        super();
    }

    public Publisher(String name, String email, String password){
        super(name, email, password);
    }

    public Publisher(String name, String email, String password, String location){
        super(name, email, password);
        this.location=location;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location=location;
    }

    public String toCSV(){
        return this.getUserId() +
                "," + location +
                "\n";
    }
}
