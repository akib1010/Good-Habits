package com.example.goodhabits.Objects;

public class Profile {
    private String name;
    private String email;

    public Profile(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }
}
