package app.lan_files_exchanger.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import app.lan_files_exchanger.model.NetworkAnalyser;

public class RootLayoutController {
    @FXML
    private void fileMenu_onCloseClicked() {
        Platform.exit();
    }

    @FXML
    private void editMenu_onRefreshClicked() {
        NetworkAnalyser networkAnalyser = NetworkAnalyser.getInstance();
        networkAnalyser.checkHosts();
    }
}
