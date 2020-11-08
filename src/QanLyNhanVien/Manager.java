package QanLyNhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Manager {
    String empFileName = "EmployeeFile.DAT";
    List<Employee> empList = new ArrayList<>(readEmpFromFile(empFileName));
    public static void displayEmployees(List<Employee> employees) {
        out.printf("%-15s%-20s%-15s%-20s%-20s%-15s%-15s%-15s%-15s%-15s\n",
                "Số CMT", "Name Employee", "Address", "Date Of birth", "Email",
                "Phone Number", "Employee Code", "Duty", "Salary", "Experience");
        for (var emp : employees) {
            show(emp);
        }
    }

    public static void show(Employee emp) {
        out.printf("%-15s%-20s%-15s%-15s%-20s" +
                        "%-15s%-15s%-15s%-15.2f%-15.2f\n",
                emp.getId(), emp.getFullName(), emp.getAddress(),
                emp.getDateOfBirth(), emp.getEmail(), emp.getPhoneNumber(),
                emp.getEmpId(), emp.getDuty(), emp.getSalary(), emp.getExperience());
    }

    public static List<Employee> SearchID(List<Employee> employees, String id) {
        List<Employee> result = new ArrayList<>();
        for (var emp : employees) {
            if (emp.getEmpId().toLowerCase().matches(".*" + id.toLowerCase() + ".*")) {
                result.add(emp);
            }
        }
        return result;
    }
    public static Employee searchAnEmpById(List<Employee> employees, String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpId().compareToIgnoreCase(id) == 0) {
                return employees.get(i);
            }
        }
        return null;
    }
    public static boolean removeEmp(List<Employee> employees, String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpId().compareTo(id) == 0) {
                employees.remove(i);
                return true;
            }
        }
        return false;
    }
    private static List<Employee> readEmpFromFile(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            var mObj = ois.readObject();
            if (mObj != null) {
                employees = (ArrayList<Employee>) mObj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public void updateEmployeeId(List<Employee> employees) {
        int maxId = 1000;
        for (var emp : employees) {
            var curId = Integer.parseInt(emp.getEmpId().substring(3));
            if (curId > maxId) {
                maxId = curId;
            }
        }
        Employee.setNextId(maxId + 1);
    }
    public static boolean writeEmpToFile(List<Employee> employees, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employees);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void calculSalary(List<Employee>employees){
        for (int i = 0; i < employees.size(); i++) {
            var emp = employees.get(i);
            emp.calculateTotalSalary();
        }
    }
    public static void showPayroll(List<Employee> employees){
        out.printf("%-15s%-25s%-15s%-15s%-15s%-20s\n", "Employee Code", "Name Employee",
                "Salary", "Working days", "Bonus", "Total Salary");
        for (var emp:employees) {
            out.printf("%-15s%-25s%-15.2f%-15.2f%-15.2f%-20.2f\n",
                    emp.getEmpId(),emp.getFullName(),emp.getSalary(),
                    emp.getWorkingDay(), emp.getBonus(),emp.getTotalSalary());
        }
    }
}
