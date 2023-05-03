package com.client.content;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MessengerController {
    private final Data data = new Data();

    ObservableList<String> list = FXCollections.observableArrayList();

    @FXML
    private TextField messageField;

    @FXML
    private ListView<String> messageHistory;

    @FXML
    private SplitPane dialogue;

    @FXML
    private Label name;

    @FXML
    private ListView<String> friendList;

    @FXML
    protected void messengerView() {
        ObservableList<String> list = FXCollections.observableArrayList(data.getData());
        friendList.setItems(list);

        openDialogue();
        keyFunctions();
    }

    private void openDialogue() {
        friendList.setPrefSize(250,150);
        MultipleSelectionModel<String> friendListSelectionModel = friendList.getSelectionModel();
        friendListSelectionModel.selectedItemProperty().addListener((observableValue, s, t1) -> {
            name.setText(t1);
            dialogue.setVisible(true);
        });
    }

    @FXML
    protected void sendButtonClick() {
        list.add(messageField.getText());
        messageHistory.setItems(list);
        messageField.clear();
    }

    private void keyFunctions() {
        messageField.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case ENTER -> sendButtonClick();
                case ESCAPE -> dialogue.setVisible(false);
            }
        });
    }

    public void openMessageWindow() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(LogIn.class.getResource("message.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Messenger");
        stage.setScene(scene);
        stage.show();
    }
}
