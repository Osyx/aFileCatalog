package common;

public class FileError extends Exception{
    private String errorMsg;

    public FileError(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
