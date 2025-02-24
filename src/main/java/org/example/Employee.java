package org.example;

public class Employee extends Person
{
    private int booksSold;
    private int salary;
//    private int age;
//    private String password;
//    private String userName;
//    private String phoneNumber;

    public Employee()
    {
        super();
        salary = 0;
        booksSold = 0;
    }

    public Employee(String userName, int age, String password, String phoneNumber)
    {
        super(userName, age, password, phoneNumber);
        salary = 0;
        booksSold = 0;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public void setBooksSold(int booksSold)
    {
        this.booksSold = booksSold;
    }

    public int getBooksSold()
    {
        return booksSold;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void displayInfo()
    {
        System.out.println("Name: " + getUserName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Books sold: " + getBooksSold());
        System.out.println("Salary: " + getSalary());
    }
}
