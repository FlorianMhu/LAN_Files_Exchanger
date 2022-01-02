package app.lan_files_exchanger.model;

import app.lan_files_exchanger.MainApp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public final class NetworkAnalyser extends Thread {
    private static NetworkAnalyser instance = null;

    private List<InetAddress> reachableAddress;

    private HostDeviceObsList hostDevices;

    /**
     * Private constructor of NetworkAnalyser
     */
    private NetworkAnalyser(){
        reachableAddress = new ArrayList<InetAddress>();
        hostDevices = HostDeviceObsList.getInstance();
    }

    /**
     * Access to the NetworkAnalyser instance
     * @return NetworkAnalyser instance
     */
    public static synchronized NetworkAnalyser getInstance(){
        if(instance == null){
            instance = new NetworkAnalyser();
        }
        return instance;
    }

    /**
     * Return the name of the given host address
     * @param address of the host
     * @return name of the host
     */
    public String getHostName(InetAddress address){
        return address.getHostName();
    }

    /**
     * Get the list of reachableAddress
     * @return List of reachableAddress
     */
    public List<InetAddress> getReachableAddress(){
        return reachableAddress;
    }

    public void run(){
        int timeout=1000;
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            byte[] ip = localhost.getAddress();

            //Check all possible address
            for (int i = 1; i <= 30; i++) {
                ip[3] = (byte) i;
                InetAddress address = InetAddress.getByAddress(ip);

                if (address.isReachable(timeout)) {

                    System.out.println(address + " the machine is on and can be pinged");
                    this.reachableAddress.add(address);
                    hostDevices.addHostDevice(getHostName(address),address.getHostAddress()); //Add name and address of the host device to the observable list

                } else if (!address.getHostAddress().equals(address.getHostName())) {
                    System.out.println(address + " machine recognized by a DNSLookup");
                } else {
                    System.out.println(address + " the host address and host name are the same, the host name cannot be resolved");
                }
            }
        }
        catch (UnknownHostException e){
            System.out.println("IP address of the host can't be determined");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Network error occurred");
            e.printStackTrace();
        }
    }

    /**
     * Check all reachable IP address on the network
     * @return List<InetAddress>
     */
    public void checkHosts(){
        if (this.isAlive()) {
            this.interrupt();
            System.out.println("Interruption pinged at the networked device search thread");
        }
        else {
            this.start();
        }
    }



}
