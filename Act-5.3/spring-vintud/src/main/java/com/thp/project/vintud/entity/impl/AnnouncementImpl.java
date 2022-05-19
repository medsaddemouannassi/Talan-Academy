package com.thp.project.vintud.entity.impl;

import com.thp.project.vintud.Status;
import com.thp.project.vintud.entity.Announcement;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Entity @Table(name = "announcement")
public class AnnouncementImpl implements Announcement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int announcement_id;
    private String title;
    private String description;
    @ManyToOne @JoinColumn( name="category_id" )
    private CategoryImpl categoryId;
    private double price;
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "picture")
    private Blob photo;
    private Date publication_date;
    @Type(type = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean is_available;
    private int view_number;
    private String localisation;
    @ManyToOne @JoinColumn( name="user_id" )
    private UserImpl user;

    public int getAnnouncement_id() {
        return announcement_id;
    }

    public void setAnnouncement_id(int announcement_id) {
        this.announcement_id = announcement_id;
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

    public CategoryImpl getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryImpl categoryId) {
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

    public boolean isIs_available() {
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

    public UserImpl getUser() {
        return user;
    }

    public void setUser(UserImpl user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AnnouncementImpl{" + "title='" + title + '\'' + ", description='" + description + '\'' + ", categoryId=" + categoryId + ", price=" + price + ", photo=" + photo + ", publication_date=" + publication_date + ", status='" + status + '\'' + ", is_available=" + is_available + ", view_number=" + view_number + ", localisation='" + localisation + '\'' + ", userId=" + user + '}';
    }
}
