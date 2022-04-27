package com.vintud;

import java.sql.*;

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
    public void deleteFavorite(int id) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "DELETE FROM favorites WHERE id = ?";
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
}
