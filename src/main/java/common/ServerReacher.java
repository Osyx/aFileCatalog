package common;


import server.model.User;

import java.io.File;

public interface ServerReacher {
    public static final String NAME_OF_SERVER = "FileServer";

    String logIn(ClientReacher remoteObject, LogInDetails lid );

    void logOut(LogInDetails lid );

    void register(ClientReacher remoteObject, LogInDetails lgn);

    void unRegister(LogInDetails lid );

    void fileUpload(File file, LogInDetails lid );

    File fileDownload(String fileName, LogInDetails lid );

    void setNotification(boolean notify, String file, LogInDetails lid );

    void deleteFile(String file, LogInDetails lid) ;

    void setPrivate(boolean priv, LogInDetails lid );


}
