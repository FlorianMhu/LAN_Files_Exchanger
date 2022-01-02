package app.lan_files_exchanger.controllers;

import app.lan_files_exchanger.MainApp;
import app.lan_files_exchanger.model.HostDevice;
import app.lan_files_exchanger.model.HostDeviceObsList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LANFilesExchangerController {
    @FXML
    private void onBtnSendFilesClicked(ActionEvent event) {System.out.println("Send Files clicked");    }

    @FXML
    private TableView<HostDevice> hostDeviceTable;
    @FXML
    private TableColumn<HostDevice,String> hostNameColumn;
    @FXML
    private TableColumn<HostDevice,String> hostAddressColumn;

    // Reference to the list of devices
    private HostDeviceObsList hostDeviceObsList;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LANFilesExchangerController() {
        hostDeviceObsList = HostDeviceObsList.getInstance();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the host device table with the two columns.
        hostNameColumn.setCellValueFactory(cellData -> cellData.getValue().hostNameProperty());
        hostAddressColumn.setCellValueFactory(cellData -> cellData.getValue().hostAddressProperty());
        hostDeviceTable.setItems(hostDeviceObsList.getHostDeviceObsList());
    }
}
