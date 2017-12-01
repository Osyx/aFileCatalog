package common;

import java.rmi.RemoteException;

public interface ClientReacher {
    void recvMsg(String msg) throws RemoteException;
}
