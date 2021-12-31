package app.lan_files_exchanger.model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public final class NetworkAnalyser {
    private static NetworkAnalyser instance = null;
    private List<InetAddress> reachableAddress;

    /**
     * Private constructor of NetworkAnalyser
     */
    private NetworkAnalyser(){
        reachableAddress = new ArrayList<InetAddress>();
    }

    /**
     * Access to the NetworkAnalyser instance
     * @return NetworkAnalyser instance
     */
    public static NetworkAnalyser getInstance(){
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

    /**
     * Check all reachable IP address on the network
     * @return List<InetAddress>
     */
    public List<InetAddress> checkHosts(){
        int timeout=1000;
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            byte[] ip = localhost.getAddress();

            //Check all possible address
            for (int i = 1; i <= 254; i++) {
                ip[3] = (byte) i;
                InetAddress address = InetAddress.getByAddress(ip);

                if (address.isReachable(timeout)) {
                    System.out.println(address + " the machine is on and can be pinged");
                    this.reachableAddress.add(address);
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

        return this.reachableAddress;
    }

}
