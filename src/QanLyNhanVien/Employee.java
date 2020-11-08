package QanLyNhanVien;

import QanLyNhanVien.Exceptions.EmailException;

import QanLyNhanVien.Exceptions.NumberException;
import QanLyNhanVien.Exceptions.PhoneNumberException;

import java.util.Date;


public class Employee extends Person {
    private static int nextId = 1001;
    private String empId;
    private String Duty;
    private float salary;
    private float experience;
    private float workingDay;
    private float totalSalary;
    private float bonus;

    public Employee() {
    }

    public Employee(String empId, String duty, float salary, float experience, float workingDay, float totalSalary, float bonus) {
        setEmpId(empId);
        this.Duty = duty;
        this.salary = salary;
        this.experience = experience;
        this.setWorkingDay(workingDay);
        this.totalSalary = totalSalary;
        this.bonus = bonus;
    }

    public Employee(String id, String fullName, String address,
                    String dateOfBirth, String email, String phoneNumber, String empId,
                    String duty, float salary, float experience, float workingDay,
                    float totalSalary, float bonus) throws
            PhoneNumberException, EmailException, NumberException {
        super(id, fullName, address, dateOfBirth, email, phoneNumber);
        setEmpId(empId);
        Duty = duty;
        this.setSalary(salary);
        this.experience = experience;
        this.setWorkingDay(workingDay);
        this.totalSalary = totalSalary;
        this.bonus = bonus;
    }

    public void calculateTotalSalary() {
        totalSalary = workingDay * salary / 22 + bonus;
    }

    public void calculateBonus() {
        if (workingDay >= 20) {
            var bonusesDay = workingDay - 20;
            bonus = bonusesDay * 0.5f * salary / 22;
        } else {
            bonus = 0;
        }
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public final String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        if (empId == null) {
            this.empId = "EMP" + nextId;
            nextId++;
        } else {
            this.empId = empId;
        }
    }

    public String getDuty() {
        return Duty;
    }

    public void setDuty(String duty) {
        Duty = duty;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public float getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(float workingDay) {
        this.workingDay = workingDay;
    }

    public float getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

}
