package client.startup;

import java.rmi.RemoteException;
import client.view.View;
import

public class Startup {
    public static void main(String[] args) {
        try {
            new View();
        } catch (RemoteException ex) {
            System.out.println("Could not start client.");
        }
    }

}