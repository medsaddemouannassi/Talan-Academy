package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;

import java.util.List;

public class AnnouncementController {
    static VintudFactory vintudFactory = new VintudFactoryImpl();
    AnnouncementDao announcementDao = vintudFactory.getAnnouncementDaoImpl();

    // Get all announcements
    public List<AnnouncementImpl> getAnnouncements() {
        return announcementDao.displayAnnouncements();
    }

    // Get announcement by title, category id and/or price
    public AnnouncementImpl getAnnouncement(String title, int categoryId, double price) {
        return announcementDao.searchAnnouncement(title,categoryId,price);
    }

    // Get announcements by price
    public List<AnnouncementImpl> getAnnouncementsByPrice(double minPrice, double maxPrice) {
        return announcementDao.filterAnnouncementByPrice(minPrice, maxPrice);
    }

    // Get announcements By localisation
    public List<AnnouncementImpl> getAnnouncementsByLocalisation(String localisation) {
        return announcementDao.filterAnnouncementByLocalisation(localisation);
    }

    // Get view number
    public int getViewNumber(int id) {
        return announcementDao.displayViewNumber(id);
    }

    // Get info seller
    public UserImpl getInfoSeller(AnnouncementImpl announcement) {
        return vintudFactory.getUserDaoImpl().displayInfoSeller(announcement);
    }
}
