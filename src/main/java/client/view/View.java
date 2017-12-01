package client.view;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import common.ClientReacher;

public class View implements Runnable{
    private boolean receiving = false;
    private final ClientReacher remoteObject;
    public boolean stillReceiving = false;
    private String userName = "";

    private final String HELP_MESSAGE = "help";
    private final String EXIT_MESSAGE = "exit";
    private final String LOGIN_MESSAGE = "login";
    private final String LOGOUT_MESSAGE = "logout";
    private final String REGISTER_MESSAGE = "register";
    private final String UNREGISTER_MESSAGE = "unregister";
    private final String UPLOAD_MESSAGE = "upload";
    private final String DOWNLOAD_MESSAGE = "download";
    private final String LIST_MESSAGE = "list";
    private final String DELETE_MESSAGE = "delete";
    private final String UPDATE_MESSAGE = "update";
    private final String NOTIFY_MESSAGE = "notify";

    public View() throws RemoteException {
        remoteObject = new Output();
    }

    public void start() {
        if (receiving) {
            return;
        }
        receiving = true;
        new Thread(this).start();
    }

    @Override
    public void run(){
        System.out.println("receiving commands...");
        Scanner sc = new Scanner(System.in);
        while(receiving){
            try{
                String input = sc.nextLine().toLowerCase();
                switch (input) {
                    case HELP_MESSAGE:
                        System.out.println("Possible commands: " + HELP_MESSAGE + ", " + EXIT_MESSAGE + ", " + LOGIN_MESSAGE + ", " + LOGOUT_MESSAGE + ", " + REGISTER_MESSAGE + ", " + UNREGISTER_MESSAGE + ", " + UPLOAD_MESSAGE + ", " + DOWNLOAD_MESSAGE + ", " + LIST_MESSAGE + ", " + DELETE_MESSAGE + ", " + UPDATE_MESSAGE + ", " + NOTIFY_MESSAGE + " ");
                        break;
                    case EXIT_MESSAGE:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    case LOGIN_MESSAGE:
                        System.out.println("Insert username and password.");
                        // LogInDetails lid = new LogInDetails(sc.next(), sc.next);
                        // userName = logIn(remoteObj, lid);
                        break;
                    case LOGOUT_MESSAGE:
                        if(userName == ""){
                            System.out.println("Unable to log out.");
                        }else{
                            System.out.print("Logging out...");
                            //logOut(userName);
                            System.out.println("done");
                        }
                        break;
                    case REGISTER_MESSAGE:
                        System.out.println("Insert wanted username and password.");

                        break;
                    case UNREGISTER_MESSAGE:
                        System.out.println("UNREGISTER MESSAGE...");
                        break;
                    case UPLOAD_MESSAGE:
                        System.out.println("UPLOAD MESSAGE...");
                        break;
                    case DOWNLOAD_MESSAGE:
                        System.out.println("DOWNLOAD MESSAGE...");
                        break;
                    case LIST_MESSAGE:
                        System.out.println("LIST MESSAGE...");
                        break;
                    case DELETE_MESSAGE:
                        System.out.println("DELETE MESSAGE...");
                        break;
                    case UPDATE_MESSAGE:
                        System.out.println("UPDATE MESSAGE...");
                        break;
                    case NOTIFY_MESSAGE:
                        System.out.println("NOTIFY MESSAGE...");
                        break;
                    default:
                        //System.out.println("Wrong message syntax: " + input + ". Type help for help.");
                }

            }catch (Exception e){
                System.out.println("Receiving failed.");
            }
        }
    }



    private class Output extends UnicastRemoteObject implements ClientReacher{
        public Output() throws RemoteException{

        }
        @Override
        public void recvMsg(String message) {

        }
    }
}


