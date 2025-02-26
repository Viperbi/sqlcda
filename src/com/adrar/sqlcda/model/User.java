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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String toString() {
        return "User{" +
                "firstname='" + this.firstname + '\'' +
                ", lastname='" + this.lastname + '\'' +
                ", email='" + this.email + '\'' +
                ",id='" + this.id + '\'' +
                '}';
    }
}
