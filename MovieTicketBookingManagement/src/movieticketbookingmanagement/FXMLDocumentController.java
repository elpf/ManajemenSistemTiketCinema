/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package movieticketbookingmanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.sql.SQLException;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;


/**
 *
 * @author Elga
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button signin_close;

    @FXML
    private Hyperlink signin_createAccount;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private Button signin_minimize;

    @FXML
    private PasswordField signin_password;

    @FXML
    private Button signin_signinBtn;

    @FXML
    private TextField signin_username;

    @FXML
    private Hyperlink signup_alreadyHaveAnAccount;

    @FXML
    private Button signup_close;

    @FXML
    private TextField signup_email;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private Button signup_minimize;

    @FXML
    private PasswordField signup_password;

    @FXML
    private Button signup_signupBtn;

    @FXML
    private TextField signup_username;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public boolean validEmail() {
        //     el_f@gmail.com                                       [first letter] [second letter -> @] [@] [safsd] [.] [com]
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");

        Matcher match = pattern.matcher(signup_email.getText());

        Alert alert;

        if (match.find() && match.group().matches(signup_email.getText())) {

            return true;

        } else {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email");
            alert.showAndWait();

            return false;

        }
        

    }

    public boolean isEmailAlreadyExists(String email) throws SQLException {
        String selectEmailSQL = "SELECT email FROM admin WHERE email = ?";

        try (PreparedStatement emailPrepare = connect.prepareStatement(selectEmailSQL)) {
            emailPrepare.setString(1, email);
            ResultSet emailResult = emailPrepare.executeQuery();

            return emailResult.next(); // Return true if email already exists
        }
    }
    
    public void signup() {
        String insertSQL = "INSERT INTO admin (email, username, password) VALUES (?, ?, ?)";
        String selectSQL = "SELECT username FROM admin WHERE username = ?";

        connect = database.connectDb();
        Alert alert;

        try {
            // Validasi input
            if (signup_email.getText().isEmpty() || signup_username.getText().isEmpty()
                    || signup_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
                return;
            }

            if (signup_password.getText().length() < 8) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please input a password with a minimum of 8 characters");
                alert.showAndWait();
                return;
            }

            // Validasi email
            if (!validEmail()) {
                return;
            }

            // Pemeriksaan apakah email sudah ada
            if (isEmailAlreadyExists(signup_email.getText())) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(signup_email.getText() + " already exists!");
                alert.showAndWait();
                return;
            }

            // Pemeriksaan apakah username sudah ada
            try (PreparedStatement usernamePrepare = connect.prepareStatement(selectSQL)) {
                usernamePrepare.setString(1, signup_username.getText());
                ResultSet result = usernamePrepare.executeQuery();

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(signup_username.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    // Eksekusi query INSERT
                    try (PreparedStatement prepare = connect.prepareStatement(insertSQL)) {
                        prepare.setString(1, signup_email.getText());
                        prepare.setString(2, signup_username.getText());
                        prepare.setString(3, signup_password.getText());

                        prepare.execute();

                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully created a new account!");
                        alert.showAndWait();

                        // Setelah berhasil, membersihkan input
                        signup_email.setText("");
                        signup_username.setText("");
                        signup_password.setText("");
                    }
                }
            }
        } catch (SQLException e) {
            // Penanganan kesalahan SQL
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Error executing SQL query: " + e.getMessage());
            alert.showAndWait();
        } catch (Exception e) {
            // Penanganan kesalahan umum
            e.printStackTrace();
        } finally {
            // Tutup koneksi
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
 
    
    private double x = 0;
    private double y = 0;

    public void signin() {
        String sql = "SELECT * FROM admin where username = ? and password = ?";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, signin_username.getText());
            prepare.setString(2, signin_password.getText());

            result = prepare.executeQuery();

            Alert alert;

            if (signin_username.getText().isEmpty() || signin_password.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {

                if (result.next()) {

                    getData.username = signin_username.getText();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();

                    //to hide the login form
                    signin_signinBtn.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });
                    
                    root.setOnMouseDragged((MouseEvent event) -> {
                    
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });
                    
                    stage.initStyle(StageStyle.TRANSPARENT);
                    
                    stage.setScene(scene);
                    stage.show();
                } else {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    
    private void clearFields() {
        // Membersihkan input field pada kedua form
        signin_username.setText("");
        signin_password.setText("");
        signup_email.setText("");
        signup_username.setText("");
        signup_password.setText("");
    }

    public void switchForm(ActionEvent event) {
        clearFields();
        if (event.getSource() == signin_createAccount) {
            signin_form.setVisible(false);
            signup_form.setVisible(true);
            
        } else if (event.getSource() == signup_alreadyHaveAnAccount) {
            signin_form.setVisible(true);
            signup_form.setVisible(false);
        }

    }

    public void signIn_close() {
        System.exit(0);
    }

    public void signIn_minimize() {
        Stage stage = (Stage) signin_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void signUp_close() {
        System.exit(0);
    }

    public void signUp_minimize() {
        Stage stage = (Stage) signup_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
