package client.view;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.ClientReacher;
import common.Hello;

public class View {

    private final ClientReacher remoteObject;


    public View() throws RemoteException {
        remoteObject = new Output();
    }

    private class Output extends UnicastRemoteObject implements ClientReacher{
        public Output() throws RemoteException{

        }

        @Override
        public void receivedMessage(String message) {
            System.out.println(message);
        }
    }
}


