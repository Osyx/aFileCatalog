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
import server.model.UserManager;

public class Controller extends UnicastRemoteObject implements ServerReacher {

    private final UserManager userManager = new UserManager();

    public Controller() throws RemoteException {}

    @Override
    public String logIn(ClientReacher remoteObject, LogInDetails lid ){
    return "logged in";
    }

    public void logOut(String username){
            userManager
    }

    public void register(ClientReacher remoteObject, LogInDetails){

    }

    public void unRegister(String username) {

    }

    public void fileUpload(File file, String username) {

    }

    public File fileDownload(String username) {

    }

    public void setNotification(boolean notify, String file, String username) {

    }

    public void deleteFile(String file, String username) {

    }

    public void setPrivate(boolean priv, String username) {

    }

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