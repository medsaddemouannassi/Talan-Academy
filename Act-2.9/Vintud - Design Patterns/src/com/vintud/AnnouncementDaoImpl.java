package com.vintud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao {
    VintudFactory vintudFactory = new VintudFactoryImpl();

    // Display all announcements
    @Override
    public ResultSet displayAnnouncements() {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM announcement";
        try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = prepareStatement.executeQuery();
            List<AnnouncementImpl> announcements = new ArrayList<>();
            if (!resultSet.next()){
                System.out.println("fffff");
                resultSet.next();
            } else {
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
            }
            announcements.forEach(System.out::println);
            return resultSet;
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
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "INSERT INTO announcement(title, description, category_id, price, publication_date, status, is_available, view_number, localisation, user_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Date date = new Date(System.currentTimeMillis());
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, announcement.getTitle().toLowerCase());
            preparedStatement.setString(2, announcement.getDescription().toLowerCase());
            preparedStatement.setInt(3, announcement.getCategoryId());
            preparedStatement.setDouble(4, announcement.getPrice());
            preparedStatement.setDate(5, date);
            preparedStatement.setObject(6, announcement.getStatus(), java.sql.Types.OTHER);
            preparedStatement.setBoolean(7, announcement.isAvailable());
            preparedStatement.setInt(8, announcement.getView_number());
            preparedStatement.setString(9, announcement.getLocalisation().toLowerCase());
            preparedStatement.setInt(10, announcement.getUserId());
            preparedStatement.executeUpdate();
            query = "SELECT posted_announcements FROM users WHERE id = ?";
            List<Integer> announcements = new ArrayList<>();
            try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                preparedStatement1.setInt(1, announcement.getUserId());
                ResultSet resultSet = preparedStatement1.executeQuery();
                if (resultSet.next() && resultSet.getArray(1) != null) {
                    Integer[] array = (Integer[]) resultSet.getArray(1).getArray();
                    for (Integer elem : array) {
                        announcements.add(elem);
                    }
                }
                announcements.add(announcement.getId());
                announcements.forEach(System.out::println);
                Integer[] announcementsSQL = announcements.toArray(new Integer[announcements.size()]);
                Array array = connection.createArrayOf("Integer", announcementsSQL);
                query = "UPDATE users SET posted_announcements = ? WHERE id = ?";
                try (PreparedStatement preparedStatement2 = connection.prepareStatement(query)) {
                    preparedStatement2.setArray(1, array);
                    preparedStatement2.setInt(2, announcement.getUserId());
                    preparedStatement2.executeUpdate();
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

    // Update announcement
    @Override
    public void updateAnnouncement(AnnouncementImpl announcement) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "SELECT id FROM announcement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcement.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "UPDATE announcement SET title = ?, description = ?, category_id = ?, price = ?, is_available = ?, status = ?, view_number = ?, localisation = ?, user_id = ? WHERE id = ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setString(1, announcement.getTitle().toLowerCase());
                    preparedStatement1.setString(2, announcement.getDescription().toLowerCase());
                    preparedStatement1.setInt(3, announcement.getCategoryId());
                    preparedStatement1.setDouble(4, announcement.getPrice());
                    preparedStatement1.setBoolean(5, announcement.isAvailable());
                    preparedStatement1.setObject(6, announcement.getStatus(), java.sql.Types.OTHER);
                    preparedStatement1.setInt(7, announcement.getView_number());
                    preparedStatement1.setString(8, announcement.getLocalisation().toLowerCase());
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
    public void deleteAnnouncement(AnnouncementImpl announcement) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "DELETE FROM announcement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcement.getId());
            preparedStatement.executeUpdate();
            query = "SELECT posted_announcements FROM users WHERE id = ?";
            List<Integer> announcements = new ArrayList<>();
            try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                preparedStatement1.setInt(1, announcement.getUserId());
                ResultSet resultSet = preparedStatement1.executeQuery();
                if (resultSet.next() && resultSet.getArray(1) != null) {
                    Integer[] array = (Integer[]) resultSet.getArray(1).getArray();
                    for (Integer elem : array) {
                        if (elem == announcement.getId()) announcements.remove(elem);
                        break;
                    }
                }
                announcements.forEach(System.out::println);
                Integer[] announcementsSQL = announcements.toArray(new Integer[announcements.size()]);
                Array array = connection.createArrayOf("Integer", announcementsSQL);
                query = "UPDATE users SET posted_announcements = ? WHERE id = ?";
                try (PreparedStatement preparedStatement2 = connection.prepareStatement(query)) {
                    preparedStatement2.setArray(1, array);
                    preparedStatement2.setInt(2, announcement.getUserId());
                    preparedStatement2.executeUpdate();
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

    // Search announcement by name, category and/or price
    @Override
    public AnnouncementImpl searchAnnouncement(String title, Integer category, Double price) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM announcement WHERE (title LIKE ? AND category_id = ? AND price = ?) OR (title LIKE ? AND category_id = ?) OR price = ?";
        title = (title == null) ? "" : title;
        category = (category == null) ? 0 : category;
        price = (price == null) ? 0 : price;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + title.toLowerCase() + "%");
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
        Connection connection = vintudFactory.getConnectionManager();
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
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM announcement WHERE localisation LIKE ? ORDER BY price";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + localisation.toLowerCase() + "%");
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
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "UPDATE announcement SET status = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, Status.ARTICLE_REQUESTED, java.sql.Types.OTHER);
            preparedStatement.setInt(2, id);
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
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return 0;
        }
        String query = "SELECT view_number FROM announcement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int view_number = resultSet.getInt("view_number");
                System.out.println(view_number);
                return view_number;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Display posted announcements by user
    @Override
    public List<AnnouncementImpl> disAnnByUser(int id) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT posted_announcements FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getArray(1) != null) {
                Integer[] array = (Integer[]) resultSet.getArray(1).getArray();
                List<AnnouncementImpl> announcements = new ArrayList<>();
                for (Integer elem : array) {
                    query = "SELECT * FROM announcement WHERE id = ?";
                    try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                        preparedStatement1.setInt(1, elem);
                        resultSet = preparedStatement1.executeQuery();
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
                            announcements.add(announcement);
                        }
                    }
                }
                announcements.forEach(System.out::println);
                return announcements;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Display favorite announcements by user
    @Override
    public List<AnnouncementImpl> disFavByUser(int id) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT favorite_announcements FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getArray(1) != null) {
                Integer[] array = (Integer[]) resultSet.getArray(1).getArray();
                List<AnnouncementImpl> announcements = new ArrayList<>();
                for (Integer elem : array) {
                    query = "SELECT * FROM announcement WHERE id = ?";
                    try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                        preparedStatement1.setInt(1, elem);
                        resultSet = preparedStatement1.executeQuery();
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
                            announcements.add(announcement);
                        }
                    }
                }
                announcements.forEach(System.out::println);
                return announcements;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
