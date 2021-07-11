/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;
import java.io.*; 
import java.util.Scanner;
/**
 *
 * @author Connor
 */
public class User implements Serializable 
{
    
    private String username;
    protected String password;
    private String firstName;
    private String lastName;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public User(String username, String password, String firstName, String lastName)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getCourse()
    {
        return"N/a";
      
    }
     public String getDegree()
    {
        return"N/a";
      
    }

    public User(String username, String password)
    {
        this.password = password;
        this.username = username;
    }
    public int[] getBookISBN()
    {
        int[] myIntArray = new int[3];
    return  myIntArray;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
    
   public String getUserType()
   {
       return"None";
   }
    public  void addISBN(int ISBN){;}
    
    public String toString()
    {
        return username+"      "+password;
    }
}
