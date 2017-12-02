package common;


import java.io.File;

public interface ServerReacher {
    String NAME_OF_SERVER = "FileServer";

    void logIn(ClientReacher remoteObject, LogInDetails lid ) throws UserError;

    void logOut(LogInDetails lid );

    void register(LogInDetails lgn) throws UserError;

    void unRegister(LogInDetails lid ) throws UserError;

    void fileUpload(File file, LogInDetails lid ) throws FileError, UserError;

    void fileUpload(File file, boolean privateAccess, boolean writePermission, LogInDetails lid) throws FileError, UserError;

    void setNotification(boolean notify, String file, LogInDetails lid ) throws FileError, UserError;

    void deleteFile(String file, LogInDetails lid) throws  FileError, UserError ;

    void togglePrivate(String fileName, LogInDetails lid) throws UserError, FileError;

    File fileDownload(String fileName, LogInDetails lid ) throws UserError, FileError;

}
