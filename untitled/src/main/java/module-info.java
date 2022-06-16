module main {
    requires javafx.controls;
    requires javafx.fxml;


    opens main to javafx.fxml;
    exports main;
    exports main.client;
    opens main.client to javafx.fxml;
}