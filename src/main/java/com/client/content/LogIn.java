package com.client.content;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogIn extends MessengerController{
    @FXML
    private TextField loginField;

    @FXML
    private Button loginButton;


    @FXML
    protected void logIn() throws IOException {
        auth(loginField.getText());
    }

    @FXML
    protected void keys() {
        loginField.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case ENTER -> {
                    try {
                        auth(loginField.getText());
                    } catch (IOException e) {
                        System.out.println("" + e);
                    }
                }
                case ESCAPE -> System.exit(1);
            }
        });
    }

    private void auth(String login) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\" + System.getProperty("user.name") + "\\IdeaProjects\\MessengerClient\\src\\main" +
                "\\java\\com\\client\\content\\idBase.txt");
        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();
        while (line != null) {
            if (login.equals(line)) {
                openMessageWindow();
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
                break;
            }
            line = reader.readLine();
        }
    }
}