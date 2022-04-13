package com.company;

import com.company.books.LimitedBook;
import com.company.services.LimitedBookService;
import com.company.users.Author;
import com.company.users.Publisher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        Author auth1 = new Author("Ion","unemail@hotmail.com","cabr0n",21,"Romania");
        Author auth2 = new Author("Daniel","somebritishbuy@gmai.com","p@ssw0rd",54,"Scotland");
        Author auth3 = new Author("Ghilas","ramdaleen@yahoo.com","f14fvdw4gn",34,"Algeria");

        Publisher pub1 = new Publisher("Eduexpress","contact@edux.com","v9834hvg02","Bucharest");
        Publisher pub2 = new Publisher("delipedia","delipedux@gmail.com","vgsb328fh","Prague");
        Publisher pub3 = new Publisher("Gartinelle","gartinelle@contact.com","vb448fb08","Madrid");

        LimitedBook lb1 = new LimitedBook("Spyfull adventure",pub1,auth2,"detective", new SimpleDateFormat("dd-MM-yyyy").parse("10-7-2019"),new SimpleDateFormat("dd-MM-yyyy").parse("10-7-2020"));
        LimitedBook lb2 = new LimitedBook("Hogging riders",pub2,auth3,"Fantasy",new SimpleDateFormat("dd-MM-yyyy").parse("23-12-2018"),new SimpleDateFormat("dd-MM-yyyy").parse("12-11-2019"));
        LimitedBook lb3 = new LimitedBook("Title",pub3,auth1,"Meta",new SimpleDateFormat("dd-MM-yyyy").parse("6-8-2020"),new SimpleDateFormat("dd-MM-yyyy").parse("2-4-2021"));

        LimitedBookService limitedBooks = new LimitedBookService();

        limitedBooks.addBook(lb1);
        limitedBooks.addBook(lb2);
        limitedBooks.addBook(lb3);

        List<LimitedBook> sortedLimitedBooks;
        sortedLimitedBooks = limitedBooks.sortByDiscYear(limitedBooks.getBooks());
        LimitedBookService.printAllBooks(sortedLimitedBooks);


    }
}
