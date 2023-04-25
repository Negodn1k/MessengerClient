package com.client.content;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MessengerController {
    Data data = new Data();

    @FXML
    ListView<String> friendList;
    @FXML
    protected void friendListView() {
        ObservableList<String> list = FXCollections.observableArrayList(data.getData());
        friendList.setItems(list);
    }
}
