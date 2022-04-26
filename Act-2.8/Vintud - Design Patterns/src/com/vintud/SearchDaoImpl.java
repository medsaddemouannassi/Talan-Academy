package com.vintud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchDaoImpl implements SearchDao {
    @Override
    public void createSearch(Search search) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "INSERT INTO search(clothing_type, size, color, min_price, max_price, user_id) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, search.getClothingType());
            preparedStatement.setString(2, search.getSize());
            preparedStatement.setString(3, search.getColor());
            preparedStatement.setDouble(4, search.getMinPrice());
            preparedStatement.setDouble(5, search.getMaxPrice());
            preparedStatement.setInt(6, search.getUserId());
            preparedStatement.executeUpdate();
            System.out.println(search);
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
    public void deleteSearch(int id) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "DELETE FROM search WHERE id = ?";
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
    public Search useSavedSearch(int id) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM search WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Search search = new Search();
                search.setClothingType(resultSet.getString("clothing_type"));
                search.setSize(resultSet.getString("size"));
                search.setColor(resultSet.getString("color"));
                search.setMinPrice(resultSet.getDouble("min_price"));
                search.setMaxPrice(resultSet.getDouble("max_price"));
                search.setUserId(resultSet.getInt("user_id"));
                System.out.println(search);
                return search;
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

    @Override
    public void updateSearch(Search search) {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection connection = connectionManager.getConnection();
        if (connection == null) {
            return;
        }
        String query = "SELECT id FROM search WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, search.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "UPDATE search SET clothing_type = ?, size = ?, color = ?, min_price = ?, max_price = ?, user_id = ? WHERE id = ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setString(1, search.getClothingType());
                    preparedStatement1.setString(2, search.getSize());
                    preparedStatement1.setString(3, search.getColor());
                    preparedStatement1.setDouble(4, search.getMinPrice());
                    preparedStatement1.setDouble(5, search.getMaxPrice());
                    preparedStatement1.setInt(6, search.getUserId());
                    preparedStatement1.setInt(7, resultSet.getInt("id"));
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
