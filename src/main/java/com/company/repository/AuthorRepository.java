package com.company.repository;

import com.company.config.DatabaseConfig;
import com.company.users.Author;
import com.company.users.User;

import java.sql.*;

public class AuthorRepository {
    private static AuthorRepository single_instance = null;;

    private AuthorRepository(){}

    public static AuthorRepository getInstance() {
        if (single_instance == null) {
            single_instance = new AuthorRepository();
        }
        return single_instance;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS author " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "userid int, " +
                "age int," +
                "country varchar(30))";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAuthor(Author author) {
        String insertAuthorSql = "INSERT INTO author(userid, age, country) VALUES(?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAuthorSql)) {
            preparedStatement.setInt(1, author.getUserId());
            preparedStatement.setInt(2, author.getAge());
            preparedStatement.setString(3, author.getCountry());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getAuthorById(int userid) {
        String selectSql = "SELECT * FROM author WHERE userid=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, userid);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateAuthorByUserId(int age, String country, int userid) {
        String updateUserSql = "UPDATE author SET age=?, country=? WHERE userid=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateUserSql)) {
            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, country);
            preparedStatement.setInt(3, userid);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAuthorByUserId(int userid){
        String deleteAuthorSql = "DELETE FROM author WHERE userid=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteAuthorSql)) {
            preparedStatement.setInt(1, userid);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Author(resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getInt(5),
                    resultSet.getString(6));
        }
        return null;
    }
}
