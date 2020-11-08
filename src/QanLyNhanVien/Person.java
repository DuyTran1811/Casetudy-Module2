package QanLyNhanVien;

import QanLyNhanVien.Exceptions.EmailException;
import QanLyNhanVien.Exceptions.NumberException;
import QanLyNhanVien.Exceptions.PhoneNumberException;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements Serializable, Comparable<Person> {
    private String id;
    private String fullName;
    private String address;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;

    public Person() {
    }

    public Person(String id, String fullName, String address, String dateOfBirth, String email, String phoneNumber)
            throws PhoneNumberException, EmailException, NumberException {
        this.setId(id);
        this.fullName = fullName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
    }

    public final void setId(String id) throws NumberException {
        var regex = "^([A-Z0-9]){9,13}$";
        if (id.matches(regex)) {
            this.id = id;
        } else {
            var smg = "Invalid ID Card" + id;
            throw new NumberException(smg, id);
        }
    }

    public final void setPhoneNumber(String phoneNumber) throws PhoneNumberException {
        var regex = "^((08|09)\\d{7})|((03|04|07)\\d{8})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) {
            this.phoneNumber = phoneNumber;
        } else {
            var smg = "Invalid PhoneNumber: " + phoneNumber;
            throw new PhoneNumberException(smg, phoneNumber);
        }
    }

    public final void setEmail(String email) throws EmailException {
        var regex = "^[a-z]+[a-z0-9._]*@gmail.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        } else {
            var msg = "Invalid email:" + email;
            throw new EmailException(msg, email);
        }
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(Person o) {
        return id.compareTo(o.id);
    }
}
