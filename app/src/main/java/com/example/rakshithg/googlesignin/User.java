package com.example.rakshithg.googlesignin;

public class User {

    public String firstname, email, phone, lastname,password;

    public User(String firstname, String email, String phone, String lastname, String password) {
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.lastname = lastname;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }
}
