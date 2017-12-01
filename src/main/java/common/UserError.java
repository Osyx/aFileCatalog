package common;

public class UserError extends Exception {
    private String errorMsg;

    public UserError(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}