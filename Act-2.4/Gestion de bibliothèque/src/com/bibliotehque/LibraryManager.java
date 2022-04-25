package com.bibliotehque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LibraryManager implements LibraryManagerAction {
    @Override
    public List<Book> display(Library library) {
        Connection connection = ConnectionManager.getConnection();
        List<Book> books = new LinkedList<>();
        if (connection == null) {
            return null;
        } else {
            String query = "SELECT * FROM book WHERE library_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, library.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getInt("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setEditor(resultSet.getString("editor"));
                    book.setPageNb(resultSet.getInt("page_nb"));
                    book.setSummary(resultSet.getString("summary"));
                    book.setLibrary(library);
                    books.add(book);
                }
                books.forEach(System.out::println);
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
        return books;
    }

    @Override
    public void addBook(Book book, Library library) {
        Connection connection = ConnectionManager.getConnection();
        if (connection == null) {
            return;
        } else {
            String query = "UPDATE book SET library_id = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                book.setLibrary(library);
                preparedStatement.setInt(1, library.getId());
                preparedStatement.setInt(2, book.getId());

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

    @Override
    public List<Book> sortBooksAuthor(Library library) {
        Connection connection = ConnectionManager.getConnection();
        List<Book> books = new ArrayList<>();
        if (connection == null) {
            return null;
        } else {
            String query = "SELECT * FROM book ORDER BY author";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getInt("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setEditor(resultSet.getString("editor"));
                    book.setPageNb(resultSet.getInt("page_nb"));
                    book.setSummary(resultSet.getString("summary"));
                    book.setLibrary(library);
                    books.add(book);
                }
                books.forEach(System.out::println);
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
        return books;
    }

    @Override
    public Book searchBookId(int id) {
        Connection connection = ConnectionManager.getConnection();
        if (connection == null) {
            return null;
        } else {
            String query = "SELECT * FROM book WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Book book = new Book();
                    Library library = new Library();
                    library.setId(resultSet.getInt("library_id"));
                    book.setId(resultSet.getInt("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setEditor(resultSet.getString("editor"));
                    book.setPageNb(resultSet.getInt("page_nb"));
                    book.setSummary(resultSet.getString("summary"));
                    book.setLibrary(library);
                    System.out.println(book);
                    return book;
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
        return null;
    }

    @Override
    public Book searchBookAuthor(String author) {
        Connection connection = ConnectionManager.getConnection();
        if (connection == null) {
            return null;
        } else {
            String query = "SELECT * FROM book WHERE author = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, author);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Book book = new Book();
                    Library library = new Library();
                    library.setId(resultSet.getInt("library_id"));
                    book.setId(resultSet.getInt("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setEditor(resultSet.getString("editor"));
                    book.setPageNb(resultSet.getInt("page_nb"));
                    book.setSummary(resultSet.getString("summary"));
                    book.setLibrary(library);
                    System.out.println(book);
                    return book;
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
        return null;
    }

    @Override
    public List<Book> displayBooksRentLibrary(Library library) {
        Connection connection = ConnectionManager.getConnection();
        List<Book> books = new LinkedList<>();
        if (connection == null) {
            return null;
        } else {
            String query = "SELECT * FROM book JOIN rent ON book.id = rent.book_id WHERE library_id =?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, library.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setId(resultSet.getInt("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setEditor(resultSet.getString("editor"));
                    book.setPageNb(resultSet.getInt("page_nb"));
                    book.setSummary(resultSet.getString("summary"));
                    book.setLibrary(library);
                    books.add(book);
                }
                books.forEach(System.out::println);
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
        return books;
    }

    @Override
    public List<Book> displayBooksRentUser(User user) {
        Connection connection = ConnectionManager.getConnection();
        List<Book> books = new LinkedList<>();
        if (connection == null) {
            return null;
        } else {
            String query = "SELECT * FROM book INNER JOIN rent ON book.id = rent.book_id WHERE user_id =?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, user.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    Library library = new Library();
                    library.setId(resultSet.getInt("library_id"));
                    book.setId(resultSet.getInt("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setEditor(resultSet.getString("editor"));
                    book.setPageNb(resultSet.getInt("page_nb"));
                    book.setSummary(resultSet.getString("summary"));
                    book.setLibrary(library);
                    books.add(book);
                }
                books.forEach(System.out::println);
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
        return books;
    }

    @Override
    public User searchUserId(int id) {
        Connection connection = ConnectionManager.getConnection();
        if (connection == null) {
            return null;
        } else {
            String query = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setPrenom(resultSet.getString("prenom"));
                    user.setNom(resultSet.getString("nom"));
                    user.setAddress(resultSet.getString("address"));
                    user.setNumTel(resultSet.getString("tel"));
                    user.setMail(resultSet.getString("mail"));
                    System.out.println(user);
                    return user;
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
        return null;
    }

    @Override
    public List<Rent> sortRentDateFinDesc(Library library) {
        Connection connection = ConnectionManager.getConnection();
        List<Rent> rents = new ArrayList<>();
        if (connection == null) {
            return null;
        } else {
            String query = "SELECT * FROM rent INNER JOIN book ON rent.book_id = book.id WHERE library_id =? ORDER BY date_fin DESC";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, library.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Rent rent = new Rent();
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    Book book = new Book();
                    book.setId(resultSet.getInt("book_id"));
                    rent.setId(resultSet.getInt("id"));
                    rent.setDatePret(resultSet.getString("date_pret"));
                    rent.setDateFin(resultSet.getString("date_fin"));
                    rent.setUser(user);
                    rent.setBook(book);
                    rents.add(rent);
                }
                rents.forEach(System.out::println);
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
        return rents;
    }

    @Override
    public void createUser(int id, String prenom, String nom, String address, String tel, String mail) {
        Connection connection = ConnectionManager.getConnection();
        if (connection == null) {
            return;
        } else {
            String query = "INSERT INTO users (id, prenom, nom, address, tel, mail) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                User user = new User();
                user.setId(id);
                user.setPrenom(prenom);
                user.setNom(nom);
                user.setAddress(address);
                user.setNumTel(tel);
                user.setMail(mail);
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, user.getPrenom());
                preparedStatement.setString(3, user.getNom());
                preparedStatement.setString(4, user.getAddress());
                preparedStatement.setString(5, user.getNumTel());
                preparedStatement.setString(6, user.getMail());

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

    @Override
    public void createPret(int id, String datePret, String dateFin, User user, Book book) {
        Connection connection = ConnectionManager.getConnection();
        if (connection == null) {
            return;
        } else {
            String query = "INSERT INTO rent (id, date_pret, date_fin, user_id, book_id) VALUES (?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                Rent rent = new Rent();
                rent.setId(id);
                rent.setDatePret(datePret);
                rent.setDateFin(dateFin);
                rent.setUser(user);
                rent.setBook(book);
                preparedStatement.setInt(1, rent.getId());
                preparedStatement.setDate(2, new java.sql.Date(rent.getDatePret().getTime()));
                preparedStatement.setDate(3, new java.sql.Date(rent.getDateFin().getTime()));
                preparedStatement.setInt(4, rent.getUser().getId());
                preparedStatement.setInt(5, rent.getBook().getId());

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

    @Override
    public void createBook(int id, String title, String author, String editor, int pages, String summary, Library library) {
        Connection connection = ConnectionManager.getConnection();
        if (connection == null) {
            return;
        } else {
            String query = "INSERT INTO book (id, title, author, editor, page_nb, summary, library_id) VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                Book book = new Book();
                book.setId(id);
                book.setTitle(title);
                book.setAuthor(author);
                book.setEditor(editor);
                book.setPageNb(pages);
                book.setSummary(summary);
                book.setLibrary(library);
                preparedStatement.setInt(1, book.getId());
                preparedStatement.setString(2, book.getTitle());
                preparedStatement.setString(3, book.getAuthor());
                preparedStatement.setString(4, book.getEditor());
                preparedStatement.setInt(5, book.getPageNb());
                preparedStatement.setString(6, book.getSummary());
                preparedStatement.setObject(7, book.getLibrary().getId());

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
