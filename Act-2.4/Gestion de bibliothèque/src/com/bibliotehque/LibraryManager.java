package com.bibliotehque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class LibraryManager implements LibraryManagerAction {
    @Override
    public void display(Library library) {
        for (Book book : library.getBooks()) {
            book.display();
        }
    }

    @Override
    public void addBook(Book book, Library library) {
        Connection connection = ConnectionManager.getConnection();
        if (connection == null) {
            return;
        }
        if (book.getId() > 0) {

        } else {
        }

        library.getBooks().add(book);
    }

    class sortBooksAuthor implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }

    @Override
    public void sortBooksAuthor(Library library) {
        Collections.sort(library.getBooks(), new sortBooksAuthor());
    }

    @Override
    public void searchBookId(int id, Library library) {
        for (Book book : library.getBooks()) {
            if (book.getId() == id) {
                book.display();
            }
        }
    }

    @Override
    public void searchBookAuthor(String author, Library library) {
        for (Book book : library.getBooks()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.display();
            }
        }
    }

    @Override
    public void displayBooksRentLibrary(Library library) {
        for (Rent rent : library.getRents()) {
            rent.getBook().display();
        }
    }

    @Override
    public void displayBooksRentUser(User user) {
        for (Rent rent : user.getRents()) {
            rent.getBook().display();
        }
    }

    @Override
    public void searchUserId(int id, Library library) {
        for (Rent rent : library.getRents()) {
            if (rent.getUser().getId() == id) {
                rent.getUser().display();
            }
        }
    }

    class sortRentDateFinDesc implements Comparator<Rent> {
        @Override
        public int compare(Rent o1, Rent o2) {
            return o2.getDateFin().compareTo(o1.getDateFin());
        }
    }

    @Override
    public void sortRentDateFinDesc(Library library) {
        Collections.sort(library.getRents(), new sortRentDateFinDesc());
    }

    @Override
    public void createUser(int id, String prenom, String nom, String address, int tel, String mail, ArrayList<Rent> rents) {
        User user = new User();
        user.setId(id);
        user.setPrenom(prenom);
        user.setNom(nom);
        user.setAddress(address);
        user.setNumTel(tel);
        user.setMail(mail);
        user.setRents(rents);
    }

    @Override
    public void createPret(int id, User user, Book book, Date datePret, Date dateFin) {
        Rent rent = new Rent();
        rent.setId(id);
        rent.setUser(user);
        rent.setBook(book);
        rent.setDatePret(datePret);
        rent.setDateFin(dateFin);
    }

    @Override
    public void createBook(int id, String title, String author, String editor, int pages, String summary, int library_id) {
        Connection connection = ConnectionManager.getConnection();
        if (connection == null) {
            return;
        } else {
            String query = "INSERT INTO book (id, title, author, editor, page_nb, summary, library_id) VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, author);
                preparedStatement.setString(4, editor);
                preparedStatement.setInt(5, pages);
                preparedStatement.setString(6, summary);
                preparedStatement.setObject(7, library_id);

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
    }
}
