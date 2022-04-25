package com.bibliotehque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rent implements BUR {
    private int id;
    private User user;
    private Book book;
    private Date DatePret;
    private Date DateFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDatePret() {
        return DatePret;
    }

    public void setDatePret(String datePret) {
        try {
            DatePret = new SimpleDateFormat("yyyy-MM-dd").parse(datePret);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(String dateFin) {
        try {
            DateFin = new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("User: " + getUser().getPrenom() + " " + getUser().getNom());
        System.out.println("Livre: " + getBook().getTitle());
        System.out.println("Date prêt: " + getDatePret());
        System.out.println("Date fin: " + getDateFin());
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", book=" + book.getId() +
                ", DatePret=" + DatePret +
                ", DateFin=" + DateFin +
                '}';
    }
}
