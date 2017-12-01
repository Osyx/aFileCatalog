package server.model;


import common.ClientReacher;
import common.LogInDetails;
import common.UserError;

public class UserManager {
    private final String USERNAME_NOT_AVAILABLE_MESSAGE = "This username is already taken";

    public String createUser(ClientReacher cr, LogInDetails lgn) throws UserError {
        checkIfUsernameAvailable(lgn.getUsername());
        // User user = new User(lgn.getUsername(), lgn.getPassword());
        return "";

    }


    public void logOut(String username) {

    }

    private boolean checkIfUsernameAvailable(String username)throws UserError{
     /*   if(!USERNAMEAVAILABLE){
            throw new UserError(USERNAME_NOT_AVAILABLE_MESSAGE);
        }*/
    return true;

    }


}
