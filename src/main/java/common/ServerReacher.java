package common;


import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerReacher extends Remote {
    String NAME_OF_SERVER = "FileServer";

    String logIn(ClientReacher remoteObject, LogInDetails lid ) throws UserError, RemoteException;

    void logOut(LogInDetails lid ) throws RemoteException;

    String register(LogInDetails lgn) throws UserError, RemoteException;

    void unRegister(LogInDetails lid ) throws UserError, RemoteException;

    void fileUpload(File file, LogInDetails lid ) throws FileError, UserError, RemoteException;

    void fileUpload(File file, boolean privateAccess, boolean writePermission, LogInDetails lid) throws FileError, UserError, RemoteException;

    void setNotification(boolean notify, String file, LogInDetails lid ) throws FileError, UserError, RemoteException;

    void deleteFile(String file, LogInDetails lid) throws  FileError, UserError, RemoteException;

    void togglePrivate(String fileName, LogInDetails lid) throws UserError, FileError, RemoteException;

    File fileDownload(String fileName, LogInDetails lid ) throws UserError, FileError, RemoteException;

}
