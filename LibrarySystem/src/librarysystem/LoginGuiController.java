/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Connor
 */
public class LoginGuiController
{

    @FXML
    Button loginBtn;
    @FXML
    TextField userNameField;
    @FXML
    PasswordField passWordField;
    @FXML
    private Text uwat;
    @FXML
    Text UnameTag;

    Library libsys;

    public void initialize(URL url, ResourceBundle rb)
    {

    }

    public void loginPressed(ActionEvent event) throws IOException
    {
        
        if(libsys==null){
        libsys = new Library();
        System.out.println("fsdsf");
        libsys.startupSystem();
        System.out.println("fsdsf");
        System.out.println("fsdsf");
        }
        String enteredUname = userNameField.getText();
        System.out.println("fsdsf");
        String enteredPword = passWordField.getText();
        System.out.println("fsdsf");

        boolean result = libsys.loginAttempt(enteredUname, enteredPword);
        System.out.println(result);

        if (result == true) {

            if (libsys.isStudent(enteredUname) == true) {
             GuiLoad(enteredUname, event,"student");

            } else if (libsys.isLibrarian(enteredUname)==true) {
                GuiLoad(enteredUname, event,"librarian");
            } else if (libsys.isAdmin(enteredUname)==true) {
                GuiLoad(enteredUname, event,"admin");
            }else{}

        }
    }

    private void GuiLoad(String Uname, ActionEvent event, String usertype) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gui.fxml"));

        Parent root = (Parent) fxmlLoader.load();

        GuiController controller = fxmlLoader.<GuiController>getController();
        if(usertype.equals("student")){
        controller.setUserStudent(Uname, libsys);
        }else if(usertype.equals("librarian")){
                controller.setUserLibrarian(Uname, libsys);
        }else if(usertype.equals("admin")){
        controller.setUserAdmin(Uname, libsys);
        }
        Scene scene = new Scene(root);

        Stage GuiStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GuiStage.setScene(scene);
        

        GuiStage.show();

    }
    
     private void librarianGuiLoad(String Uname, ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LibrarianGui.fxml"));

        Parent root = (Parent) fxmlLoader.load();

        LibrarianGuiController controller = fxmlLoader.<LibrarianGuiController>getController();

       // controller.setUserLibrarian(Uname, libsys);

        Scene scene = new Scene(root);

        Stage GuiStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GuiStage.setScene(scene);
        

        GuiStage.show();

    }
      private void AdminGuiLoad(String Uname, ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminGui.fxml"));

        Parent root = (Parent) fxmlLoader.load();

        AdminGuiController controller;
        controller = fxmlLoader.<AdminGuiController>getController();

        controller.setUser(Uname, libsys);

        Scene scene = new Scene(root);

        Stage GuiStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GuiStage.setScene(scene);
       

        GuiStage.show();

    }
       public void setLib(Library Lib)
       {
           libsys=Lib; 
       }
      

}
