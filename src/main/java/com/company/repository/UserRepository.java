package com.company.repository;

import com.company.config.DatabaseConfig;
import com.company.users.User;

import java.sql.*;

public class UserRepository {
    private static UserRepository single_instance = null;;

    private UserRepository(){}

    public static UserRepository getInstance() {
        if (single_instance == null) {
            single_instance = new UserRepository();
        }
        return single_instance;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS user " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "name varchar(30), " +
                "email varchar(30)," +
                "password varchar(30))";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User user) {
        String insertUserSql = "INSERT INTO user(name, email, password) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserSql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        String selectSql = "SELECT * FROM user WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(String name, String email, String password, int id) {
        String updateUserSql = "UPDATE user SET name=?, email=?, password=? WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateUserSql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id){
        String deleteUserSql = "DELETE FROM user WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteUserSql)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new User(resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4));
        }
        return null;
    }
}
