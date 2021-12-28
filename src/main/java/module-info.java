module app.lan_files_exchanger {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.lan_files_exchanger to javafx.fxml;
    exports app.lan_files_exchanger;
}