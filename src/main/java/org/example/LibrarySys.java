package org.example;


import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.awt.geom.FlatteningPathIterator;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySys
{
    private ArrayList<Bookk> bookks = new ArrayList<Bookk>();
    private ArrayList<Buyer> customers = new ArrayList<Buyer>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private static final String customerFile = "customers.json";
    private static final String employeesFile = "employees.json";
    private static final String booksFile = "bookks.json";


    public void saveBooks()
    {
        JSONArray ja = new JSONArray();

        for (Bookk book : bookks)
        {
            JSONObject jo = new JSONObject();
            jo.put("title", book.getTitle());
            jo.put("author", book.getAuthor());
            jo.put("year", book.getYear());
            jo.put("availableCopies", book.getAvailableCopies());
            jo.put("price", book.getPrice());
            jo.put("isbn", book.getIsbn());
            ja.add(jo);
        }
        try (FileWriter file = new FileWriter(booksFile)) {
            file.write(ja.toJSONString());
            file.flush();
            System.out.println("Successfully saved to JSON file");   // comment it later
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveCustomers()
    {
        JSONArray ja = new JSONArray();

        for (Buyer customer : customers) {
            JSONObject jo = new JSONObject();
            jo.put("userName", customer.getUserName());
            jo.put("age", customer.getAge());
            jo.put("password", customer.getPassword());
            jo.put("phoneNumber", customer.getPhoneNumber());
            jo.put("booksPurchased", customer.getBooksPurchased());
            ja.add(jo);
        }

        try (FileWriter file = new FileWriter(customerFile)){
            file.write(ja.toJSONString());
            file.flush();
            System.out.println("Successfully saved to JSON file");   // comment it later
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveEmployees()
    {
        JSONArray ja = new JSONArray();

        for (Employee employee : employees)
        {
            JSONObject jo = new JSONObject();
            jo.put("userName", employee.getUserName());
            jo.put("age", employee.getAge());
            jo.put("password", employee.getPassword());
            jo.put("phoneNumber", employee.getPhoneNumber());
            jo.put("salary", employee.getSalary());
            jo.put("booksSold", employee.getBooksSold());
            ja.add(jo);
        }

        try(FileWriter file = new FileWriter(employeesFile)){
            file.write(ja.toJSONString());
            file.flush();
            System.out.println("Successfully saved to JSON file");    // comment it later
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadBooks()
    {
        JSONParser jp = new JSONParser();

        try (FileReader reader = new FileReader(booksFile)) {
            Object obj = jp.parse(reader);
            JSONArray ja = (JSONArray) obj;

            bookks.clear();

            for (Object item : ja) {
                JSONObject jo = (JSONObject) item;
                String title = (String) jo.get("title");
                String author = (String) jo.get("author");
                int Year = ((Long) jo.get("year")).intValue();
                int AvailableCopies = ((Long) jo.get("availableCopies")).intValue();
                int Price = ((Long) jo.get("price")).intValue();
                String isbn = (String) jo.get("isbn");

                bookks.add(new Bookk(title, author, Year, Price, isbn, AvailableCopies));
            }

            System.out.println("Successfully loaded from JSON file");     // comment it later
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void loadCustomer()
    {
        JSONParser jp = new JSONParser();
        try(FileReader reader = new FileReader(customerFile)){
            Object obj = jp.parse(reader);
            JSONArray ja = (JSONArray) obj;

            customers.clear();

            for (Object item : ja)
            {
                JSONObject jo = (JSONObject) item;
                String userName = (String) jo.get("userName");
                int Age = ((Long) jo.get("age")).intValue();
                String password = (String) jo.get("password");
                String phoneNumber = (String) jo.get("phoneNumber");
                int BooksPurchased = ((Long) jo.get("booksPurchased")).intValue();
                customers.add(new Buyer(userName, Age, password, phoneNumber));

            }
            System.out.println("Successfully loaded from JSON file");     //comment it later
        }catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void loadEmployees()
    {
        JSONParser jp = new JSONParser();
        try(FileReader reader = new FileReader(employeesFile)){
            Object obj = jp.parse(reader);
            JSONArray ja = (JSONArray) obj;
            employees.clear();

            for (Object item : ja)
            {
                JSONObject jo = (JSONObject) item;
                String userName = (String) jo.get("userName");
                int Age = ((Long) jo.get("age")).intValue();
                String password = (String) jo.get("password");
                String phoneNumber = (String) jo.get("phoneNumber");
                int BooksSold = ((Long) jo.get("booksSold")).intValue();
                int salary = ((Long) jo.get("salary")).intValue();
                employees.add(new Employee(userName, Age, password, phoneNumber));
            }
            System.out.println("Successfully loaded from JSON file");    // comment later

        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public void addBook(Bookk bookk)
    {
        bookks.add(bookk);
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    public void addCustomer(Buyer customer)
    {
        customers.add(customer);
    }

    public boolean searchPhoneNumber(String phoneNumber, boolean isEmployee)
    {
        if(isEmployee)
        {
            for (Employee employee : employees) {
                if(employee.getPhoneNumber().equals(phoneNumber))
                {
                    return true;
                }
            }
        }
        else {
            for (Buyer customer : customers) {
                if(customer.getPhoneNumber().equals(phoneNumber))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchPassword(String password, boolean isEmployee)
    {
        if(isEmployee)
        {
            for (Employee employee : employees) {
                if(employee.getPassword().equals(password))
                {
                    return true;
                }
            }
        }
        else {
            for (Buyer customer : customers) {
                if(customer.getPassword().equals(password))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public int booksInStock()
    {
        return bookks.size();
    }

    public Bookk getBookk(int ind)
    {
        return bookks.get(ind);
    }

    public Buyer getCustomer(int ind)
    {
        return customers.get(ind);
    }

    public Employee getEmployee(int ind)
    {
        return employees.get(ind);
    }

    public void displayBooks()
    {
        if(bookks.size() == 0)
        {
            System.out.println("Stock is empty now");
        }
        else
        {
            System.out.println("Available books: ");
            for (int i=0; i< bookks.size(); i++)
            {
                System.out.print(i+1 + "- ");
                System.out.println(bookks.get(i).getTitle());
                System.out.println("Author: " + bookks.get(i).getAuthor());
                System.out.println("Year: " + bookks.get(i).getYear());
                System.out.println("Price: " + bookks.get(i).getPrice() + "LE");
                System.out.println("Available copies: " + bookks.get(i).getAvailableCopies());
                System.out.println("ISBN: " + bookks.get(i).getIsbn());
                System.out.println();
            }
        }
    }

    public int LogIn(boolean isEmployee)
    {
        System.out.println("Log in");
        System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        boolean isV = false;
        while(!isV)
        {
            String result = isVerified(username, password, isEmployee);
            if(result.equals("not verified"))
            {
                System.out.println("Wrong Username or Password: ");
                System.out.println("Please, try again ");
                System.out.println("Forgot your password?");
                System.out.println("1-Yes     2-No ");
                String answer = scanner.nextLine();
                if(answer.equals("1"))
                {
                    resetPassword(username, isEmployee);
                }else{
                    System.out.println("Do not have an account? ");
                    System.out.println("1-Yes     2-No ");
                    String answer2 = scanner.nextLine();
                    if(answer2.equals("1"))
                    {
                        createAccount(isEmployee);
                    }
                }
                System.out.println("Log in");
                System.out.println("Enter your username: ");
                username = scanner.nextLine();
                System.out.println("Enter your password: ");
                password = scanner.nextLine();
            }
            else {
                isV = true;
                if(isEmployee)
                {
                    for(int i=0; i<employees.size(); i++)
                    {
                        if(employees.get(i).getUserName().equals(username)){
                            System.out.println("yea");
                            return i;
                        }
                    }
                }
                else
                {
                    for(int i=0; i<customers.size(); i++)
                    {
                        if(customers.get(i).getUserName().equals(username)){
                            System.out.print("lol");
                            System.out.print(i);
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public void createAccount(boolean isEmployee)
    {
        String username;
        String password;
        int age;
        String phoneNumber;

        while(true)
        {
            boolean alreadyExists = false;
            System.out.println("Create a new account");
            System.out.println("Enter your username: ");
            Scanner scanner = new Scanner(System.in);
            username = scanner.nextLine();
            if(isEmployee)
            {
                for (Employee employee : employees) {
                    if(employee.getUserName().equals(username))
                    {
                        System.out.println("Already exists, please try again ");
                        alreadyExists = true;
                        break;
                    }
                }
            }
            else{
                for (Buyer customer : customers) {
                    if(customer.getUserName().equals(username))
                    {
                        System.out.println("Already exists, please try again ");
                        alreadyExists = true;
                        break;
                    }
                }
            }
            if(!alreadyExists)
            {
                break;
            }
        }


        while(true)
        {
            boolean alreadyExists = false;
            System.out.println("Enter your password: ");
            Scanner scanner = new Scanner(System.in);
            password = scanner.nextLine();
            if(isEmployee)
            {
                for (Employee employee : employees) {
                    if(employee.getPassword().equals(password))
                    {
                        System.out.println("Already exists, please try again ");
                        alreadyExists = true;
                        break;
                    }
                }
            }
            else{
                for (Buyer customer : customers) {
                    if(customer.getPassword().equals(password))
                    {
                        System.out.println("Already exists, please try again ");
                        alreadyExists = true;
                        break;
                    }
                }
            }
            if(!alreadyExists)
            {
                break;
            }
        }

        while (true)
        {
            boolean alreadyExists = false;
            System.out.println("Enter your phone number: ");
            Scanner scanner = new Scanner(System.in);
            phoneNumber = scanner.nextLine();
            if(isEmployee)
            {
                for (Employee employee : employees) {
                    if(employee.getPhoneNumber().equals(phoneNumber))
                    {
                        System.out.println("Already exists, please try again ");
                        alreadyExists = true;
                        break;
                    }
                }
            }
            else{
                for (Buyer customer : customers) {
                    if(customer.getPhoneNumber().equals(phoneNumber))
                    {
                        System.out.println("Already exists, please try again ");
                        alreadyExists = true;
                        break;
                    }
                }
            }
            if(!alreadyExists)
            {
                break;
            }
        }

        while(true)
        {
            System.out.println("Enter your age: ");
            Scanner scanner = new Scanner(System.in);
            age = scanner.nextInt();
            if(age<5 || age>120)
            {
                System.out.println("Invalid Age");
            }
            else{
                break;
            }
        }

        if(isEmployee)
        {
            Employee emp = new Employee(username, age, password, phoneNumber);
            employees.add(emp);
        }
        else{
            Buyer buy = new Buyer(username, age, password, phoneNumber);
            customers.add(buy);
        }
    }

    public String isVerified(String username, String password, boolean isEmployee)
    {
        if(isEmployee)
        {
            for (Employee employee : employees)
            {
                if (username.equals(employee.getUserName()) && password.equals(employee.getPassword()))
                {
                    return username;
                }
            }

        }
        else
        {
            for (Buyer buyer : customers)
            {
                if (username.equals(buyer.getUserName()) && password.equals(buyer.getPassword()))
                {
                    return username;
                }
            }
        }
        return "not verified";
    }

    public void resetPassword(String username, boolean isEmployee)
    {
        System.out.println("Enter your phone number to reset your password: ");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();
        if(isEmployee)
        {
            boolean foundNumber = false;
            for (Employee employee : employees)
            {
                if (username.equals(employee.getUserName()) && phoneNumber.equals(employee.getPhoneNumber()))
                {
                    foundNumber = true;
                    String newPass;
                    while(true) {
                        boolean alreadyExists = false;
                        System.out.println("Enter the new password: ");
                        Scanner scanner1 = new Scanner(System.in);
                        newPass = scanner1.nextLine();
                        for (Employee emplo : employees) {
                                if (emplo.getPassword().equals(newPass)) {
                                    System.out.println("Already exists, please try again ");
                                    alreadyExists = true;
                                    break;
                                }
                        }
                        if (!alreadyExists) {
                            break;
                        }
                    }
                    employee.changePassword(newPass);
                    System.out.println("Your password has been reset");
                }
            }
            if(!foundNumber)
            {
                System.out.println("Not found number!");
                System.out.println("We could not change the password");
            }

        }
        else
        {
            boolean foundNumber = false;
            for (Buyer customer : customers)
            {
                if (username.equals(customer.getUserName()) && phoneNumber.equals(customer.getPhoneNumber()))
                {
                    foundNumber = true;
                    String newPass;
                    while(true) {
                        boolean alreadyExists = false;
                        System.out.println("Enter the new password: ");
                        Scanner scanner1 = new Scanner(System.in);
                        newPass = scanner1.nextLine();
                        for (Buyer cust : customers) {
                            if (cust.getPassword().equals(newPass)) {
                                System.out.println("Already exists, please try again ");
                                alreadyExists = true;
                                break;
                            }
                        }
                        if (!alreadyExists) {
                            break;
                        }
                    }
                    customer.changePassword(newPass);
                    System.out.println("Your password has been reset");
                }
            }
            if(!foundNumber)
            {
                System.out.println("Not found number!");
                System.out.println("We could not change the password");
            }
        }
    }

}
