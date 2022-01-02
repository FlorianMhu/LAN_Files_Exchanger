package app.lan_files_exchanger.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class HostDeviceObsList {
    private static HostDeviceObsList instance = null;

    /**
     * The data as an observable list of HostDevice
     */
    private ObservableList<HostDevice> hostDeviceObsList;

    /**
     * Private constructor of HostDeviceObsList
     */
    private HostDeviceObsList(){
        this.hostDeviceObsList = FXCollections.observableArrayList();
    }

    /**
     * Access to the HostDeviceObsList instance
     * We need to synchronize the instance
     * @return HostDeviceObsList instance
     */
    public static synchronized HostDeviceObsList getInstance(){
        if(instance == null){
            instance = new HostDeviceObsList();
        }
        return instance;
    }

    /**
     * Return the observable list of host devices
     * @return hostDevices
     */
    public ObservableList<HostDevice> getHostDeviceObsList(){
        return hostDeviceObsList;
    }

    public void addHostDevice(String hostName,String hostAddress){
        hostDeviceObsList.add(new HostDevice(hostName,hostAddress));
    }

}
