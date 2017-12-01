package client.view;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.ClientReacher;
import common.Hello;

public class View implements Runnable{

    private final ClientReacher remoteObject;
    public boolean stillReceiving = false;


    public View() throws RemoteException {
        remoteObject = new Output();
    }

    public void start {
        if
    }



    private class Output extends UnicastRemoteObject implements ClientReacher{
        public Output() throws RemoteException{

        }
        @Override
        public void receivedMessage(String message) {
            Console.Output(message);
        }
    }
}


