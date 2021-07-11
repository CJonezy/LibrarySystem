package librarysystem;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
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

public class AdminGuiController implements Initializable
{

    @FXML
    TextField searchField;
    @FXML
    Button searchBtn;

    @FXML
    Button editBtn;

    @FXML
    Button deleteBtn;

    @FXML
    TextArea searchArea;

    @FXML
    TextField createFnameField;

    @FXML
    TextField createLNameField;

    @FXML
    TextField createUNameField;

    @FXML
    TextField createPWordField;

    @FXML
    TextField createDegreeField;

    @FXML
    TextField createCourseField;
    @FXML
    Text createDegreeText;

    @FXML
    Text createCourseText;

    @FXML
    RadioButton librarianRadioButton;
    @FXML
    RadioButton studentRadioButton;
    @FXML
    TextField editUserField;
    @FXML
    TextField editUserNameField;
    @FXML
    TextField editPasswordField;
    @FXML
    TextField editFirstNameField;
    @FXML
    TextField editLastNameField;
    @FXML
    TextField editDegreeField;
    @FXML
    TextField editCourseField;

    @FXML
    Text editDegreeText;
    @FXML
    Text uNameLabel;
    @FXML
    Text pWordLabel;
    @FXML
    Text fNameLabel;
    @FXML
    Text lNameLabel;

    @FXML
    Text editCourseText;
    @FXML
    TabPane adminTabPane;

    @FXML
    Tab editTab;

    Library Lib;

    String currentUser;

    String lastEntered;

    public Library getLib()
    {
        return Lib;
    }

    public void setLib(Library Lib)
    {
        this.Lib = Lib;
    }

    public String getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(String currentUser)
    {
        this.currentUser = currentUser;
    }

    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("AdminGui.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        //UnameTag.setText(user_id);
    }

    public void setUser(String user_id, Library libsys)
    {
        this.currentUser = user_id;
        System.out.println(user_id);

        Lib = libsys;
        Lib.setCurrentUser(user_id);
    }

    public void searchBtnPress()
    {

        String enteredSearch = searchField.getText();
        String lastEntered = searchField.getText();
        System.out.println(enteredSearch);
        searchArea.setText(Lib.getUserString(enteredSearch));
        System.out.println(Lib.getUserString(enteredSearch));
        lastEntered = searchField.getText();

    }

    public void deleteBtnPress()
    {

    }

    public void studentRadioButtonSelected()
    {
        (createDegreeField).setVisible(true);
        (createDegreeText).setVisible(true);
        (createCourseField).setVisible(true);
        (createCourseText).setVisible(true);
    }

    public void LibrarianRadioButtonSelected()
    {
        (createDegreeField).setVisible(false);
        (createDegreeText).setVisible(false);
        (createCourseField).setVisible(false);
        (createCourseText).setVisible(false);
    }

    public void editButtonPressed()
    {
        // adminTabPane.getSelectionModel().select(editTab);
        // System.out.println(lastEntered);
        String nice = editUserField.getText();
        lastEntered = nice;

        editUserNameField.setText(Lib.displayUname(nice));
        editPasswordField.setText(Lib.displayPword(nice));
        editFirstNameField.setText(Lib.displayFname(nice));
        editLastNameField.setText(Lib.displayLname(nice));

        editDegreeField.setText(Lib.displayDegree(nice));
        editCourseField.setText(Lib.displayCourse(nice));

    }

    public void onCreateButtonPress()
    {
        if (studentRadioButton.isSelected()) {
        }

        String uName = createUNameField.getText();

        String pWord = createPWordField.getText();

        String fName = createFnameField.getText();

        String lName = createLNameField.getText();

        String degree = null;
        String course = null;
        if (studentRadioButton.isSelected()) {
        }
        if (studentRadioButton.isSelected()) {

            degree = createDegreeField.getText();

            course = createCourseField.getText();

            Lib.createStudent(uName, pWord, fName, lName, degree, course);
        } else if (librarianRadioButton.isSelected()) {
            Lib.createLibrarian(uName, pWord, fName, lName);
        }

    }

    public void deleteButtonPressed()
    {
        String entered =searchField.getText();
        Lib.deleteUser(entered);
        searchArea.setText("user Deleted");
    }

    public void editSubmitButtonPressed()
    {

        String uname = editUserNameField.getText();

        String fname = editFirstNameField.getText();
        String pword = editPasswordField.getText();
        String lname = editLastNameField.getText();

        String degree = editDegreeField.getText();
        String course = editCourseField.getText();

        Lib.editStudent(lastEntered, uname, pword, fname, lname, degree, course);

        uNameLabel.setVisible(false);
        pWordLabel.setVisible(false);
        fNameLabel.setVisible(false);
        lNameLabel.setVisible(false);
        editUserNameField.setVisible(false);
        editPasswordField.setVisible(false);
        editFirstNameField.setVisible(false);
        editLastNameField.setVisible(false);
        editCourseField.setVisible(false);
        editDegreeField.setVisible(false);
    }

}
