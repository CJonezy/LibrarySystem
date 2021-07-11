/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Connor
 */
public class Student extends User
{
//ArrayList<String> bookList;
    private String degree;
    private String course;

    public Student( String username, String password, String firstName, String lastName, String degree, String course)
    {
        super(username, password, firstName, lastName);
        this.degree = degree;
        this.course = course;
    }

  
int[] bookISBN =null;
    public Student(String username, String password )
    {
        super(username, password);
    }

    public Student(String username, String password, String firstName, String lastName)
    {
        super(username, password, firstName, lastName);
    }

    public int[] getBookISBN()
    {
        return bookISBN;
    }

    public String getDegree()
    {
        return degree;
    }
   public String getPassword()
   {
 return super.password;  
   }

    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }
 public String getUserType()
   {
       return"Student";
   }
  public String toString()
  {
      return getUsername()+"        "+getFirstName()+"        "+getLastName()+"        "+degree+"         "+course;
  }
    
    
    
    
    
}
