package com.client.content;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    protected void friendListView() {
        ObservableList<String> list = FXCollections.observableArrayList(data.getData());
        friendList.setItems(list);
        openDialogue();
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
}
