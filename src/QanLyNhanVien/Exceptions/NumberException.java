package QanLyNhanVien.Exceptions;

public class NumberException extends Exception {
    private String invalidId;

    public NumberException() {
    }

    public NumberException(String invalidId) {
        this.invalidId = invalidId;
    }

    public NumberException(String message, String invalidId) {
        super(message);
        this.invalidId = invalidId;
    }

    public String getInvalidId() {
        return invalidId;
    }

    public void setInvalidId(String invalidId) {
        this.invalidId = invalidId;
    }
}
