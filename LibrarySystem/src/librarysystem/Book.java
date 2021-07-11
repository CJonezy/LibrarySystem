/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.Serializable;


public class Book implements Serializable 
{
    int ISBN;
    String author;
    String title;
    String location;
   
    String owner;
      boolean reserved;

     public Book(int ISBN, String author, String title, String location)
    {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.location = location;
        reserved=false;
        setKeywords();
        
    }

    public Book(int ISBN, String author, String title, String location,  String owner)
    {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.location = location;
       
        this.owner = owner;
        
        if( owner==null){
            reserved=false;
        }else{reserved=true;}
      
    }
    
    

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
       
        this.owner = owner;
    }

    public boolean getReserved()
    {
        return reserved;
    }

    public void setReserved(boolean status)
    {
        this.reserved = status;
    }

    
    
    
    public int getISBN()
    {
        return ISBN;
    }

    public void setISBN(int ISBN)
    {
        this.ISBN = ISBN;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public String[] getKeywords()
    {
       String keyword[] = new String[]{author,title,location};
        
        return keyword;
    }
    
    public void setKeywords()
    {
       
        
    }
            


public String toString()
{
   String reservo=null;
   String local =null;
   if(reserved=true){
       reservo="reserved";
       local="N/A";
   }else{    reservo="available";
    local=location;}
   
    String format = "%1$-20s %2$-20s%3$-30s%4$-20s%5$-20s\n";
               return String.format( format,ISBN,title,author,reservo,local);

}
}