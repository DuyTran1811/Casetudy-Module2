package QanLyNhanVien;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        int choice;
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        System.out.println(" Welcome to the employee management app");
        System.out.println("    Press the 1 to enter the program");
        System.out.println("        2: Product information");
        do {
            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Please Enter ID");
                        String id = scan.nextLine();
                        System.out.println("Please Enter Password");
                        String password = scan.nextLine();
                        if (id.equals("admin") && (password.equals("admin"))) {
                            main.mains();
                        } else {
                            System.out.println("Wrong password, please re-enter");
                        }
                    } while (true);
                case 2:
                    System.out.println("This software is written by Duy Tran class C082001\n" + "Casetudy Module 2");
                    break;
            }
        }
        while (choice != 0);
    }
}
