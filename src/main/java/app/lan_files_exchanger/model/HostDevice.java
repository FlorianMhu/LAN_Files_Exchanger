package app.lan_files_exchanger.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class used to define a host device
 */
public class HostDevice {

    private final StringProperty hostName;

    private final StringProperty hostAddress; //to be converted from InetAddress

    /**
     * Default constructor.
     */
    public HostDevice() {
        this(null, null);
    }

    /**
     * Constructor for the HostDevice class
     * @param name of the host device
     * @param address of the host device
     */
    public HostDevice(String name, String address) {
        this.hostName = new SimpleStringProperty(name);
        this.hostAddress = new SimpleStringProperty(address);
    }

    /**
     * Getter for the host device name
     * @return the name of the host device
     */
    public String getHostName() {
        return hostName.get();
    }

    /**
     * Setter for the host device name
     * @param name of the host device
     */
    public void setHostName(String name) {
        this.hostName.set(name);
    }

    /**
     *
     * @return the string property name of the host device
     */
    public StringProperty hostNameProperty() {
        return hostName;
    }

    /**
     * Getter for the host device address
     * @return the address of the host device
     */
    public String getHostAddress() {
        return hostAddress.get();
    }

    /**
     * Setter for the host device address
     * @param address of the host device
     */
    public void setHostAddress(String address) {
        this.hostAddress.set(address);
    }

    /**
     *
     * @return the string property address of the host device
     */
    public StringProperty hostAddressProperty() {
        return hostAddress;
    }
}
