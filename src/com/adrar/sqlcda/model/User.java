package com.adrar.sqlcda.model;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public User(){}

    public User(String firstname, String lastname, String email, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}
