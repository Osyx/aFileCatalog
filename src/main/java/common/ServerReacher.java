package common;


import server.model.User;

import java.io.File;

public interface ServerReacher {
    public static final String NAME_OF_SERVER = "FileServer";

    String logIn(ClientReacher remoteObject, LogInDetails lid );

    void logOut(String username);

    void register(ClientReacher remoteObject, LogInDetails);

    void unRegister(String username);

    void fileUpload(File file, String username);

    File fileDownload(String fileName, String username);

    void setNotification(boolean notify, String file, String username);

    void deleteFile(String file, String username);

    void setPrivate(boolean priv, String username);


}
