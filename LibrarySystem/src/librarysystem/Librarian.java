/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

/**
 *
 * @author Connor
 */
public class Librarian extends User
{

    public Librarian(String username, String password)
    {
        super(username, password);
    }

    public Librarian(String username, String password, String firstName, String lastName)
    {
        super(username, password, firstName, lastName);
    }
     public String getUserType()
   {
       return"Librarian";
   }
}
