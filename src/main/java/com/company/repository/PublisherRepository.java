package com.company.repository;

import com.company.config.DatabaseConfig;
import com.company.users.Publisher;
import com.company.users.User;

import java.sql.*;

public class PublisherRepository {
    private static PublisherRepository single_instance = null;;

    private PublisherRepository(){}

    public static PublisherRepository getInstance() {
        if (single_instance == null) {
            single_instance = new PublisherRepository();
        }
        return single_instance;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS publisher " +
                "(id int PRIMARY KEY AUTO_INCREMENT," +
                "userid int," +
                "location varchar(30))";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPublisher(Publisher publisher) {
        String insertPublisherSql = "INSERT INTO publisher(userid, location) VALUES(?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertPublisherSql)) {
            preparedStatement.setInt(1, publisher.getUserId());
            preparedStatement.setString(2, publisher.getLocation());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getPublisherByUserId(int userid) {
        String selectPublisherSql = "SELECT * FROM publisher WHERE userid=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectPublisherSql)) {
            preparedStatement.setInt(1, userid);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updatePublisherByUserId(String location, int userid) {
        String updatePublisherSql = "UPDATE publisher SET location=? WHERE userid=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updatePublisherSql)) {
            preparedStatement.setString(1, location);
            preparedStatement.setInt(2, userid);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePublisherByUserId(int userid){
        String deletePublisherSql = "DELETE FROM publisher WHERE userid=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(deletePublisherSql)) {
            preparedStatement.setInt(1, userid);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Publisher(resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5));
        }
        return null;
    }
}
