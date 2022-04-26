package com.vintud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao {
    // Display all announcements
    @Override
    public List<AnnouncementImpl> displayAnnouncements() {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
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
            return announcements;
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

    // Create announcement
    @Override
    public void createAnnouncement(AnnouncementImpl announcement) {
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
    @Override
    public void updateAnnouncement(AnnouncementImpl announcement) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "SELECT id FROM announcement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcement.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "UPDATE announcement SET title = ?, description = ?, category_id = ?, price = ?, publication_date = ?, is_available = ?, view_number = ?, localisation = ?, user_id = ? WHERE id = ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setString(1, announcement.getTitle());
                    preparedStatement1.setString(2, announcement.getDescription());
                    preparedStatement1.setInt(3, announcement.getCategoryId());
                    preparedStatement1.setDouble(4, announcement.getPrice());
                    preparedStatement1.setDate(5, announcement.getPublication_date());
                    preparedStatement1.setBoolean(6, announcement.isAvailable());
                    preparedStatement1.setInt(7, announcement.getView_number());
                    preparedStatement1.setString(8, announcement.getLocalisation());
                    preparedStatement1.setInt(9, announcement.getUserId());
                    preparedStatement1.setInt(10, resultSet.getInt("id"));
                    preparedStatement1.executeUpdate();
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
        }
    }

    // Delete announcement
    @Override
    public void deleteAnnouncement(int id) {
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

    @Override
    public AnnouncementImpl search(String name, String category, double price) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
        }
        String query;
        if (name != null && category != null && price != 0) {
            query = "SELECT * FROM announcement WHERE name = ? AND category = ? AND price <= ? AND price >= ?";
        } else if (name != null && category != null && price == 0) {
            query = "SELECT * FROM announcement WHERE name = ? OR category = ? ";
        } else if (name == null && category == null && price != 0) {
            query = "SELECT * FROM announcement WHERE price = ?";
        }

        return null;
    }


}
