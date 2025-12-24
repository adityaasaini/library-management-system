package com.library.controller;

import java.util.List;
import java.util.Scanner;

import com.library.model.User;
import com.library.service.UserService;

public class UserController {

    private UserService userService = new UserService();
    private Scanner sc = new Scanner(System.in);

    public void userMenu() {

        while (true) {
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Delete User");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewUsers();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }

    private void addUser() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);

        boolean result = userService.addUser(user);

        if (result) {
            System.out.println("✅ User added successfully");
        } else {
            System.out.println("❌ Failed to add user");
        }
    }

    private void viewUsers() {
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("⚠ No users found");
            return;
        }

        for (User u : users) {
            System.out.println(u);
        }
    }

    private void deleteUser() {
        System.out.print("Enter User ID to delete: ");
        int id = sc.nextInt();

        boolean result = userService.deleteUser(id);

        if (result) {
            System.out.println("✅ User deleted successfully");
        } else {
            System.out.println("❌ User not found");
        }
    }
}
