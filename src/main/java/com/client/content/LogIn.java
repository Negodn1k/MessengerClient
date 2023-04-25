package com.client.content;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogIn {
    @FXML
    private TextField loginField;

    @FXML
    private Button loginButton;
    @FXML
    protected void loginButtonClick() throws IOException {
        auth(loginField.getText());
    }

    private void auth(String login) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Havka\\IdeaProjects\\MessengerClient\\src\\main" +
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

    //@Override
    private void openMessageWindow() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(LogIn.class.getResource("message.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Messenger");
        stage.setScene(scene);
        stage.show();
    }
}