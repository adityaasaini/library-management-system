package com.library.service;

import java.util.List;

import com.library.dao.UserDao;
import com.library.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    // Add User with validation
    public boolean addUser(User user) {

        if (user.getName() == null || user.getName().isEmpty()) {
            System.out.println("❌ Name cannot be empty");
            return false;
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            System.out.println("❌ Email cannot be empty");
            return false;
        }

        if (user.getPhone() == null || user.getPhone().length() < 10) {
            System.out.println("❌ Invalid phone number");
            return false;
        }

        return userDao.addUser(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    // Delete user
    public boolean deleteUser(int userId) {
        return userDao.deleteUser(userId);
    }
}
