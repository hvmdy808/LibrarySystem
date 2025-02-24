package org.example;

abstract public class Person
{
    protected String userName;
    protected int age;
    protected String password;
    protected String phoneNumber;


    public Person()
    {
        userName = "";
        age = 0;
        password = "";
        phoneNumber = "";
    }

    public Person(String userName, int age, String password, String phoneNumber)
    {
        this.userName = userName;
        this.age = age;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void changePassword(String password)
    {
        this.password = password;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }
}


/*
public class Book
{
    private String title;
    private String author;
    private int year;
    private int availableCopies;
    private int price;
    private String isbn;


    public Book(){
        title = "";
        author = "";
        year = 0;
        availableCopies = 0;
        price = 0;
        isbn = "";
    }

    public Book(String title, String author, int year, int price, String isbn, int availableCopies)
    {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }

    public boolean isAvailable()
    {
        if(availableCopies > 0)
        {
            return true;
        }
        return false;
    }

    public void purchaseCopies(int books)
    {
        availableCopies -= books;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public int getYear()
    {
        return year;
    }

    public int getPrice()
    {
        return price;
    }

    public int getAvailableCopies()
    {
        return availableCopies;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setAvailableCopies(int availableCopies)
    {
        this.availableCopies = availableCopies;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
}

 */