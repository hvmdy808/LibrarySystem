package org.example;

public class Bookk
{
    private String title;
    private String author;
    private int year;
    private int availableCopies;
    private int price;
    private String isbn;


    public Bookk()
    {
        title = "";
        author = "";
        year = 0;
        availableCopies = 0;
        price = 0;
        isbn = "";
    }

    public Bookk(String title, String author, int year, int price, String isbn, int availableCopies)
    {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
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

