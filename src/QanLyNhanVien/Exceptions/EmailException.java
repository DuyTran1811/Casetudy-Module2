package QanLyNhanVien.Exceptions;

public class EmailException extends Exception {
    private String invalidEmail;

    public EmailException() {
    }

    public EmailException(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

    public EmailException(String message, String invalidEmail) {
        super(message);
        this.invalidEmail = invalidEmail;
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }

    public void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }
}
