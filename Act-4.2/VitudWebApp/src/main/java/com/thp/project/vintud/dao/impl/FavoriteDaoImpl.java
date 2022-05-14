package com.thp.project.vintud.dao.impl;

import com.thp.project.vintud.Status;
import com.thp.project.vintud.dao.FavoriteDao;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.Favorite;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    VintudFactory vintudFactory = new VintudFactoryImpl();



    // Create favorite announcement
    @Override
    public void createFavorite(int announcementId, int userId) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "INSERT INTO favorites(announcement_id, user_id, date_add_favorite) VALUES(?,?,?)";
        Date date = new Date(System.currentTimeMillis());
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcementId);
            preparedStatement.setInt(2, userId);
            preparedStatement.setDate(3, date);
            preparedStatement.executeUpdate();
            query = "SELECT favorite_announcements FROM users WHERE id = ?";
            List<Integer> announcements = new ArrayList<>();
            try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                preparedStatement1.setInt(1, userId);
                ResultSet resultSet = preparedStatement1.executeQuery();
                if (resultSet.next() && resultSet.getArray(1) != null) {
                    Integer[] array = (Integer[]) resultSet.getArray(1).getArray();
                    for (Integer elem : array) {
                        announcements.add(elem);
                    }
                }
                announcements.add(announcementId);
                Integer[] announcementsSQL = announcements.toArray(new Integer[announcements.size()]);
                Array array = connection.createArrayOf("Integer", announcementsSQL);
                query = "UPDATE users SET favorite_announcements = ? WHERE id = ?";
                try (PreparedStatement preparedStatement2 = connection.prepareStatement(query)) {
                    preparedStatement2.setArray(1, array);
                    preparedStatement2.setInt(2, userId);
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

    // Delete favorite announcement
    @Override
    public void deleteFavorite(int announcementId, int userId) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "DELETE FROM favorites WHERE announcement_id = ? AND user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcementId);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
            query = "SELECT favorite_announcements FROM users WHERE id = ?";
            List<Integer> announcements = new ArrayList<>();
            try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                preparedStatement1.setInt(1, userId);
                ResultSet resultSet = preparedStatement1.executeQuery();
                if (resultSet.next() && resultSet.getArray(1) != null) {
                    Integer[] array = (Integer[]) resultSet.getArray(1).getArray();
                    for (Integer elem : array) {
                        if (elem != announcementId ) announcements.add(elem);
                    }
                }
                Integer[] announcementsSQL = announcements.toArray(new Integer[announcements.size()]);
                Array array = connection.createArrayOf("Integer", announcementsSQL);
                query = "UPDATE users SET favorite_announcements = ? WHERE id = ?";
                try (PreparedStatement preparedStatement2 = connection.prepareStatement(query)) {
                    preparedStatement2.setArray(1, array);
                    preparedStatement2.setInt(2, userId);
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

    // Search favorite announcement
    @Override
    public Favorite searchFavorite(AnnouncementImpl announcement) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT id FROM announcement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcement.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "SELECT * FROM favorites WHERE announcement_id = ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setInt(1, resultSet.getInt("id"));
                    resultSet = preparedStatement1.executeQuery();
                    if (resultSet.next()) {
                        Favorite favorite = new Favorite();
                        favorite.setId(resultSet.getInt("id"));
                        favorite.setAnnouncementId(resultSet.getInt("announcement_id"));
                        favorite.setUserId(resultSet.getInt("user_id"));
                        favorite.setDateAddFav(resultSet.getDate("date_add_favorite"));
                        System.out.println(favorite);
                        return favorite;
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
        return null;
    }

    // Update favorite announcement
    @Override
    public void updateFavorite(Favorite favorite) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "SELECT id FROM favorites WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, favorite.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "UPDATE favorites SET announcement_id = ?, user_id = ? WHERE id= ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setInt(1, favorite.getAnnouncementId());
                    preparedStatement1.setInt(2, favorite.getUserId());
                    preparedStatement1.setInt(3, resultSet.getInt("id"));
                    preparedStatement1.executeUpdate();
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
                            announcement.setId(elem);
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
                    return announcements;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
