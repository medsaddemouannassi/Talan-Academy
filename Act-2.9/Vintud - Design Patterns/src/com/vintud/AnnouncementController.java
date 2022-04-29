package com.vintud;

import java.sql.Date;

public class AnnouncementController {
    public static void main(String[] args) {
        VintudFactory vintudFactory = new VintudFactoryImpl();

        vintudFactory.getAnnouncementDaoImpl().displayAnnouncements();

        AnnouncementImpl announcement = new AnnouncementImpl();
        announcement.setTitle("announcement 1");
        announcement.setDescription("description 1");
        announcement.setCategoryId(2);
        announcement.setPrice(17.27);
        announcement.setPublication_date(Date.valueOf("2020-12-05"));
        announcement.setStatus(Status.WAITING_FOR_VALIDATION);
        announcement.setAvailable(true);
        announcement.setView_number(7);
        announcement.setLocalisation("Tunis");
        announcement.setUserId(1);
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

        vintudFactory.getAnnouncementDaoImpl().searchAnnouncement("este",3,null);

        vintudFactory.getAnnouncementDaoImpl().filterAnnouncementByPrice(10d,90d);

        vintudFactory.getAnnouncementDaoImpl().filterAnnouncementByLocalisation("s");

        vintudFactory.getAnnouncementDaoImpl().SendReqReserveArticle(1);

        vintudFactory.getAnnouncementDaoImpl().displayViewNumber(1);

        vintudFactory.getUserDaoImpl().displayInfoSeller(announcement);
    }
}
