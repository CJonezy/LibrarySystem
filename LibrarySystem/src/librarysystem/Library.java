/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Connor
 */
public class Library
{

    private String currentUser;
    HashMap<String, User> UserIDMap;
    // HashMap<String,User> StudentMap; 

    HashMap<Integer, Book> BookISBNMap;

    HashMap<String, Book> BookTitleMap;
    HashMap<String, Book> BookAuthorMap;

    ArrayList<Book> BookList;
    ArrayList<User> UserList;

    public Library()
    {
    }

    public Library(String currentUser)
    {
        this.currentUser = currentUser;
    }

    public String getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(String currentUser)
    {
        this.currentUser = currentUser;
    }

    public static void main(String[] args)
    {
        Library lib = new Library();
        System.out.println("f");
        lib.loadTestData();
        lib.serializeStudent();
        lib.deserializeStudent();
    }

    public void startupSystem()
    {
        loadTestData();
        serializeStudent();
        deserializeStudent();
        serializeBook();
        deserializeBook();
        System.out.println("b");

        loadUserHashmap();
        loadBookHashmap();
    }

    public void refreshSystem()
    {
        serializeStudent();
        deserializeStudent();
        serializeBook();
        deserializeBook();

        loadUserHashmap();
        loadBookHashmap();
      

    }

    public boolean loginAttempt(String UserName, String PassWord)
    {
        System.out.println("what");
        boolean booleanResult = false;
        System.out.println("fsdsf");
        User user = UserIDMap.get(UserName);
        System.out.println("fsdsf");
        System.out.println(user.getPassword());
        String returnedP = user.getPassword();
        System.out.println("fsdsf");
        if (PassWord.equals(returnedP)) {
            booleanResult = true;
        }
        System.out.println("fsdsf");
        System.out.println("yo");
        return booleanResult;
    }

    public boolean isAdmin(String Uname)
    {
        boolean result = false;

        if (UserIDMap.get(Uname) instanceof Admin) {
            result = true;
        }
        return result;
    }

    public boolean isLibrarian(String Uname)
    {
        boolean result = false;

        if (UserIDMap.get(Uname) instanceof Librarian) {
            result = true;
        }
        return result;
    }

    public boolean isStudent(String Uname)
    {
        boolean result = false;

        if (UserIDMap.get(Uname) instanceof Student) {
            result = true;
        }
        return result;
    }

    public void loadTestData()
    {
        UserList = new ArrayList<User>();
        BookList = new ArrayList<Book>();
        System.out.println("f");
        try {
            System.out.println("f");
            String g = "TestDataStudent.txt";
            Scanner sc = new Scanner(new File(g)).useDelimiter(", |\n");
            System.out.println("f");
            while (sc.hasNext()) {
                System.out.println("f");
                //Get the info for the pet
                Student student;

                String Uname = sc.next();
                String Pword = sc.next();
                String Fname = sc.next();
                String Lname = sc.next();
                String degree = sc.next();
                String course = sc.next();
                System.out.println(Pword);
                //Create the pet and add it to the array list
                student = new Student(Uname, Pword, Fname, Lname, degree, course);
                System.out.println("f");

                UserList.add(student);
                System.out.println("f");
            }

            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner sc = new Scanner(new File("TestDataLibrarian.txt")).useDelimiter(", |\n");

            while (sc.hasNext()) {

                //Get the info for the pet
                Librarian librarian;

                String Uname = sc.next();
                String Pword = sc.next();
                String Fname = sc.next();
                String Lname = sc.next();

                //Create the pet and add it to the array list
                librarian = new Librarian(Uname, Pword, Fname, Lname);

                UserList.add(librarian);

            }

            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Scanner sc = new Scanner(new File("TestDataAdmin.txt")).useDelimiter(", |\n");

            while (sc.hasNext()) {

                //Get the info for the pet
                Admin admin;

                String Uname = sc.next();
                String Pword = sc.next();

                //Create the pet and add it to the array list
                admin = new Admin(Uname, Pword);

                UserList.add(admin);

            }

            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Scanner sc = new Scanner(new File("TestBookFile.txt")).useDelimiter(", |\n");

            while (sc.hasNext()) {

                //Get the info for the pet
                Book book;

                String ISBN = sc.next();
                String author = sc.next();
                String title = sc.next();
                String location = sc.next();
                String owner = sc.next();
                System.out.println("yo gabba");
                int intIsbn = Integer.parseInt(ISBN);
                System.out.println("yo gabba");
                //Create the pet and add it to the array list
                book = new Book(intIsbn, author, title, location, owner);
                System.out.println("yo gabba");
                BookList.add(book);
                System.out.println("yo gabba");
            }

            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
         try {
               System.out.println("yofds gabba");
            Scanner sc = new Scanner(new File("TestBookNoOwnerFile.txt")).useDelimiter(", |\n");
  System.out.println("yofds gabba");
            while (sc.hasNext()) {
  System.out.println("yofds gabba");
                //Get the info for the pet
                Book book;

                String ISBN = sc.next();
                String author = sc.next();
                String title = sc.next();
                String location = sc.next();
               
                System.out.println("yofds gabba");
                int intIsbn = Integer.parseInt(ISBN);
                System.out.println("yo gabba");
                //Create the pet and add it to the array list
                book = new Book(intIsbn, author, title, location);
                System.out.println("yo gabba");
                BookList.add(book);
                System.out.println("yo gabba");
            }

            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void serializeStudent()
    {
        String filename = "UserFile.ser";

        // Serialization  
        try {
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object 
            out.writeObject(UserList);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public void deserializeStudent()
    {
        String filename = "UserFile.ser";

        // Serialization  
        // Deserialization 
        try {
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object 
            UserList = (ArrayList<User>) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            // loadBookHashmap();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

    }

    public void serializeBook()
    {
        System.out.println("Object hdsaszed");
        String filename = "BookFile.ser";

        // Serialization  
        try {
            //Saving of object in a file
            System.out.println("Object hasdasdasdasa serialized");
            FileOutputStream file = new FileOutputStream(filename);
            System.out.println("Object hasdasdasdasa serfdfsd");
            ObjectOutputStream out = new ObjectOutputStream(file);
            System.out.println("Obafsed");

            // Method for serialization of object 
              
            out.writeObject(BookList);
 System.out.println("Obafsed");
            out.close();
            file.close();
            
            

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException dfsis caught");
        }

    }

    public void deserializeBook()
    {
        String filename = "BookFile.ser";

        // Serialization  
        // Deserialization 
        try {
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object 
            BookList = (ArrayList<Book>) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");

        } catch (IOException ex) {
            System.out.println("IOExceptionsdaas is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

    }

    public void loadUserHashmap()
    {
        UserIDMap = new HashMap<String, User>();
        for (int i = 0; i < UserList.size(); i++) {
            String UnameId = UserList.get(i).getUsername();
            UserIDMap.put(UnameId, UserList.get(i));
        }

    }

    public void loadBookHashmap()
    {

        UserIDMap = new HashMap<String, User>();
        BookISBNMap = new HashMap<Integer, Book>();
        BookTitleMap = new HashMap<String, Book>();
       // BookAuthorMap = new HashMap<String, Book>();
        System.out.println("a");
        for (int i = 0; i < UserList.size(); i++) {
            String UnameId = UserList.get(i).getUsername();
            UserIDMap.put(UnameId, UserList.get(i));
        }
        System.out.println("a");
        for (int i = 0; i < BookList.size(); i++) {
            System.out.println("a");
            String title = BookList.get(i).getTitle();
            BookTitleMap.put(title, BookList.get(i));
        }
        System.out.println("a");

       /* for (int i = 0; i < BookList.size(); i++) {
            String author = BookList.get(i).getAuthor();
            BookAuthorMap.put(author, BookList.get(i));
        }*/
        System.out.println("a");
        for (int i = 0; i < BookList.size(); i++) {
            int ISBN = BookList.get(i).getISBN();
            BookISBNMap.put(ISBN, BookList.get(i));
        }

        System.out.println("a");

    }

    public String returnBook(int ISBN)
    {
        System.out.println("poo");
        return BookISBNMap.get(ISBN).toString();

    }

    public String getUserString(String Uname)
    {
        String s = UserIDMap.get(Uname).toString();
        return s;
    }

    public boolean reserveBook(int ISBN)
    {
        
        System.out.println("ywedasyadysadysayd");
        boolean result = false;
boolean result1= false;
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getISBN() == ISBN && !(BookList.get(i).getReserved() == true)) {
                BookList.get(i).setReserved(true);
                BookList.get(i).setOwner(currentUser);
                result = true;
               System.out.println(BookList.get(i).getReserved());
            }

        }
        
        
        System.out.println(result1+"yyd");
        refreshSystem();

        return result;

    }

    public ObservableList<Book> booksBorrowed()
    {
         ArrayList<Book> borrowedList = new ArrayList<Book>();
        String result = "";
        System.out.println(currentUser);
        for (Book player : this.BookList) {
            System.out.println(player.getOwner());
            if (player.getReserved() == true && player.getOwner().equals(currentUser)) {
               borrowedList.add(player);
            } else {
            }

        }

        return getUserList(borrowedList);
    }

    public Book getBook(int ISBN)
    {
        return BookISBNMap.get(ISBN);
    }

    public String displayUname(String Uname)
    {
        String g = UserIDMap.get(Uname).getUsername();
        return g;
    }

    public String displayPword(String Uname)
    {
        return UserIDMap.get(Uname).getPassword();
    }

    public String displayLname(String Uname)
    {
        return UserIDMap.get(Uname).getLastName();
    }

    public String displayFname(String Uname)
    {
        return UserIDMap.get(Uname).getFirstName();
    }

    public String displayCourse(String Uname)
    {
        return UserIDMap.get(Uname).getCourse();
    }

    public String displayDegree(String Uname)
    {
        return UserIDMap.get(Uname).getDegree();
    }

    public void createStudent(String uname, String password, String fName, String lName, String degree, String course)
    {

        Student student = new Student(uname, password, fName, lName, degree, course);
        UserList.add(student);

        refreshSystem();

    }

    public void createLibrarian(String uname, String password, String fName, String lName)
    {

        Librarian librarian = new Librarian(uname, password, fName, lName);
        UserList.add(librarian);

        refreshSystem();

    }

    public void editStudent(String oldUname, String uname, String password, String fName, String lName, String degree, String course)
    {
        System.out.println("what0");
        int index = getStudentbyID(oldUname);
        System.out.println(index);

        System.out.println("whatma");
        Student u = new Student(uname, password, fName, lName, degree, course);
        UserList.remove(index);
        System.out.println("what3");
        UserList.add(u);
        System.out.println("what3");
        updateBooks(oldUname, uname);
refreshSystem();
    }
    
    public void editLibrarian(String oldUname, String uname, String password, String fName, String lName)
    {
        System.out.println("what0");
        int index = getStudentbyID(oldUname);
        System.out.println(index);

        System.out.println("whatma");
        Librarian u = new Librarian(uname, password, fName, lName);
        UserList.remove(index);
        System.out.println("what3");
        UserList.add(u);
        System.out.println("what3");
        updateBooks(oldUname, uname);
        refreshSystem();
    }

    public void editBook(int oldISBN, int ISBN, String title, String author, String location)
    {
        Book book = new Book(ISBN, title, author, location);
        int index = getBookbyID(oldISBN);
        BookList.remove(index);
        BookList.add(book);
        refreshSystem();

    }

    public void updateBooks(String oldUname, String newUname)
    {

        for (int i = 0; i < BookList.size(); i++) {

            BookList.get(i);
            if (!(BookList.get(i).getOwner() == null)) {
                if (BookList.get(i).getOwner().equals(oldUname)) {

                    BookList.get(i).setOwner(newUname);
                }
            }

            refreshSystem();

        }
    }

    public void deleteUser(String Uname)
    {
        System.out.println("ye");
        int index = getStudentbyID(Uname);
        System.out.println("ye");
        UserList.remove(index);
        System.out.println("ye");

        for (int i = 0; i < BookList.size(); i++) {
System.out.println("ye");
           Book b= BookList.get(i);

            if (b.getOwner()!=null) {
                if (b.getOwner().equals(Uname)){

                b.setOwner(null);
                System.out.println("yet");
               b.setReserved(false);
                System.out.println("yot");
            }
        }
        }
System.out.println("yeep");
        refreshSystem();

    }

    public void deleteBook(int ISBN)
    {
        int index = getBookbyID(ISBN);
        BookList.remove(index);

        refreshSystem();

    }

    public void createBook(int ISBN, String title, String author, String location)
    {

        Book book = new Book(ISBN, title, author, location);

        BookList.add(book);

        refreshSystem();
    }

    public int getBookbyID(int ISBN)
    {

        int index = -1;

        for (int i = 0; i < BookList.size(); i++) {

            Book f = BookList.get(i);
            if (f.getISBN() == ISBN) {
                index = i;

            }

        }
        return index;
    }

    public int getStudentbyID(String Uname)
    {

        int index = -1;

        for (int i = 0; i < UserList.size(); i++) {

            User f = UserList.get(i);
            if (f.getUsername().equals(Uname)) {
                index = i;

            }

        }
        return index;
    }

    public ObservableList<Book> bookLoanReport()
    {
         return getUserList(BookList);
    }

    public ObservableList<Book> studentBookLoanReport(String Uname)
    {
        String result = "";
          ArrayList<Book> reportList = new ArrayList<Book>();
        System.out.println(Uname);
        for (Book player : this.BookList) {
            System.out.println(player.getOwner());
            if (player.getReserved() == true && player.getOwner().equals(Uname)) {
               reportList.add(player);
            } else {
            }

        }

       return getUserList(reportList);
    }

    public String getByKeyword(String keyword)
    {
        System.out.println("what3");
        String result = "";
        for (int i = 0; i < BookList.size(); i++) {

            Book f = BookList.get(i);
            System.out.println("what3");
            String[] keycheck = f.getKeywords();
            System.out.println("what3");
            for (int p = 0; p < keycheck.length; p++) {
                System.out.println("what3");
                if (keycheck[p].equals(keyword)) {
                    result = result + f.toString();
                }
            }

        }
        return result;

    }

    public ObservableList<Book> getByKeywords(String keyword)
    {

        ObservableList<Book> result = FXCollections.observableArrayList();

        for (int i = 0; i < BookList.size(); i++) {

            Book f = BookList.get(i);
            System.out.println("what3");

            System.out.println("what3");
            if (f.getAuthor().equals(keyword)) {

            }

        }

        return result;

    }

    public ObservableList getObservableBookListAuthor(String Author)
    {
        ArrayList<Book> authorList = new ArrayList<Book>();

        for (int i = 0; i < BookList.size(); i++) {

            Book f = BookList.get(i);
            System.out.println("what3");

            System.out.println("what3");
            if (f.getAuthor().toLowerCase().contains(Author)) {

                authorList.add(f);
            }

        }
        return getUserList(authorList);

    }

    public ObservableList getObservableBookListTitle(String title)
    {
        ArrayList<Book> titleList = new ArrayList<Book>();

        for (int i = 0; i < BookList.size(); i++) {

            Book f = BookList.get(i);
            System.out.println("what3");

            System.out.println("what3");
            if (f.getTitle().toLowerCase().contains(title)) {
                titleList.add(f);
            }

        }
        return getUserList(titleList);

    }

    public ObservableList getObservableBookListISBN(int ISBN)
    {
        
       String isbnString = Integer.toString(ISBN);
        ArrayList<Book> ISBNList = new ArrayList<Book>();
         for (int i = 0; i < BookList.size(); i++) {

            Book f = BookList.get(i);
            System.out.println("what3");
    String bookISBN = Integer.toString(f.getISBN());
            System.out.println("what3");
            if (bookISBN.contains(isbnString)) {
                ISBNList.add(f);
            }

        }
        return getUserList(ISBNList);
    }

    public ObservableList getObservableBookListKeyword(String keyword)
    {
        ArrayList<Book> titleList = new ArrayList<Book>();
        for (int i = 0; i < BookList.size(); i++) {
            boolean key = false;
            Book f = BookList.get(i);
            System.out.println("what3");
            String[] keycheck = f.getKeywords();
            System.out.println("what3");
            for (int p = 0; p < keycheck.length; p++) {

                if (keycheck[p].toLowerCase().contains(keyword)) {
                    key = true;
                }
            }
            if (key == true) {
                titleList.add(f);
            }
        }
        return getUserList(titleList);
    }

    private ObservableList<Book> getUserList(ArrayList<Book> f)
    {

        ObservableList<Book> list = FXCollections.observableArrayList(f);
        return list;
    }
    public ObservableList getUserforTable(String uname)
    {
        ArrayList<User> userList = new ArrayList<User>();

       

            User f = UserIDMap.get(uname);
         

           

                userList.add(f);
                ObservableList<User> list = FXCollections.observableArrayList(userList);
            
 return  list;
        
    

    }

     public ObservableList<User> getAllUsers()
    {
        
         ObservableList<User> list = FXCollections.observableArrayList(UserList);
         return list;
    }
    
}
