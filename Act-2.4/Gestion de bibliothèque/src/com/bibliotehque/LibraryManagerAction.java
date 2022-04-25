package com.bibliotehque;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface LibraryManagerAction {
    public List<Book> display(Library library);
    public void addBook(Book book, Library library);
    public List<Book> sortBooksAuthor(Library library);
    public Book searchBookId(int id);
    public Book searchBookAuthor(String author);
    public List<Book> displayBooksRentLibrary(Library library);
    public List<Book> displayBooksRentUser(User user);
    public User searchUserId(int id);
    public List<Rent> sortRentDateFinDesc(Library library);
    public void createUser(int id, String prenom, String nom, String address, String tel, String mail);
    public void createPret(int id, String datePret, String dateFin, User user, Book book);
    public void createBook(int id, String title, String author, String editor, int pages, String summary, Library library);
}
