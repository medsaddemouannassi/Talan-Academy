package com.bibliotehque;

import java.util.ArrayList;
import java.util.Date;

public interface LibraryManagerAction {
    public void display(Library library);
    public void addBook(Book book, Library library);
    public void sortBooksAuthor(Library library);
    public void searchBookId(int id, Library library);
    public void searchBookAuthor(String author, Library library);
    public void displayBooksRentLibrary(Library library);
    public void displayBooksRentUser(User user);
    public void searchUserId(int id, Library library);
    public void sortRentDateFinDesc(Library library);
    public void createUser(int id, String prenom, String nom, String address, int tel, String mail, ArrayList<Rent> rents);
    public void createPret(int id, User user, Book book, Date datePret, Date dateFin);
    public void createBook(int id, String title, String author, String editor, int pages, String summary, int library_id);
}
