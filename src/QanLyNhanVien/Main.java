package QanLyNhanVien;



import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        InputInFormation inputInFormation = new InputInFormation();
        manager.updateEmployeeId(manager.empList);
        int choice;
        var inputs = new Scanner(in);
        do {
            out.println("=/=/=/=/=/=/=Menus List=/=/=/=/=/=");
            out.println("1: Add Employee");
            out.println("2: Display Employee");
            out.println("3: Find Employee");
            out.println("4: Edit Employee");
            out.println("5: Delete Employee");
            out.println("6: Calculate Salary Employee");
            out.println("7: Display Salary Employee");
            out.println("8: Edit Name Employee");
            out.println("9: Sever File");
            out.println("0: Exit");
            choice = Integer.parseInt(inputs.nextLine());
            switch (choice) {
                case 1:
                    Employee employee = inputInFormation.inputList();
                    manager.empList.add(employee);
                    break;
                case 2:
                    Manager.displayEmployees(manager.empList);
                    break;
                case 3:
                    if (manager.empList.size() > 0) {
                        var id = "";
                        out.println("Enter employee code: ");
                        id = inputs.nextLine().trim();
                        var result = Manager.SearchID(manager.empList, id);
                        if (result.size() > 0) {
                            out.println("Find " + result.size() + " Result");
                            Manager.displayEmployees(result);
                        } else {
                            out.println("==> No employee found code \"" + id + "\"");
                        }
                    } else {
                        out.println("The list of employees is empty");
                    }
                    break;
                case 4:
                    if (manager.empList.size() > 0) {
                        out.println("Enter employee code: ");
                        var id = inputs.nextLine().trim();
                        Employee searchEmp = Manager.searchAnEmpById(manager.empList, id);
                        if (searchEmp == null) {
                            out.println("==> No employee found code \"" + id + "\"");
                        } else {
                            out.println("Enter a new salary: ");
                            var newSalary = Float.parseFloat(inputs.nextLine().trim());
                            searchEmp.setSalary(newSalary);
                        }
                    } else {
                        out.println("The list of employees is empty");
                    }
                    break;
                case 5:
                    if (manager.empList.size() > 0) {
                        out.println("Enter the employee code to delete: ");
                        var id = inputs.nextLine();
                        var isDeleted = Manager.removeEmp(manager.empList, id);
                        if (isDeleted) {
                            out.println("Deleted successfully");
                        } else {
                            out.println("Employee code incorrect");
                        }
                    } else {
                        out.println("The list of employees is empty");
                    }
                    break;
                case 6:
                    if (manager.empList.size() > 0) {
                        Manager.calculSalary(manager.empList);
                    } else {
                        out.println("The list of employees is empty");
                    }
                    break;
                case 7:
                    if (manager.empList.size() > 0) {
                        Manager.showPayroll(manager.empList);
                    } else {
                        out.println("The list of employees is empty");
                    }
                    break;
                case 8:
                    if (manager.empList.size() > 0) {
                        out.println("Enter employee code");
                        var id = inputs.nextLine().trim();
                        Employee checks = Manager.searchAnEmpById(manager.empList, id);
                        if (checks == null) {
                            out.println("Khong Ton Tai Nhan Vien Ma: \"" + id + "\"");
                        }else {
                            out.println("Nhap Ten Moi Moi");
                            var newId = inputs.nextLine();
                                checks.setFullName(newId);
                        }
                    }
                    break;
                case 9:
                    if (manager.empList.size() > 0) {
                        var isSuccess = Manager.writeEmpToFile(manager.empList, manager.empFileName);
                        if (isSuccess) {
                            out.println("File recording is successful !");
                        } else {
                            out.println("File write failed!");
                        }
                    } else {
                        out.println("The list of employees is empty. File write failed");
                    }

            }
        } while (choice != 0);
    }
}
