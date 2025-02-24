package org.example;

import java.util.ArrayList;

public class Buyer extends Person
{
    private int booksPurchased;
//    private int age;
//    private String password;
//    private String userName;
//    private String phoneNumber;


    public Buyer()
    {
        super();
        booksPurchased = 0;
    }

    public Buyer(String userName, int age, String password, String phoneNumber)
    {
        super(userName, age, password, phoneNumber);
        booksPurchased=0;
    }

    public int getBooksPurchased()
    {
        return booksPurchased;
    }

    public void setBooksPurchased(int booksPurchased)
    {
        this.booksPurchased = booksPurchased;
    }

    public boolean firstTimePurchase()
    {
        if(getBooksPurchased() == 0){
            return true;
        }
        return false;
    }

    public void setUserName(String username)
    {
        this.userName = username;
    }

    public void displayInfo()
    {
        System.out.println("Name: " + getUserName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Books Purchased: " + getBooksPurchased());
    }
}
