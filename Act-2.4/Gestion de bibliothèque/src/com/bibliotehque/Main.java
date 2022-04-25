package com.bibliotehque;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = ConnectionManager.getConnection();
        if (con == null) {
            System.out.println("Connection not found");
        } else {
            System.out.println("Connected successfully");
        }


        LibraryManager libraryManager = new LibraryManager();

       libraryManager.createUser(3, "foulen", "ben falten", "5 rue Ibn Khaldoun", "0019201920", "foulen@gmail.com");
        libraryManager.createUser(4, "foulena", "ben faltena", "20 rue Ibn Charaf", "0019201920", "foulena@gmail.com");

        Library library1 = new Library();
        library1.setId(1);
        Library library2 = new Library();
        library2.setId(2);
        libraryManager.createBook(5, "title1","author1", "editor1", 555,"summary1", library1);
        libraryManager.createBook(6, "title2","author2", "editor2", 777,"summary2", library2);

        User user1 = new User();
        user1.setId(3);
        Book book1 = new Book();
        book1.setId(5);

        libraryManager.addBook(book1, library1);

        User user2 = new User();
        user2.setId(4);
        Book book2 = new Book();
        book2.setId(6);
        Book book3 = new Book();
        book3.setId(2);
        libraryManager.createPret(3,"2021-11-07","2022-02-17", user1, book1);
        libraryManager.createPret(4,"2020-10-05","2017-05-14", user2, book2);
        libraryManager.createPret(5,"2000-10-05","2010-05-14", user2, book3);

        libraryManager.display(library1);
        libraryManager.display(library2);

        libraryManager.sortBooksAuthor(library1);

        libraryManager.searchBookId(2);
        libraryManager.searchBookId(5);

        libraryManager.searchBookAuthor("Kathy Sierra");
        libraryManager.searchBookAuthor("author2");

        libraryManager.displayBooksRentLibrary(library1);
        libraryManager.displayBooksRentLibrary(library2);

        libraryManager.displayBooksRentUser(user1);
        libraryManager.displayBooksRentUser(user2);

        libraryManager.searchUserId(1);
        libraryManager.searchUserId(3);

        libraryManager.sortRentDateFinDesc(library1);
        libraryManager.sortRentDateFinDesc(library2);







        /*try {
            Statement stmt = con.createStatement();
            //ResultSet res = stmt.executeQuery("CREATE DATABASE db_bibliotheque");
            ResultSet res = stmt.executeQuery("CREATE TABLE fffff(id int)");
            //étape 4: exécuter la requête
            while(res.next())
                System.out.println(res.getInt(1)+"  "+res.getString(2)
                        +"  "+res.getString(3));
            //étape 5: fermez l'objet de connexion
            con.close();
        } catch (SQLException e) {
            //traitement de l'exception
        }*/
    }
}
