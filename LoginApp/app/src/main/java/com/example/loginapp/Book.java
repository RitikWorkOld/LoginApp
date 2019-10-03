package com.example.loginapp;

public class Book {

    private String Hello;
    private String Update_please;


    public Book() {
    }


    public Book(String hello, String update_please) {
        Hello = hello;
        Update_please = update_please;
    }

    public String getHello() {
        return Hello;
    }

    public void setHello(String hello) {
        Hello = hello;
    }

    public String getUpdate_please() {
        return Update_please;
    }

    public void setUpdate_please(String update_please) {
        Update_please = update_please;
    }
}
