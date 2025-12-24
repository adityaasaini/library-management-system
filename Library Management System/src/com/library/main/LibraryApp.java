package com.library.main;

import java.util.Scanner;

import com.library.controller.UserController;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserController userController = new UserController();

        while (true) {
            System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. User Management");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    userController.userMenu();
                    break;

                case 0:
                    System.out.println("Thank you! Exiting application.");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }
}
