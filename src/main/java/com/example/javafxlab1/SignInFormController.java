package com.example.javafxlab1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SignInFormController {
    @FXML
    private Button signin;
    @FXML
    private Button resetpsswd;
    @FXML
    private Button signup;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label welcomeText;

    public ArrayList<String> string = new ArrayList<>();

    public int status = 3;

    @FXML
    protected void onLoginButtonClick() {
        try {
            if ((!Objects.equals(username.getText(), "") || !Objects.equals(password.getText(), "")) && (this.status != 0)) {
                try {
                    Scanner myReader = new Scanner(new File("file.txt"));
                    while (myReader.hasNextLine()) {
                        String data = myReader.next();
                        string.add(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                if (username.getText().equals(this.string.get(0)) && password.getText().equals(this.string.get(1))) {
                    welcomeText.setText("Welcome " + username.getText());
                } else {
                    this.status--;
                    System.out.println(this.status);
                    welcomeText.setText("Invalid username or password");
                }
            } else {
                welcomeText.setText("Input your username and password!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println(this.string);
    }

    @FXML
    protected void onResetPasswordButtonClick() {
        try {
            this.string.clear();
            File myObj = new File("file.txt");
            if (myObj.exists()) {
                try {
                    if (myObj.delete()) {
                        System.out.println("Deleted the file: " + myObj.getName());
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("File does not exist");
            }
            welcomeText.setText("Password reset successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println(this.string);
    }

    @FXML
    protected void onSignUpButtonClick() throws IOException {
        SignUpFormApplication signUpFormApplication = new SignUpFormApplication();
        signUpFormApplication.start(new Stage());
    }
}