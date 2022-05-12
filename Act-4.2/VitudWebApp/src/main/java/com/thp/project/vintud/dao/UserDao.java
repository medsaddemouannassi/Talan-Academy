package com.thp.project.vintud.dao;

import com.thp.project.vintud.entity.User;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;

public interface UserDao {
    // User signup
    String signup(UserImpl user);

    // User login
    UserImpl login(String email, String password);

    // User logout
    void logout(int id);

    // Update profile User
    void updateUserProfile(UserImpl user);

    // Display seller info by announcement ID
    UserImpl displayInfoSeller(AnnouncementImpl announcement);

    // Verify if user already exist by email
    Boolean findUserByEmail(String email);

    // Verify if user already exist by phone
    Boolean findUserByPhone(String phone);
}
