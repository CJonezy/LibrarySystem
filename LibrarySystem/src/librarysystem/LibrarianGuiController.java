/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import librarysystem.Library;

/**
 * FXML Controller class
 *
 * @author Connor
 */
public class LibrarianGuiController implements Initializable
{

    @FXML
    TextField searchBookField;
    @FXML
    TextField userReportField;
    @FXML
    TextField createISBNField;
    @FXML
    TextField createTitleField;
    @FXML
    TextField createAuthorField;
    @FXML
    TextField createLocationField;
    @FXML
    TextField editISBNField;
    @FXML
    TextField editTitleField;
    @FXML
    TextField editAuthorField;
    @FXML
    TextField editLocationField;
    @FXML
    TextField editSearchField;
    @FXML
    TextField deletefield;
    @FXML
    Button searchBookBtn;
    @FXML
    Button generateReportBtn;

    @FXML
    TextArea bookSearchArea;
    @FXML
    TextArea reportArea;

    @FXML
    Button editBookBtn;
    @FXML
    Button deleteBookBtn;

    @FXML
    Button createBookBtn;

    @FXML
    Button submitEditBtn;
    @FXML
    Button editSearchButton;

    @FXML
    Button userSearchBtn;

    @FXML
    RadioButton keywordRadioButton;
    @FXML
    RadioButton ISBNRadioButton;
    @FXML
    RadioButton titleRadioButton;
    @FXML
    RadioButton authorRadioButton;
    @FXML
    TabPane LibrarianTabPane;
    @FXML
    Text bookEditedText;
    @FXML
    Tab editTab;
     @FXML
    Text ISBNLabel;
      @FXML
    Text authorLabel;
               @FXML
    Text titleLabel;
               @FXML
    Text locationLabel;

    Library Lib;
    String user_id;

    public void setUser(String user_id, Library libsys)
    {
        this.user_id = user_id;
        System.out.println(user_id);
        //UnameTag.setText(user_id);
        Lib = libsys;
        Lib.setCurrentUser(user_id);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    public void searchBookButtonPressed()
    {
        String enteredSearch = searchBookField.getText();
        if (ISBNRadioButton.isSelected()) {

            int intISBN = Integer.parseInt(enteredSearch);

            Book g = Lib.BookISBNMap.get(intISBN);

            System.out.println(g);
            if (g == null) {
                bookSearchArea.setText("error");
            } else {
            }
            System.out.println(Lib.BookISBNMap.get(intISBN).toString());
            bookSearchArea.setText(Lib.returnBook(intISBN).toString());

        } else if (keywordRadioButton.isSelected()) {

            boolean g = Lib.getByKeyword(enteredSearch).equals("");
            System.out.println(g);
            if (g == true) {
                bookSearchArea.setText("error");
            } else {

                bookSearchArea.setText(Lib.getByKeyword(enteredSearch));
            }
        } else if (authorRadioButton.isSelected()) {

            Book g = Lib.BookAuthorMap.get(enteredSearch);

            System.out.println(g);
            if (g == null) {

                bookSearchArea.setText("error");
            } else {
                bookSearchArea.setText(Lib.BookAuthorMap.get(enteredSearch).toString());
            }

        } else if (titleRadioButton.isSelected()) {

            Book g = Lib.BookTitleMap.get(enteredSearch);

            System.out.println(g);
            if (g == null) {

                bookSearchArea.setText("error");
            } else {
                bookSearchArea.setText(Lib.BookTitleMap.get(enteredSearch).toString());
            }

        }
    }

    public void editBookButtonPressed()
    {
        System.out.println("That is not an integer, please try again.");
        bookEditedText.setVisible(false);
        System.out.println("That is not an integer, please try again.");
        String enteredSearch = editSearchField.getText();
        Book tempBook = null;

        int intISBN = Integer.parseInt(enteredSearch);
        tempBook = Lib.BookISBNMap.get(intISBN);

        editISBNField.setText(Integer.toString(tempBook.getISBN()));
        editTitleField.setText(tempBook.getTitle());
        editAuthorField.setText(tempBook.getAuthor());
        editLocationField.setText(tempBook.getLocation());

        
        if (!(editISBNField.isVisible()))
        {
            editISBNField.setVisible(true);
        editTitleField.setVisible(true);
        editAuthorField.setVisible(true);
        editLocationField.setVisible(true);
         locationLabel.setVisible(true);
        ISBNLabel.setVisible(true);
        authorLabel.setVisible(true);
        titleLabel.setVisible(true);
        }
System.out.println("That is not an integer, please try again.");
    }

    /*  LibrarianTabPane.getSelectionModel().select(editTab);
        int h =Integer.parseInt(enteredSearch);
       
     */
    public void deleteBookButtonPressed()
    {
        String ISBN = deletefield.getText();
        int foo = Integer.parseInt(ISBN);

        Lib.deleteBook(foo);

    }

    public void createBookButtonPressed()
    {
        String ISBN = createISBNField.getText();
        try {
            int foo = Integer.parseInt(ISBN);

            String Title = createTitleField.getText();

            String Author = createAuthorField.getText();

            String Location = createLocationField.getText();

            Lib.createBook(foo, Title, Author, Location);

        } catch (InputMismatchException e) {
            System.out.println("That is not an integer, please try again.");
        }
        createTitleField.setText("");
        createISBNField.setText("");
        createAuthorField.setText("");
        createLocationField.setText("");
    }

    public void editSubmitButtonPressed()
    {
        String ISBN = editISBNField.getText();

        int foo = Integer.parseInt(ISBN);
        String title = editTitleField.getText();
        String author = editAuthorField.getText();
        String location = editLocationField.getText();

        int oldISBN = Integer.parseInt(editSearchField.getText());

        Lib.editBook(oldISBN, foo, title, author, location);

        editISBNField.setText("");
        editTitleField.setText("");
        editAuthorField.setText("");
        editLocationField.setText("");
        editISBNField.setVisible(false);
        editTitleField.setVisible(false);
        editAuthorField.setVisible(false);
        editLocationField.setVisible(false);
        locationLabel.setVisible(false);
        ISBNLabel.setVisible(false);
                authorLabel.setVisible(false);
            titleLabel.setVisible(false);
        bookEditedText.setVisible(true);

    }

    public void searchReportButtonPressed()
    {
   //     System.out.println(Lib.studentBookLoanReport(userReportField.getText()));
   //     reportArea.setText(Lib.studentBookLoanReport(userReportField.getText()));
    }

    public void generateReport()
    {

     //   reportArea.setText(Lib.bookLoanReport());
    }

}
