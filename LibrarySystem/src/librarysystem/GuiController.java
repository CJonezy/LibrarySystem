/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.IOException;
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
import javafx.scene.Node;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Connor
 */
public class GuiController implements Initializable {

    private String user_id;
    private Library Lib;

    @FXML
    Text UnameTag;
    @FXML
    TextArea bookSearchArea;

    @FXML
    TextField bookSearchField;

    @FXML
    TextField reserveBookField;
    @FXML
    TextArea booksBorrowedArea;

    @FXML
    Button bookSearchBtn;

    @FXML
    Button reserveBtn;

    @FXML
    RadioButton keywordRadioButton;
    @FXML
    RadioButton ISBNRadioButton;
    @FXML
    RadioButton titleRadioButton;
    @FXML
    RadioButton authorRadioButton;
    @FXML
    TableView bookTable;

    @FXML
    TableColumn ISBNColumn;
    @FXML
    TableColumn titleColumn;
    @FXML
    TableColumn authorColumn;
    @FXML
    TableColumn statusColumn;
    @FXML
    TableColumn locationColumn;
    @FXML
    TableColumn ownerColumn;

    @FXML
    TableColumn ISBNRepColumn;
    @FXML
    TableColumn titleRepColumn;
    @FXML
    TableColumn authorRepColumn;
    @FXML
    TableColumn statusRepColumn;
    @FXML
    TableColumn locationRepColumn;
    @FXML
    TableColumn ownerRepColumn;

    @FXML
    TableView bookBorrowedTable;
    @FXML
    TableView bookReportTable;
    @FXML
    TableColumn ISBNBorrowedColumn;
    @FXML
    TableColumn titleBorrowedColumn;
    @FXML
    TableColumn authorBorrowedColumn;
    @FXML
    TableColumn statusBorrowedColumn;
    @FXML
    TableColumn locationBorrowedColumn;
    @FXML
    TabPane TabPane;
    @FXML
    Tab editBookTab;
    @FXML
    Tab bookReportTab;
    @FXML
    Tab createUserTab;
    @FXML
    Tab editUserTab;
    @FXML
    Tab userSearchTab;
    @FXML
    Tab booksTab;

    @FXML
    Tab bookSearchTab;

    @FXML
    Tab createBookTab;

    Collection<Tab> tabs = new ArrayList<>();
    Collection<String> openTabIds = new ArrayList<>();

    @FXML
    private void initialize() {
        tabs.add(editBookTab);
        tabs.add(bookReportTab);
        tabs.add(createUserTab);
        tabs.add(editUserTab);
        tabs.add(userSearchTab);
        tabs.add(booksTab);
        tabs.add(bookSearchTab);
        tabs.add(createBookTab);
    }

    //Librarian
    @FXML
    Button logoutBtn;
    @FXML
    Button createNewBookClearBtn;

    @FXML
    Button searhISBNToEdit;
    
    @FXML
    Button editBookButton;
    @FXML
    Button deleteBookButton;
    @FXML
    TextField editISBNField;
    @FXML
    TextField editTitleField;
    @FXML
    TextField editAuthorField;
    @FXML
    TextField editLocationField;

    @FXML
    TextField ISBNEditBookField;
    @FXML
    Button submitEditBtn;
    @FXML
    Text oldISBNText;
    @FXML
    Text createEnterDetailsTxt;

    @FXML
    Text bookhaseditedText;

    @FXML
    Text createdbookText;

    @FXML
    TextField createISBNField;
    @FXML
    TextField createTitleField;
    @FXML
    TextField createAuthorField;
    @FXML
    TextField createLocationField;

    @FXML
    Button submitBookCreateBtn;

    @FXML
    Button generateReportBtn;

    @FXML
    Button generateUserReportBtn;
    @FXML
    TextField userReportField;

    //admin
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
    TextField editCourseField;
    @FXML
    TextField editDegreeField;

    @FXML
    RadioButton studentRadioButton;

    @FXML
    RadioButton librarianRadioButton;
    @FXML
    TextField createUNameField;
    @FXML
    TextField createPWordField;
    @FXML
    TextField createFnameField;
    @FXML
    TextField createLNameField;
    @FXML
    TextField createDegreeField;
    @FXML
    TextField createCourseField;

    @FXML
    Button createUserBtn;
//user search
    @FXML
    TextField userSearchField;
    @FXML
    Button userSearchBtn;
    @FXML
    Button userCreateBtn;
    @FXML
    Button userDeleteBtn;
    @FXML
    Button userEditBtn;
    @FXML
    Button userEditSearchBtn;

    //User Table
    @FXML
    TableView userTable;

    @FXML
    TableColumn usernameColumn;
    @FXML
    TableColumn firstNameColumn;
    @FXML
    TableColumn lastNameColumn;
    @FXML
    TableColumn userTypeColumn;

    //edit
    @FXML
    Text userToEdit;
    @FXML
    Text userToEdit1;

    //create
    @FXML
    Text createDegreeText;
    @FXML
    Text createCourseText;

    @FXML
    Text userCreatedText;

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(user_id);
        UnameTag.setText(user_id);
    }

    public void setUserStudent(String user_id, Library libsys) {
        this.user_id = user_id;
        System.out.println(user_id);
        UnameTag.setText(user_id);
        Lib = libsys;
        Lib.setCurrentUser(user_id);
        TabPane.getTabs().remove(0);
        TabPane.getTabs().remove(0);
        TabPane.getTabs().remove(0);
        TabPane.getTabs().remove(0);
        TabPane.getTabs().remove(0);
        TabPane.getTabs().remove(0);
    }

    public void setUserLibrarian(String user_id, Library libsys) {
        this.user_id = user_id;
        System.out.println(user_id);
        UnameTag.setText(user_id);
        Lib = libsys;
        Lib.setCurrentUser(user_id);
        TabPane.getTabs().remove(0);
        TabPane.getTabs().remove(0);
        TabPane.getTabs().remove(0);

        reserveBtn.setVisible(false);

    }

    public void setUserAdmin(String user_id, Library libsys) {
        this.user_id = user_id;
        System.out.println(user_id);
        UnameTag.setText(user_id);
        Lib = libsys;
        Lib.setCurrentUser(user_id);
        TabPane.getTabs().remove(6);
        TabPane.getTabs().remove(5);
        TabPane.getTabs().remove(4);
        TabPane.getTabs().remove(3);
    }

    public void studentGui() {
        TabPane.getTabs().remove(0);
        TabPane.getTabs().remove(1);

    }

    public void libGui() {
        TabPane.getTabs().remove(0);
    }

    public void adminGui() {
        TabPane.getTabs().remove(0);
    }

    public void bookSearchBtnPress() {

        String enteredSearch = bookSearchField.getText();
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

    public void reserve() {
        ObservableList<Book> BookList;
        BookList = bookTable.getSelectionModel().getSelectedItems();

        int ISBN = BookList.get(0).getISBN();
        boolean reserved = BookList.get(0).getReserved();
        if (reserved == false) {

            boolean reserveTheBook = Lib.reserveBook(ISBN);

        }
        tableView();

    }

    public void createBook() {
        String ISBN = createISBNField.getText();

        int newISBN = Integer.parseInt(ISBN);

        String newTitle = createTitleField.getText();
        String newAuthor = createAuthorField.getText();
        String newLocation = createLocationField.getText();

        Lib.createBook(newISBN, newTitle, newAuthor, newLocation);
        createISBNField.setText("");
        createTitleField.setText("");
        createAuthorField.setText("");
        createLocationField.setText("");
        createdbookText.setVisible(true);
        createNewBookClearBtn.setVisible(true);

    }

    public void createNewBookBtnPress() {
        createdbookText.setVisible(false);
        createNewBookClearBtn.setVisible(false);
        createISBNField.setText("");
        createTitleField.setText("");
        createAuthorField.setText("");
        createLocationField.setText("");

    }

    public void editBook() {

        ObservableList<Book> BookList;
        BookList = bookTable.getSelectionModel().getSelectedItems();
        ISBNEditBookField.setVisible(false);
        searhISBNToEdit.setVisible(false);
        bookhaseditedText.setVisible(false);
        int ISBN = BookList.get(0).getISBN();

        Book g = Lib.BookISBNMap.get(ISBN);

        TabPane.getSelectionModel().select(editBookTab);
        editISBNField.setText(Integer.toString(g.getISBN()));
        editTitleField.setText(g.getTitle());
        editAuthorField.setText(g.getAuthor());
        editLocationField.setText(g.getLocation());
        oldISBNText.setText(Integer.toString(g.getISBN()));

    }

    public void editBookSearh() {
        bookhaseditedText.setVisible(false);
        String isbn = ISBNEditBookField.getText();
        try {
            int ISBN = Integer.parseInt(isbn);

            Book g = Lib.BookISBNMap.get(ISBN);

            if (g != null) {
                ISBNEditBookField.setVisible(false);
                searhISBNToEdit.setVisible(false);

                editISBNField.setText(Integer.toString(g.getISBN()));
                editTitleField.setText(g.getTitle());
                editAuthorField.setText(g.getAuthor());
                editLocationField.setText(g.getLocation());
                oldISBNText.setText(Integer.toString(g.getISBN()));
            }

        } catch (NumberFormatException e) {

        }

    }

    public void submitEdit() {

        String ISBN = editISBNField.getText();

        try {
            int newISBN = Integer.parseInt(ISBN);

            String newTitle = editTitleField.getText();
            String newAuthor = editAuthorField.getText();
            String newLocation = editLocationField.getText();
            int oldISBN = Integer.parseInt(oldISBNText.getText());

            Lib.editBook(oldISBN, newISBN, newTitle, newAuthor, newLocation);
            bookhaseditedText.setVisible(true);
            editISBNField.setText("");
            editTitleField.setText("");
            editAuthorField.setText("");
            editLocationField.setText("");
            oldISBNText.setText("no book");
            ISBNEditBookField.setVisible(false);
            searhISBNToEdit.setVisible(false);

        } catch (NumberFormatException e) {

        }
    }

    public void deleteBook() {
        ObservableList<Book> BookList;
        BookList = bookTable.getSelectionModel().getSelectedItems();

        int ISBN = BookList.get(0).getISBN();
        Lib.deleteBook(ISBN);
        tableView();
    }

    public void tableView() {
        String enteredSearch = bookSearchField.getText();

        ISBNColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("reserved"));

        locationColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("location"));

        if (keywordRadioButton.isSelected()) {
            ObservableList<Book> bookData = Lib.getObservableBookListKeyword(enteredSearch);
            bookTable.setItems(bookData);
        } else if (authorRadioButton.isSelected()) {
            ObservableList<Book> bookData = Lib.getObservableBookListAuthor(enteredSearch);
            bookTable.setItems(bookData);

        } else if (titleRadioButton.isSelected()) {
            ObservableList<Book> bookData = Lib.getObservableBookListTitle(enteredSearch);
            bookTable.setItems(bookData);

        }
        if (ISBNRadioButton.isSelected()) {
            try {

                int intISBN = Integer.parseInt(enteredSearch);
                ObservableList<Book> bookData = Lib.getObservableBookListISBN(intISBN);
                bookTable.setItems(bookData);
            } catch (NumberFormatException ex) {

            }

        }

    }

    public void reserveBtnPress() {
        System.out.println(user_id);
        String enteredSearch = reserveBookField.getText();
        System.out.println(user_id);
        int intISBN = Integer.parseInt(enteredSearch);
        System.out.println(intISBN);
        System.out.println(user_id);
        boolean h = Lib.reserveBook(intISBN);
        System.out.println(h);;
        if (h == false) {
            bookSearchArea.setText("book already owned");

        }

    }

    public void generateReport() {
        ISBNRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
        authorRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        titleRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        statusRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("reserved"));
        locationRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("location"));
        ownerRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("owner"));

        ObservableList<Book> bookData = Lib.getObservableBookListKeyword("");
        bookReportTable.setItems(bookData);

    }

    public void generateStudentReport() {

        ISBNRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
        authorRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        titleRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        statusRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("reserved"));
        locationRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("location"));
        ownerRepColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("owner"));
        String uname = userReportField.getText();
        ObservableList<Book> bookData = Lib.studentBookLoanReport(uname);
        bookReportTable.setItems(bookData);
    }

    public void menuBorrowedChange() {

        ISBNBorrowedColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
        authorBorrowedColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        titleBorrowedColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));

        locationBorrowedColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("location"));
        ObservableList<Book> bookData = Lib.booksBorrowed();
        bookBorrowedTable.setItems(bookData);

    }

    public void userTableView() {
        String enteredSearch = userSearchField.getText();

        usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<User, String>("UserType"));

        ObservableList<User> userData = Lib.getAllUsers();
        userTable.setItems(userData);

    }

    public void deleteUser() {
        ObservableList<User> userList;
        userList = userTable.getSelectionModel().getSelectedItems();

        String uname = userList.get(0).getUsername();
        if(!(uname.equals(Lib.getCurrentUser()))){
        Lib.deleteUser(uname);
        userTableView();}

    }

    public void editUser() {
        ObservableList<User> userList;
        userList = userTable.getSelectionModel().getSelectedItems();

        String uname = userList.get(0).getUsername();
        userToEdit.setText(uname);
        userToEdit1.setText(uname);
        Lib.isLibrarian(uname);
        TabPane.getSelectionModel().select(editUserTab);
        if (Lib.isLibrarian(uname)) {
            editUserNameField.setText(Lib.displayUname(uname));
            editPasswordField.setText(Lib.displayPword(uname));
            editFirstNameField.setText(Lib.displayFname(uname));
            editLastNameField.setText(Lib.displayLname(uname));

        } else if (Lib.isStudent(uname)) {
            editUserNameField.setText(Lib.displayUname(uname));
            editPasswordField.setText(Lib.displayPword(uname));
            editFirstNameField.setText(Lib.displayFname(uname));
            editLastNameField.setText(Lib.displayLname(uname));
            editDegreeField.setText(Lib.displayDegree(uname));
            editCourseField.setText(Lib.displayCourse(uname));

        }
    }

    public void searchEditUser() {
        String uname = editUserField.getText();
        userToEdit.setText(uname);
        Lib.isLibrarian(uname);
        TabPane.getSelectionModel().select(editUserTab);
        if (Lib.isLibrarian(uname)) {
            editUserNameField.setText(Lib.displayUname(uname));
            editPasswordField.setText(Lib.displayPword(uname));
            editFirstNameField.setText(Lib.displayFname(uname));
            editLastNameField.setText(Lib.displayLname(uname));

        } else if (Lib.isStudent(uname)) {
            editUserNameField.setText(Lib.displayUname(uname));
            editPasswordField.setText(Lib.displayPword(uname));
            editFirstNameField.setText(Lib.displayFname(uname));
            editLastNameField.setText(Lib.displayLname(uname));
            editDegreeField.setText(Lib.displayDegree(uname));
            editCourseField.setText(Lib.displayCourse(uname));

        }
        userToEdit1.setText(uname);
        editUserField.setText("");
          userToEdit.setText("");
    }

    public void submitUserEdit() {
        String oldUname = userToEdit1.getText();

        String username = editUserNameField.getText();
        String password = editPasswordField.getText();
        String fName = editFirstNameField.getText();
        String lName = editLastNameField.getText();

        if (Lib.isStudent(oldUname)) {
            String degree = editDegreeField.getText();
            String course = editCourseField.getText();
            Lib.editStudent(oldUname, username, password, fName, lName, degree, course);
            userToEdit.setVisible(true);
            userToEdit.setText("User edited");
        } else if (Lib.isLibrarian(oldUname)) {
            Lib.editLibrarian(oldUname, username, password, fName, lName);
            userToEdit.setVisible(true);
             userToEdit.setText("User edited");
        } else {
            userToEdit.setVisible(true);
            userToEdit.setText("unable to edit");
        }
        editUserNameField.setText("");
        editPasswordField.setText("");
        editFirstNameField.setText("");
        editLastNameField.setText("");
        editDegreeField.setText("");
        editCourseField.setText("");
        userToEdit1.setText("");
    }
    public void clickCreateTab()
    {
      
     
       createUNameField.setText("");

          createPWordField.setText("");

          createFnameField.setText("");

       createLNameField.setText("");
       createDegreeField.setText("");

          createCourseField.setText("");
            userCreatedText.setText("");
    }

    public void createUser() {
        TabPane.getSelectionModel().select(createUserTab);

    }

    public void createUserSubmit() {

        String uName = createUNameField.getText();

        String pWord = createPWordField.getText();

        String fName = createFnameField.getText();

        String lName = createLNameField.getText();

        if (librarianRadioButton.isSelected()) {

            Lib.createLibrarian(uName, pWord, fName, lName);
              userCreatedText.setText("User Created");
        }

        if (studentRadioButton.isSelected()) {

            String degree = createDegreeField.getText();

            String course = createCourseField.getText();

            Lib.createStudent(uName, pWord, fName, lName, degree, course);
            userCreatedText.setText("User Created");
        }
         
    }
   public void searchByUsername(){
       
        String enteredSearch = userSearchField.getText();

        usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        userTypeColumn.setCellValueFactory(new PropertyValueFactory<User, String>("UserType"));

        
        ObservableList<User> userData = Lib.getUserforTable(enteredSearch);
        userTable.setItems(userData);
       
   }

    public void studentRadioButtonSelected() {
        (createDegreeField).setVisible(true);
        (createDegreeText).setVisible(true);
        (createCourseField).setVisible(true);
        (createCourseText).setVisible(true);
    }

    public void LibrarianRadioButtonSelected() {
        (createDegreeField).setVisible(false);
        (createDegreeText).setVisible(false);
        (createCourseField).setVisible(false);
        (createCourseText).setVisible(false);
    }
     public void logout(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginGui.fxml"));

        Parent root = (Parent) fxmlLoader.load();

        LoginGuiController controller = fxmlLoader.<LoginGuiController>getController();
      
        controller.setLib(Lib);
       
        Scene scene = new Scene(root);

        Stage GuiStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        GuiStage.setScene(scene);
        

        GuiStage.show();

    }
     

}
