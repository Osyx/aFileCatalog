package client.startup;

import java.rmi.RemoteException;
import client.view.View;

public class Startup {
    public static void main(String[] args) {
        try {
            System.out.print("creating new view...");
            View view = new View();
            System.out.println("done");
            System.out.print("starting view...");
            view.start();
            System.out.println("done");
        } catch (RemoteException ex) {
            System.out.println("Could not start client.");
        }
    }

}