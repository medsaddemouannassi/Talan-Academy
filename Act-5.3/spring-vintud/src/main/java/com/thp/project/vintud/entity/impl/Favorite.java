package com.thp.project.vintud.entity.impl;

import javax.persistence.*;
import java.sql.Date;

@Entity @Table(name = "favorites")
public class Favorite {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favorite_id;
    @OneToOne @JoinColumn(name = "announcement_id")
    private AnnouncementImpl announcement_id;
    @OneToOne @JoinColumn(name = "user_id")
    private UserImpl user;
    @Column(name = "date_add_favorite")
    private Date dateAddFav;

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public AnnouncementImpl getAnnouncement_id() {
        return announcement_id;
    }

    public void setAnnouncement_id(AnnouncementImpl announcement_id) {
        this.announcement_id = announcement_id;
    }

    public UserImpl getUser() {
        return user;
    }

    public void setUser(UserImpl user) {
        this.user = user;
    }

    public Date getDateAddFav() {
        return dateAddFav;
    }

    public void setDateAddFav(Date dateAddFav) {
        this.dateAddFav = dateAddFav;
    }

    @Override
    public String toString() {
        return "Favoris{" + "announcementId=" + announcement_id + ", userId=" + user + ", dateAddFav=" + dateAddFav + '}';
    }
}
