package QanLyNhanVien.Exceptions;

public class PhoneNumberException extends Exception {
    private String PhoneNumber;

    public PhoneNumberException() {
    }

    public PhoneNumberException(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public PhoneNumberException(String message, String phoneNumber) {
        super(message);
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
