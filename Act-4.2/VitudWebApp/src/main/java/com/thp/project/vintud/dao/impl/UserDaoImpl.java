package com.thp.project.vintud.dao.impl;

import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    VintudFactory vintudFactory = new VintudFactoryImpl();

    // User signup
    @Override
    public String signup(UserImpl user) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String message = "";
        if (findUserByEmail(user.getEmail()) || findUserByPhone(user.getPhoneNumber())) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            message = "This user already exist";
        } else {
            String query = "INSERT INTO users (first_name, last_name, pseudo, email, password, phone, address, role_id) VALUES (?,?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                preparedStatement1.setString(1, user.getFirstName().toLowerCase());
                preparedStatement1.setString(2, user.getLastName().toLowerCase());
                preparedStatement1.setString(3, user.getPseudo().toLowerCase());
                preparedStatement1.setString(4, user.getEmail().toLowerCase());
                preparedStatement1.setString(5, user.getPassword().toLowerCase());
                preparedStatement1.setString(6, user.getPhoneNumber());
                preparedStatement1.setString(7, user.getAddress());
                preparedStatement1.setInt(8, user.getRoleId());
                preparedStatement1.executeUpdate();
                message = "Welcome";
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return message;
    }

    // User login
    @Override
    public UserImpl login(String email, String password) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM users WHERE LOWER(email) = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email.toLowerCase());
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "UPDATE users SET is_connected = true WHERE LOWER(email) = ? AND password = ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setString(1, email.toLowerCase());
                    preparedStatement1.setString(2, password.toLowerCase());
                    preparedStatement1.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                UserImpl user = new UserImpl();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // User logout
    @Override
    public void logout(int id) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "UPDATE users SET is_connected = false WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Update profile User
    @Override
    public void updateUserProfile(UserImpl user) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "SELECT id FROM users WHERE id = ? AND is_connected = true";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "UPDATE users SET first_name = ?, last_name = ?, pseudo = ?, email = ?, password = ?, phone = ?, address = ?, role_id = ? WHERE id = ? AND is_connected = true";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setString(1, user.getFirstName());
                    preparedStatement1.setString(2, user.getLastName());
                    preparedStatement1.setString(3, user.getPseudo());
                    preparedStatement1.setString(4, user.getEmail());
                    preparedStatement1.setString(5, user.getPassword());
                    preparedStatement1.setString(6, user.getPhoneNumber());
                    preparedStatement1.setString(7, user.getAddress());
                    preparedStatement1.setInt(8, user.getRoleId());
                    preparedStatement1.setInt(9, resultSet.getInt("id"));
                    preparedStatement1.executeUpdate();
                    System.out.println("Changes saved");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Display seller info by announcement ID
    @Override
    public UserImpl displayInfoSeller(AnnouncementImpl announcement) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT user_id FROM announcement where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcement.getUserId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "SELECT * FROM users WHERE id = ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setInt(1, resultSet.getInt("user_id"));
                    resultSet = preparedStatement1.executeQuery();
                    if (resultSet.next()) {
                        UserImpl user = new UserImpl();
                        user.setId(resultSet.getInt("id"));
                        user.setFirstName(resultSet.getString("first_name").replaceAll("  ", ""));
                        user.setLastName(resultSet.getString("last_name").replaceAll("  ", ""));
                        user.setPseudo(resultSet.getString("pseudo").replaceAll("  ", ""));
                        user.setEmail(resultSet.getString("email").replaceAll("  ", ""));
                        user.setPassword("************");
                        user.setPhoneNumber(resultSet.getString("phone").replaceAll("  ", ""));
                        user.setAddress(resultSet.getString("address").replaceAll("  ", ""));
                        user.setRoleId(resultSet.getInt("role_id"));
                        System.out.println(user);
                        return user;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // Verify if user already exist by email
    @Override
    public Boolean findUserByEmail(String email) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT email FROM users WHERE LOWER(email) = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Verify if user already exist by phone
    @Override
    public Boolean findUserByPhone(String phone) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT phone FROM users WHERE phone = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
