package com.vintud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementManager {
    // User signup
    public static void signup(UserImpl user) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "SELECT * FROM users WHERE LOWER(email) = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getEmail().toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("This user already exist");
            } else {
                query = "INSERT INTO users (first_name, last_name, pseudo, email, password, phone, address, role_id) VALUES (?,?,?,?,?,?,?,?)";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setString(1, user.getFirstName());
                    preparedStatement1.setString(2, user.getLastName());
                    preparedStatement1.setString(3, user.getPseudo());
                    preparedStatement1.setString(4, user.getEmail());
                    preparedStatement1.setString(5, user.getPassword());
                    preparedStatement1.setString(6, user.getPhoneNumber());
                    preparedStatement1.setString(7, user.getAddress());
                    preparedStatement1.setInt(8, user.getRoleId());
                    preparedStatement1.executeUpdate();
                    System.out.println("Welcome");
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

    // User login
    public static void login(String email, String password) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
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
                    preparedStatement1.setString(2, password);
                    preparedStatement1.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Welcome " + resultSet.getString("first_name").replaceAll(" ", "") + " " + resultSet.getString("last_name").replaceAll(" ", ""));
            } else {
                System.out.println("Please verify your email/password");
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

    // User logout
    public static void logout(int id) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
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
    public static void updateUserProfile(String email, UserImpl user) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "SELECT * FROM users WHERE LOWER(email) = ? AND is_connected = true";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "UPDATE users SET first_name = ?, last_name = ?, pseudo = ?, email = ?, password = ?, phone = ?, address = ?, role_id = ? WHERE LOWER(email) = ? AND is_connected = true";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setString(1, user.getFirstName());
                    preparedStatement1.setString(2, user.getLastName());
                    preparedStatement1.setString(3, user.getPseudo());
                    preparedStatement1.setString(4, user.getEmail());
                    preparedStatement1.setString(5, user.getPassword());
                    preparedStatement1.setString(6, user.getPhoneNumber());
                    preparedStatement1.setString(7, user.getAddress());
                    preparedStatement1.setInt(8, user.getRoleId());
                    preparedStatement1.setString(9, email.toLowerCase());
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

    // Display all announcements
    public static void displayAnnouncements() {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "SELECT * FROM announcement";
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = prepareStatement.executeQuery();
            List<AnnouncementImpl> announcements = new ArrayList<>();
            while (resultSet.next()) {
                AnnouncementImpl announcement = new AnnouncementImpl();
                announcement.setTitle(resultSet.getString("title").replaceAll("  ", ""));
                announcement.setDescription(resultSet.getString("description").replaceAll("  ", ""));
                announcement.setCategoryId(resultSet.getInt("category_id"));
                announcement.setPrice(resultSet.getInt("price"));
                announcement.setPhoto(resultSet.getBlob("picture"));
                announcement.setPublication_date(resultSet.getDate("publication_date"));
                announcement.setStatus(resultSet.getString("status"));
                announcement.setAvailable(resultSet.getBoolean("is_available"));
                announcement.setView_number(resultSet.getInt("view_number"));
                announcement.setLocalisation(resultSet.getString("localisation").replaceAll("  ", ""));
                announcement.setUserId(resultSet.getInt("user_id"));
                announcements.add(announcement);
            }
            announcements.forEach(System.out::println);
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
    public static void displayInfoSeller(int id) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "SELECT user_id FROM announcement where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
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
    }

    // Create announcement
    public static void createAnnouncement(AnnouncementImpl announcement) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "INSERT INTO announcement(id, title, description, category_id, price, publication_date, is_available, view_number, localisation, user_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcement.getId());
            preparedStatement.setString(2, announcement.getTitle());
            preparedStatement.setString(3, announcement.getDescription());
            preparedStatement.setInt(4, announcement.getCategoryId());
            preparedStatement.setDouble(5, announcement.getPrice());
            preparedStatement.setDate(6, announcement.getPublication_date());
            preparedStatement.setBoolean(7, announcement.isAvailable());
            preparedStatement.setInt(8, announcement.getView_number());
            preparedStatement.setString(9, announcement.getLocalisation());
            preparedStatement.setInt(10, announcement.getUserId());
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

    // Update announcement
    public static void updateAnnouncement(int id, AnnouncementImpl announcement) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "UPDATE announcement SET title = ?, description = ?, category_id = ?, price = ?, publication_date = ?, is_available = ?, view_number = ?, localisation = ?, user_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, announcement.getTitle());
            preparedStatement.setString(2, announcement.getDescription());
            preparedStatement.setInt(3, announcement.getCategoryId());
            preparedStatement.setDouble(4, announcement.getPrice());
            preparedStatement.setDate(5, announcement.getPublication_date());
            preparedStatement.setBoolean(6, announcement.isAvailable());
            preparedStatement.setInt(7, announcement.getView_number());
            preparedStatement.setString(8, announcement.getLocalisation());
            preparedStatement.setInt(9, announcement.getUserId());
            preparedStatement.setInt(10, id);
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

    // Delete announcement
    public static void deleteAnnouncement(int id) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "DELETE FROM announcement WHERE id = ?";
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

}
