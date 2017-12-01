package server.controller;

import java.io.File;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.ClientReacher;
import common.Hello;
import common.LogInDetails;
import common.ServerReacher;

public class Controller extends UnicastRemoteObject implements ServerReacher {

    public Controller() throws RemoteException {}

    @Override
    String logIn(ClientReacher remoteObject, LogInDetails lid ){
    return "";
    }

    public void logOut(String username);

    void register(ClientReacher remoteObject, LogInDetails);

    void unRegister(String username);

    void fileUpload(File file, String useranem);

    File fileDownload(String username);

    void setNotification(boolean notify, String file, String username);

    void deleteFile(String file, String username);

    void setPrivate(boolean priv, String username);

    public static void main(String args[]) {

        try {
            Controller obj = new Controller();
            obj.startRegistry();
           // Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
           // registry.bind("Hello", stub);

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