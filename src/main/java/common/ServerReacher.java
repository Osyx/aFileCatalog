package common;


import server.model.User;

import java.io.File;

public interface ServerReacher {
    public static final String NAME_OF_SERVER = "FileServer";

    String logIn(ClientReacher remoteObject, LogInDetails lid ) throws UserError;

    void logOut(LogInDetails lid );

    void register(ClientReacher remoteObject, LogInDetails lgn) throws UserError;

    void unRegister(LogInDetails lid ) throws UserError;

    void fileUpload(File file, LogInDetails lid ) throws FileError;


    void setNotification(boolean notify, String file, LogInDetails lid ) throws FileError, UserError;

    void deleteFile(String file, LogInDetails lid) throws  FileError, UserError ;

    void setPrivate(boolean priv, LogInDetails lid ) throws UserError;

    File fileDownload(String fileName, LogInDetails lid ) throws UserError, FileError;



}
