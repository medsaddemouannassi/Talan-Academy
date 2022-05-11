package com.thp.project.vintud.dao;

import com.thp.project.vintud.entity.Announcement;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;

public interface UserDao {
    // User signup
    void signup(UserImpl user);

    // User login
    void login(String email, String password);

    // User logout
    void logout(int id);

    // Update profile User
    void updateUserProfile(UserImpl user);

    // Display seller info by announcement ID
    UserImpl displayInfoSeller(AnnouncementImpl announcement);
}
