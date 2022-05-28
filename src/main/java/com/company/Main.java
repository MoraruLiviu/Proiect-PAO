package com.company;

import com.company.books.LightNovel;
import com.company.books.LimitedBook;
import com.company.config.DatabaseConfig;
import com.company.repository.PublisherRepository;
import com.company.repository.UserRepository;
import com.company.services.LimitedBookService;
import com.company.users.Author;
import com.company.users.Publisher;
import com.company.users.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        Author auth1 = new Author("Ion","unemail@hotmail.com","cabr0n",21,"Romania");
        Author auth2 = new Author("Daniel","somebritishbuy@gmai.com","p@ssw0rd",54,"Scotland");
        Author auth3 = new Author("Ghilas","ramdaleen@yahoo.com","f14fvdw4gn",34,"Algeria");

        Publisher pub1 = new Publisher("Eduexpress","contact@edux.com","v9834hvg02","Bucharest");
        Publisher pub2 = new Publisher("delipedia","delipedux@gmail.com","vgsb328fh","Prague");
        Publisher pub3 = new Publisher("Gartinelle","gartinelle@contact.com","vb448fb08","Madrid");

        LimitedBook lb1 = new LimitedBook("Spyfull adventure",pub1,auth2,"detective", new SimpleDateFormat("dd-MM-yyyy").parse("10-7-2019"),new SimpleDateFormat("dd-MM-yyyy").parse("10-7-2020"));
        LimitedBook lb2 = new LimitedBook("Hogging riders",pub2,auth3,"Fantasy",new SimpleDateFormat("dd-MM-yyyy").parse("23-12-2018"),new SimpleDateFormat("dd-MM-yyyy").parse("12-11-2019"));
        LimitedBook lb3 = new LimitedBook("Title",pub3,auth1,"Meta",new SimpleDateFormat("dd-MM-yyyy").parse("6-8-2020"),new SimpleDateFormat("dd-MM-yyyy").parse("2-4-2021"));

        LightNovel ln1 = new LightNovel("Spyfull adventure",pub1,auth1,"detective", 230);
        LightNovel ln2 = new LightNovel("Daniel Jabroni Adventure",pub2,auth2,"fantasy", 410);
        LightNovel ln3 = new LightNovel("Who asked saga",pub3,auth3,"science-fiction", 156);

        LimitedBookService limitedBooks = new LimitedBookService();

        limitedBooks.addBook(lb1);
        limitedBooks.addBook(lb2);
        limitedBooks.addBook(lb3);

        List<LimitedBook> sortedLimitedBooks;
        sortedLimitedBooks = limitedBooks.sortByDiscYear(limitedBooks.getBooks());
        LimitedBookService.printAllBooks(sortedLimitedBooks);

//        UserRepository userRepository = UserRepository.getInstance();
//        userRepository.createTable();

//        userRepository.insertUser(new User("Alexandra", "smth@gmail.com", "abrOvbR"));
//        userRepository.insertUser(new User("Daniel", "adress@gmail.com", "ag6gfr4"));
//        userRepository.insertUser(new User("Gorgon", "value@gmail.com", "ffgt4g5"));

//        userRepository.updateUser("Silvia", "smthelse@yahoo.com", "agasF43f",1);
//        User user = userRepository.getUserById(1);
//        System.out.println("Name = " + user.getName());

//        userRepository.deleteUser(3);
//        userRepository.deleteUser(4);


        PublisherRepository publisherRepository = PublisherRepository.getInstance();
        publisherRepository.createTable();

//        publisherRepository.insertPublisher(pub1);
//        publisherRepository.insertPublisher(pub2);
//        publisherRepository.insertPublisher(pub3);

//        publisherRepository.updatePublisherByUserId("Kekingstan", 5);

//        publisherRepository.deletePublisherByUserId(4);



//        DatabaseConfig.closeDatabaseConnection();


//        AuditService auditService = new AuditService();
//
//        writeLimitedBook(lb1);
//        auditService.logAction("Inserted LimitedBook");
//        writeLimitedBook(lb2);
//        auditService.logAction("Inserted LimitedBook");
//        writeLimitedBook(lb3);
//        auditService.logAction("Inserted LimitedBook");
//
//        writeAuthor(auth1);
//        auditService.logAction("Inserted Author");
//        writeAuthor(auth2);
//        auditService.logAction("Inserted Author");
//        writeAuthor(auth3);
//        auditService.logAction("Inserted Author");
//
//        writePublisher(pub1);
//        auditService.logAction("Inserted Publisher");
//        writePublisher(pub2);
//        auditService.logAction("Inserted Publisher");
//        writePublisher(pub3);
//        auditService.logAction("Inserted Publisher");
//
//        writeLightNovel(ln1);
//        auditService.logAction("Inserted Publisher");
//        writeLightNovel(ln2);
//        auditService.logAction("Inserted Publisher");
//        writeLightNovel(ln3);
//        auditService.logAction("Inserted Publisher");
    }


}
