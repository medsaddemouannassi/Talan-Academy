package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementController {
    @Autowired
    VintudFactory vintudFactory;

    // Get all announcements
    public List<AnnouncementImpl> getAnnouncements() {
        return vintudFactory.getAnnouncementDaoImpl().displayAnnouncements();
    }

    // Get announcement by title, category id and/or price
    public AnnouncementImpl getAnnouncement(String title, int categoryId, double price) {
        return vintudFactory.getAnnouncementDaoImpl().searchAnnouncement(title, categoryId, price);
    }

    // Get announcements by price
    public List<AnnouncementImpl> getAnnouncementsByPrice(double minPrice, double maxPrice) {
        return vintudFactory.getAnnouncementDaoImpl().filterAnnouncementByPrice(minPrice, maxPrice);
    }

    // Get announcements By localisation
    public List<AnnouncementImpl> getAnnouncementsByLocalisation(String localisation) {
        return vintudFactory.getAnnouncementDaoImpl().filterAnnouncementByLocalisation(localisation);
    }

    // Get view number
    public int getViewNumber(int id) {
        return vintudFactory.getAnnouncementDaoImpl().displayViewNumber(id);
    }

    // Get info seller
    public UserImpl getInfoSeller(AnnouncementImpl announcement) {
        return vintudFactory.getUserDaoImpl().displayInfoSeller(announcement);
    }
}
