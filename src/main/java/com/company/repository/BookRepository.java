package com.company.repository;

import com.company.books.Book;
import com.company.config.DatabaseConfig;
import com.company.users.Author;
import com.company.users.Publisher;
import com.company.users.User;

import java.sql.*;

public class BookRepository {
    private static BookRepository single_instance = null;;

    private BookRepository(){}

    public static BookRepository getInstance() {
        if (single_instance == null) {
            single_instance = new BookRepository();
        }
        return single_instance;
    }

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS book " +
                "(id int PRIMARY KEY AUTO_INCREMENT, " +
                "title varchar(30), " +
                "publisher int," +
                "author int," +
                "genre varchar(30)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBook(Book book) {
        String insertSql = "INSERT INTO book(title, publisher, author, genre) VALUES(?, ?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getPublisher().getUserId());
            preparedStatement.setInt(3, book.getAuthor().getUserId());
            preparedStatement.setString(4, book.getGenre());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public User getBookById(int id) {
//        String selectSql = "SELECT * FROM book WHERE id=?";
//
//        Connection connection = DatabaseConfig.getDatabaseConnection();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
//            preparedStatement.setInt(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            return mapToBook(resultSet);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public void updateBook(String title, Publisher publisher, Author author, String genre) {
        String updateSql = "UPDATE person SET title=?, publisher=?, author=?, genre=? WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, publisher.getUserId());
            preparedStatement.setInt(3, author.getUserId());
            preparedStatement.setString(4, genre);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id){
        String deleteSql = "DELETE FROM book WHERE id=?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    private User mapToBook(ResultSet resultSet) throws SQLException {
//        if (resultSet.next()) {
//            PublisherRepository publisherRepository = PublisherRepository.getInstance();
//            AuthorRepository authorRepository = AuthorRepository.getInstance();
//            return new Book(resultSet.getString(2),
//                    publisherRepository.getPublisherByUserId(resultSet.getInt(3)),
//                    authorRepository.getAuthorById(resultSet.getInt(4)), resultSet.getString(5));
//        }
//        return null;
//    }
}
