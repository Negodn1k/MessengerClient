module com.example.messengerclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.client.content to javafx.fxml;
    exports com.client.content;
}