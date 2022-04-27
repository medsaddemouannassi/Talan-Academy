package com.vintud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao, VintudFactory {
    // Display all announcements
    @Override
    public List<AnnouncementImpl> displayAnnouncements() {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connectionManager.getConnection() == null) {
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
                Status status = resultSet.getString("status") == null ? null : Status.valueOf(resultSet.getString("status"));
                announcement.setStatus(status);
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
        String query = "INSERT INTO announcement(id, title, description, category_id, price, publication_date, status, is_available, view_number, localisation, user_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcement.getId());
            preparedStatement.setString(2, announcement.getTitle().toLowerCase());
            preparedStatement.setString(3, announcement.getDescription().toLowerCase());
            preparedStatement.setInt(4, announcement.getCategoryId());
            preparedStatement.setDouble(5, announcement.getPrice());
            preparedStatement.setDate(6, announcement.getPublication_date());
            preparedStatement.setString(7, String.valueOf(announcement.getStatus()));
            preparedStatement.setBoolean(8, announcement.isAvailable());
            preparedStatement.setInt(9, announcement.getView_number());
            preparedStatement.setString(10, announcement.getLocalisation().toLowerCase());
            preparedStatement.setInt(11, announcement.getUserId());
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
                query = "UPDATE announcement SET title = ?, description = ?, category_id = ?, price = ?, publication_date = ?, is_available = ?, status = ?, view_number = ?, localisation = ?, user_id = ? WHERE id = ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setString(1, announcement.getTitle().toLowerCase());
                    preparedStatement1.setString(2, announcement.getDescription().toLowerCase());
                    preparedStatement1.setInt(3, announcement.getCategoryId());
                    preparedStatement1.setDouble(4, announcement.getPrice());
                    preparedStatement1.setDate(5, announcement.getPublication_date());
                    preparedStatement1.setBoolean(6, announcement.isAvailable());
                    preparedStatement1.setString(7, String.valueOf(announcement.getStatus()));
                    preparedStatement1.setInt(8, announcement.getView_number());
                    preparedStatement1.setString(9, announcement.getLocalisation().toLowerCase());
                    preparedStatement1.setInt(10, announcement.getUserId());
                    preparedStatement1.setInt(11, resultSet.getInt("id"));
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

    // Search announcement by name, category and/or price
    @Override
    public AnnouncementImpl searchAnnouncement(String title, Integer category, Double price) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM announcement WHERE (title LIKE ? AND category_id = ? AND price = ?) OR (title LIKE ? AND category_id = ?) OR price = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,"%" + title.toLowerCase() + "%");
            preparedStatement.setInt(2, category);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, "%" + title.toLowerCase() + "%");
            preparedStatement.setInt(5, category);
            preparedStatement.setDouble(6, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                AnnouncementImpl announcement = new AnnouncementImpl();
                announcement.setTitle(resultSet.getString("title").replaceAll("  ", ""));
                announcement.setDescription(resultSet.getString("description").replaceAll("  ", ""));
                announcement.setCategoryId(resultSet.getInt("category_id"));
                announcement.setPrice(resultSet.getInt("price"));
                announcement.setPhoto(resultSet.getBlob("picture"));
                announcement.setPublication_date(resultSet.getDate("publication_date"));
                Status status = resultSet.getString("status") == null ? null : Status.valueOf(resultSet.getString("status"));
                announcement.setStatus(status);
                announcement.setAvailable(resultSet.getBoolean("is_available"));
                announcement.setView_number(resultSet.getInt("view_number"));
                announcement.setLocalisation(resultSet.getString("localisation").replaceAll("  ", ""));
                announcement.setUserId(resultSet.getInt("user_id"));
                System.out.println(announcement);
                return announcement;
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

    // Filter announcements by price
    @Override
    public List<AnnouncementImpl> filterAnnouncementByPrice(Double minPrice, Double maxPrice) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM announcement WHERE price >= ? AND price <= ? ORDER BY price";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AnnouncementImpl> announcements = new ArrayList<>();
            while (resultSet.next()) {
                AnnouncementImpl announcement = new AnnouncementImpl();
                announcement.setTitle(resultSet.getString("title").replaceAll("  ", ""));
                announcement.setDescription(resultSet.getString("description").replaceAll("  ", ""));
                announcement.setCategoryId(resultSet.getInt("category_id"));
                announcement.setPrice(resultSet.getInt("price"));
                announcement.setPhoto(resultSet.getBlob("picture"));
                announcement.setPublication_date(resultSet.getDate("publication_date"));
                Status status = resultSet.getString("status") == null ? null : Status.valueOf(resultSet.getString("status"));
                announcement.setStatus(status);
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

    // Filter announcements by localisation
    @Override
    public List<AnnouncementImpl> filterAnnouncementByLocalisation(String localisation) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM announcement WHERE localisation LIKE ? ORDER BY price";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%"+localisation.toLowerCase()+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AnnouncementImpl> announcements = new ArrayList<>();
            while (resultSet.next()) {
                AnnouncementImpl announcement = new AnnouncementImpl();
                announcement.setTitle(resultSet.getString("title").replaceAll("  ", ""));
                announcement.setDescription(resultSet.getString("description").replaceAll("  ", ""));
                announcement.setCategoryId(resultSet.getInt("category_id"));
                announcement.setPrice(resultSet.getInt("price"));
                announcement.setPhoto(resultSet.getBlob("picture"));
                announcement.setPublication_date(resultSet.getDate("publication_date"));
                Status status = resultSet.getString("status") == null ? null : Status.valueOf(resultSet.getString("status"));
                announcement.setStatus(status);
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

    // Send request to reserve article
    @Override
    public void SendReqReserveArticle(int id) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "UPDATE announcement SET status = \"ARTICLE_REQUESTED\" WHERE id = ?";
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

    // Display view number
    @Override
    public int displayViewNumber(int id) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return 0;
        }
        String query = "SELECT view_number FROM announcement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int view_number = resultSet.getInt("view number");
                System.out.println(view_number);
                return view_number;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
