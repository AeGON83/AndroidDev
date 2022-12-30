package com.example.recyclerviewapp;

public class ContactDetails {
    String name , number;
    String profile;
    public ContactDetails(String name , String contact){
        this.name = name;
        this.number = contact;
        profile = String.valueOf(name.charAt(0));
    }
}
