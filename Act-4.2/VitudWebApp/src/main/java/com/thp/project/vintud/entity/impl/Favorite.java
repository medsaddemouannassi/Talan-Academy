package com.thp.project.vintud.entity.impl;

import java.sql.Date;

public class Favorite {
    private int id;
    private int announcementId;
    private int userId;
    private Date dateAddFav;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateAddFav() {
        return dateAddFav;
    }

    public void setDateAddFav(Date dateAddFav) {
        this.dateAddFav = dateAddFav;
    }

    @Override
    public String toString() {
        return "Favoris{" + "announcementId=" + announcementId + ", userId=" + userId + ", dateAddFav=" + dateAddFav + '}';
    }
}
