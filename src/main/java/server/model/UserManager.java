package server.model;


import common.LogInDetails;
import common.UserError;

public class UserManager {
    private final String USERNAME_NOT_AVAILABLE_MESSAGE

    public String createUser(LogInDetails lgn) throws UserError {
        checkIfUsernameAvailable(lgn.getUsername());
        User user = new User(lgn.getUsername(), lgn.getPassword());


    }


    public void logOut(String username) {

    }

    private boolean checkIfUsernameAvailable(String username)throws UserError{
        if(!USERNAMEAVAILABLE){
            throw new UserError(USERNAME_NOT_AVAILABLE_MESSAGE);
        }
    return true;
    }


}
