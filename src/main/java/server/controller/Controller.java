package server.controller;

import java.io.File;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import common.UserError;

import common.*;
import server.model.User;
import server.model.UserManager;
import sun.rmi.runtime.Log;

public class Controller extends UnicastRemoteObject implements ServerReacher {

    private final UserManager userManager = new UserManager();

    public Controller() throws RemoteException {}

    @Override
    public String logIn(ClientReacher remoteObject, LogInDetails lid ) throws UserError{
    return "logged in";
    }

    @Override
    public void logOut(LogInDetails lgn){

    }

    @Override
    public void register(ClientReacher remoteObject, LogInDetails lgn) throws UserError{
        userManager.createUser(remoteObject, lgn);
    }

    @Override
    public void unRegister(LogInDetails lid ) throws UserError {

    }
    @Override
    public void fileUpload(File file,LogInDetails lid ) throws FileError{

    }

    @Override
    public File fileDownload(String fileName, LogInDetails lgn) throws FileError, UserError {
        return new File("at.txt");
    }

    @Override
    public void setNotification(boolean notify, String file, LogInDetails lid) throws FileError, UserError {

    }

    public void deleteFile(String file, LogInDetails lid ) throws FileError, UserError {

    }

    public void setPrivate(boolean priv, LogInDetails lid ) throws UserError {

    }



    private void startRegistry() throws RemoteException {
        try {
            LocateRegistry.getRegistry().list();
        } catch (RemoteException noRegistryIsRunning) {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        }
    }
}