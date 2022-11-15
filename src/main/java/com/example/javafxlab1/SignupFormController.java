package com.example.javafxlab1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SignupFormController {

    @FXML
    private Label welcomeText;
    @FXML
    private Button signup;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private TextField fullname;

    @FXML
    private PasswordField confirmPassword;

//    public ArrayList<String> string = new ArrayList<>();

    @FXML
    protected void onSignUpButtonClick() {
        try {
            if (username.getText().equals("") || password.getText().equals("") || fullname.getText().equals("") || confirmPassword.getText().equals("")) {
                welcomeText.setText("Please fill in all the fields!");
            } else if (!password.getText().equals(confirmPassword.getText())) {
                welcomeText.setText("Password and confirm password do not match!");
            } else {
                try {
                    FileWriter myWriter = new FileWriter("file.txt");
                    myWriter.write(username.getText() + " " + password.getText() + " " + fullname.getText());
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                welcomeText.setText("Sign up successfully!");
//                Stage stage = (Stage) signup.getScene().getWindow();
//                stage.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
