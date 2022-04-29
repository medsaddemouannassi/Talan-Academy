package com.vintud;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

public class AnnouncementController {
    static VintudFactory vintudFactory = new VintudFactoryImpl();

        /*
        vintudFactory.getAnnouncementDaoImpl().createAnnouncement(announcement);

        AnnouncementImpl announcement1 = new AnnouncementImpl();
        announcement1.setId(1);
        announcement1.setTitle("announcement 3");
        announcement1.setDescription("description 3");
        announcement1.setCategoryId(2);
        announcement1.setPrice(17.27);
        announcement1.setPublication_date(Date.valueOf("2020-12-05"));
        announcement1.setStatus(Status.VALIDATED);
        announcement1.setAvailable(true);
        announcement1.setView_number(7);
        announcement1.setLocalisation("Tunis");
        announcement1.setUserId(3);
        vintudFactory.getAnnouncementDaoImpl().updateAnnouncement(announcement1);

        vintudFactory.getAnnouncementDaoImpl().deleteAnnouncement(announcement);

        vintudFactory.getAnnouncementDaoImpl().SendReqReserveArticle(1);

        */

    // Get all announcements
    public static ResultSet getAnnouncements() {
        return vintudFactory.getAnnouncementDaoImpl().displayAnnouncements();
    }

    // Get announcement by title, category id and/or price
    public AnnouncementImpl getAnnouncement(String title, int categoryId, double price) {
        return vintudFactory.getAnnouncementDaoImpl().searchAnnouncement(title,categoryId,price);
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
