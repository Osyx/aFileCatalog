package server.controller;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import common.Hello;

public class Controller implements Hello {

    public Controller() {}

    public String sayHello() {
        return "Hello, world!";
    }

    public static void main(String args[]) {

        try {
            Controller obj = new Controller();
            obj.startRegistry();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private void startRegistry() throws RemoteException {
        try {
            LocateRegistry.getRegistry().list();
        } catch (RemoteException noRegistryIsRunning) {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        }
    }
}