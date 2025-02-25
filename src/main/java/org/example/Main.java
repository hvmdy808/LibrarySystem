package org.example;

//import com.sun.java.swing.action.ExitAction;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Scanner;
import javax.xml.transform.TransformerException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Library System");
        System.out.println("Are u a customer or an employee?");
        System.out.println("1- Customer    2- Employee");
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        boolean isEmployee;
        if(ans.equals("1"))
        {
            menuCustomer();
        }

        else if(ans.equals("2"))
        {
            menuEmployee();
        }

        else
        {
            System.out.println("Invalid choice");
        }
    }


    public static void menuEmployee()
    {
        boolean isEmployee = true;
        LibrarySys ls = new LibrarySys();
        ls.loadCustomer();
        ls.loadEmployees();
        ls.loadBooks();
        int userInd = ls.LogIn(true);
        Employee e = ls.getEmployee(userInd);
        while (true)
        {
            System.out.println("Hello, " + e.getUserName());
            System.out.println("1- Display available books");
            System.out.println("2- Add a new book");
            System.out.println("3- Modify a book");
            System.out.println("4- sell books");
            System.out.println("5- Display my information");
            System.out.println("6- Change my name");
            System.out.println("7- Change my password");
            System.out.println("8- Change my age");
            System.out.println("9- Change my phone number");
            System.out.println("10- End");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if(choice == 1)
            {
                ls.displayBooks();
            }

            else if(choice == 2)
            {
                System.out.println("Enter the book title: ");
                String bookTitle = scanner.nextLine();
                bookTitle = scanner.nextLine();
                System.out.println("Enter the book price: ");
                int bookPrice = scanner.nextInt();
                System.out.println("Enter the book author: ");
                String bookAuthor = scanner.nextLine();
                bookAuthor = scanner.nextLine();
                System.out.println("Enter the book year: ");
                int bookYear = scanner.nextInt();
                System.out.println("Enter the book available copies: ");
                int bookAvailableCopies = scanner.nextInt();
                System.out.println("Enter the book ISBN: ");
                String bookISBN = scanner.nextLine();
                bookISBN = scanner.nextLine();
                ls.addBook(new Bookk(bookTitle, bookAuthor, bookYear, bookPrice, bookISBN, bookAvailableCopies));
            }

            else if(choice == 3)
            {
                System.out.println("Which book would you like to edit?");
                ls.displayBooks();
                Scanner sc = new Scanner(System.in);
                int choice2 = sc.nextInt();
                if(choice2 >0 && choice2<= ls.booksInStock())
                {
                    Bookk bookk = ls.getBookk(choice2-1);
                    System.out.println("Enter the book title: ");
                    String bookTitle = scanner.nextLine();
                    bookTitle = scanner.nextLine();
                    System.out.println("Enter the book price: ");
                    int bookPrice = scanner.nextInt();
                    System.out.println("Enter the book author: ");
                    String bookAuthor = scanner.nextLine();
                    bookAuthor = scanner.nextLine();
                    System.out.println("Enter the book year: ");
                    int bookYear = scanner.nextInt();
                    System.out.println("Enter the book available copies: ");
                    int bookAvailableCopies = scanner.nextInt();
                    System.out.println("Enter the book ISBN: ");
                    String bookISBN = scanner.nextLine();
                    bookISBN = scanner.nextLine();
                    bookk.setTitle(bookTitle);
                    bookk.setPrice(bookPrice);
                    bookk.setAuthor(bookAuthor);
                    bookk.setYear(bookYear);
                    bookk.setAvailableCopies(bookAvailableCopies);
                    bookk.setIsbn(bookISBN);
                }
                else {
                    System.out.println("Invalid choice, please try again");
                }
            }

            else if(choice == 4)
            {
                System.out.println("How many books did you sell?");
                Scanner sc = new Scanner(System.in);
                int booksNum = sc.nextInt();
                e.setBooksSold(e.getBooksSold()+booksNum);
                int Bonus = e.getBooksSold()%5;
                e.setSalary(e.getSalary()+Bonus);
            }

            else if(choice == 5)
            {
                e.displayInfo();
            }

            else if(choice == 6)
            {
                System.out.println("Enter your new name");
                Scanner sc = new Scanner(System.in);
                String newName = sc.nextLine();
                e.setUserName(newName);
            }

            else if(choice == 7)
            {
                System.out.println("Enter your new password");
                Scanner sc = new Scanner(System.in);
                String newPassword = sc.nextLine();
                if(ls.searchPassword(newPassword, isEmployee))
                {
                    System.out.println("Your new password is already used");
                }
                else {
                    e.changePassword(newPassword);
                }
            }

            else if(choice == 8)
            {
                System.out.println("Enter your new age");
                Scanner sc = new Scanner(System.in);
                int newAge = sc.nextInt();
                if(newAge<5 || newAge>120)
                {
                    System.out.println("Invalid age, please try again");
                }else {
                    e.setAge(newAge);
                }
            }

            else if(choice == 9)
            {
                System.out.println("Enter your new phone number");
                Scanner sc = new Scanner(System.in);
                String newPhoneNumber = sc.nextLine();
                if(ls.searchPhoneNumber(newPhoneNumber, isEmployee))
                {
                    System.out.println("Your new phone number is already used");
                }
                else {
                    e.setPhoneNumber(newPhoneNumber);
                }
            }

            else if(choice == 10)
            {
                ls.saveBooks();
                ls.saveEmployees();
                ls.saveCustomers();
                break;
            }

            else {
                System.out.println("Invalid choice, please try again");
            }
        }

    }


    public static void menuCustomer(){
        boolean isEmployee = false;
        LibrarySys ls = new LibrarySys();
        ls.loadBooks();
        ls.loadEmployees();
        ls.loadCustomer();
        int userInd = ls.LogIn(false);
        Buyer bb = ls.getCustomer(userInd);
        while(true)
        {
            System.out.println("Hello, " + bb.getUserName());
            System.out.println("1- Display available books to purchase");
            System.out.println("2- Display my information");
            System.out.println("3- Change my username");
            System.out.println("4- Change my password");
            System.out.println("5- Change my age");
            System.out.println("6- Change my phone number");
            System.out.println("7- End");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice == 1)
            {
                ls.displayBooks();
                if(!(ls.booksInStock() == 0))
                {
                    System.out.println("Which book do you want to buy?");
                    int choice2 = scanner.nextInt();

                    if(choice2 > 0 && choice2 <= ls.booksInStock())
                    {
                        Bookk book1 = ls.getBookk(choice2-1);
                        if(book1.getAvailableCopies() >0)
                        {
                            System.out.println("Enter the number of copies you need: ");
                            int numOfCopies = scanner.nextInt();
                            if(numOfCopies <= book1.getAvailableCopies())
                            {
                                if(bb.getBooksPurchased() %5 == 0 || bb.firstTimePurchase())
                                {
                                    System.out.println("You have a discount of 200LE !");
                                    System.out.println("This will cost you" + (numOfCopies*book1.getPrice()-200) + "LE");
                                }
                                else{
                                    System.out.println("This will cost you" + numOfCopies*book1.getPrice() + "LE");
                                }
                                book1.purchaseCopies(numOfCopies);
                                bb.setBooksPurchased(bb.getBooksPurchased() + numOfCopies);
                            }
                        }
                    }
                    else {
                        System.out.println("Invalid choice, please try again");
                    }
                }
            }

            else if(choice == 2)
            {
                bb.displayInfo();
            }

            else if(choice == 3)
            {
                System.out.println("Enter your new name");
                Scanner sc = new Scanner(System.in);
                String newName = sc.nextLine();
                bb.setUserName(newName);
            }

            else if(choice == 4)
            {
                System.out.println("Enter your new password");
                Scanner sc = new Scanner(System.in);
                String newPassword = sc.nextLine();
                if(ls.searchPassword(newPassword, isEmployee))
                {
                    System.out.println("Your new password is already used");
                }
                else {
                    bb.changePassword(newPassword);
                }
            }

            else if(choice == 5)
            {
                System.out.println("Enter your new age");
                Scanner sc = new Scanner(System.in);
                int newAge = sc.nextInt();
                if(newAge<5 || newAge>120)
                {
                    System.out.println("Invalid age, please try again");
                }else {
                    bb.setAge(newAge);
                }
            }

            else if(choice == 6)
            {
                System.out.println("Enter your new phone number");
                Scanner sc = new Scanner(System.in);
                String newPhoneNumber = sc.nextLine();
                if(ls.searchPhoneNumber(newPhoneNumber, isEmployee))
                {
                    System.out.println("Your new phone number is already used");
                }
                else {
                    bb.setPhoneNumber(newPhoneNumber);
                }
            }

            else if(choice == 7)
            {
                ls.saveCustomers();
                ls.saveBooks();
                ls.saveEmployees();
                break;
            }

            else {
                System.out.println("Invalid choice, please try again");
            }
        }

    }
}



//            isEmployee = false;
//            LibrarySys ls = new LibrarySys();
//            int userInd = ls.LogIn(false);
//            Buyer bb = ls.getCustomer(userInd);
//            System.out.println("Hello, " + bb.getUserName());
//            System.out.println("1- Display available books to purchase");
//            System.out.println("2- Display your information");
//            int choice = scanner.nextInt();
//            if(choice == 1)
//            {
//                ls.displayBooks();
//                if(!(ls.booksInStock() == 0))
//                {
//                    System.out.println("Which book do you want to buy?");
//                    int choice2 = scanner.nextInt();
//                    while (true)
//                    {
//                        if(choice > 0 && choice <= ls.booksInStock())
//                        {
//                            Bookk book1 = ls.getBookk(choice);
//                            if(book1.getAvailableCopies() >0)
//                            {
//                                book1.purchaseCopies(1);
//                            }
//                        }
//                        else {
//                            System.out.println("Invalid choice, please try again");
//                            choice = scanner.nextInt();
//                        }
//                    }
//                }
//            }
//            else if(choice == 2)
//            {
//                bb.displayInfo();
//            }
//            else {
//                System.out.println("Invalid choice");
//            }




/*
// Create an instance of JsonObjectHandler
JsonObjectHandler handler = new JsonObjectHandler();

// Add some people
handler.addPerson(new Person("John Doe", 30, "john@example.com"));
handler.addPerson(new Person("Jane Smith", 25, "jane@example.com"));

// Save to JSON file
handler.saveToJson();

// Load from JSON file
handler.loadFromJson();

// Print all people
for (Person person : handler.getPeople()) {
    System.out.println(person);
}
 */





//import java.io.*;
//import java.util.ArrayList;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//public class JsonObjectHandler {
//    private ArrayList<Person> people;
//    private static final String FILE_PATH = "people.json";
//
//    public JsonObjectHandler() {
//        this.people = new ArrayList<>();
//    }
//
//    // Add a person to the ArrayList
//    public void addPerson(Person person) {
//        people.add(person);
//    }
//
//    // Save ArrayList to JSON file
//    public void saveToJson() {
//        JSONArray jsonArray = new JSONArray();
//
//        for (Person person : people) {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("name", person.getName());
//            jsonObject.put("age", person.getAge());
//            jsonObject.put("email", person.getEmail());
//            jsonArray.add(jsonObject);
//        }
//
//        try (FileWriter file = new FileWriter(FILE_PATH)) {
//            file.write(jsonArray.toJSONString());
//            file.flush();
//            System.out.println("Successfully saved to JSON file");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Read from JSON file and populate ArrayList
//    public void loadFromJson() {
//        JSONParser parser = new JSONParser();
//
//        try (FileReader reader = new FileReader(FILE_PATH)) {
//            Object obj = parser.parse(reader);
//            JSONArray jsonArray = (JSONArray) obj;
//
//            people.clear(); // Clear existing list
//
//            for (Object item : jsonArray) {
//                JSONObject jsonObject = (JSONObject) item;
//                String name = (String) jsonObject.get("name");
//                long age = (Long) jsonObject.get("age");
//                String email = (String) jsonObject.get("email");
//
//                people.add(new Person(name, (int) age, email));
//            }
//
//            System.out.println("Successfully loaded from JSON file");
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Get all people
//    public ArrayList<Person> getPeople() {
//        return people;
//    }
//}
//
//// Person class to store object data
//class Person {
//    private String name;
//    private int age;
//    private String email;
//
//    public Person(String name, int age, String email) {
//        this.name = name;
//        this.age = age;
//        this.email = email;
//    }
//
//    // Getters and setters
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    public int getAge() { return age; }
//    public void setAge(int age) { this.age = age; }
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    @Override
//    public String toString() {
//        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
//    }
//}
