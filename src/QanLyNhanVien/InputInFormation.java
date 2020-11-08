package QanLyNhanVien;

import QanLyNhanVien.Exceptions.EmailException;
import QanLyNhanVien.Exceptions.NumberException;
import QanLyNhanVien.Exceptions.PhoneNumberException;

import java.util.Scanner;

import static java.lang.System.*;

public class InputInFormation {
    public Employee inputList() {
        var input = new Scanner(in);
        Employee employee = new Employee();
        out.println("ID card: ");
        var pId = input.nextLine();
        out.println("Enter Your Name: ");
        var name = input.nextLine();
        out.println("Address: ");
        var address = input.nextLine();
        out.println("Phone Number: ");
        var phoneNumber = input.nextLine();
        out.println("Email: ");
        var email = input.nextLine();
        out.println("Date of birth: dd/MM/yyyy, Example 12/10/2020: ");
        var dateOfBirth = input.nextLine();
        out.println("Duty: ");
        var duty = input.nextLine();
        out.println("Level Salary: ");
        var salary = Float.parseFloat(input.nextLine());
        out.println("Years of experience: ");
        var exp = Float.parseFloat(input.nextLine());
        out.println("Number of working days per month: ");
        var workingDay = Float.parseFloat(input.nextLine());
        employee.setEmpId(null);
        try {
            employee.setId(pId);
        } catch (NumberException e) {
            e.printStackTrace();
        }
        employee.setFullName(name);
        employee.setAddress(address);
        try {
            employee.setPhoneNumber(phoneNumber);
        } catch (PhoneNumberException e) {
            e.printStackTrace();
        }
        try {
            employee.setPhoneNumber(phoneNumber);
        } catch (PhoneNumberException e) {
            e.printStackTrace();
        }
        employee.setDateOfBirth(dateOfBirth);
        employee.setSalary(salary);
        employee.setDuty(duty);
        employee.setExperience(exp);
        employee.setWorkingDay(workingDay);
        try {
            employee.setEmail(email);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
