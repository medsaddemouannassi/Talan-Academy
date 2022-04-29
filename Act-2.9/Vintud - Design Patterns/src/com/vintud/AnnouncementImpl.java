package com.vintud;

import java.sql.Blob;
import java.sql.Date;

public class AnnouncementImpl {
    private int id;
    private String title;
    private String description;
    private int categoryId;
    private double price;
    private Blob photo;
    private Date publication_date;
    private Status status;
    private boolean is_available;
    private int view_number;
    private String localisation;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) { this.status = status; }

    public boolean isAvailable() {
        return is_available;
    }

    public void setAvailable(boolean isAvailable) {
        this.is_available = isAvailable;
    }

    public int getView_number() {
        return view_number;
    }

    public void setView_number(int view_number) {
        this.view_number = view_number;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AnnouncementImpl{" + "title='" + title + '\'' + ", description='" + description + '\'' + ", categoryId=" + categoryId + ", price=" + price + ", photo=" + photo + ", publication_date=" + publication_date + ", status='" + status + '\'' + ", is_available=" + is_available + ", view_number=" + view_number + ", localisation='" + localisation + '\'' + ", userId=" + userId + '}';
    }
}
