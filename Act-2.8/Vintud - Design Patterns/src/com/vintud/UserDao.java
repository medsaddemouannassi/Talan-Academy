package com.vintud;

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
    UserImpl displayInfoSeller(int id);
}
