package com.vintud;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        user.setFirstName("foulen");
        user.setLastName("ben falten");
        user.setPseudo("foulenbenfalten");
        user.setEmail("foulen@gmail.com");
        user.setPassword("Foulen777");
        user.setPhoneNumber("192019201920");
        user.setAddress("5 rue Ibn Sina");
        user.setRoleId(3);
        AnnouncementManager.signup(user);

        AnnouncementManager.login("coding@cara.com", "unmotdepassedemoussaillon");

        AnnouncementManager.updateUserProfile("foulen@gmail.com",user);

        AnnouncementManager.displayAnnouncements();

        AnnouncementManager.displayInfoSeller(1);

        AnnouncementImpl announcement = new AnnouncementImpl();
        announcement.setId(3);
        announcement.setTitle("announcement 1");
        announcement.setDescription("description 1");
        announcement.setCategoryId(2);
        announcement.setPrice(17.27);
        announcement.setPublication_date(Date.valueOf("2020-12-05"));
        announcement.setAvailable(true);
        announcement.setView_number(7);
        announcement.setLocalisation("Tunis");
        announcement.setUserId(1);
        AnnouncementManager.createAnnouncement(announcement);

        AnnouncementImpl announcement1 = new AnnouncementImpl();
        announcement1.setTitle("announcement 3");
        announcement1.setDescription("description 3");
        announcement1.setCategoryId(2);
        announcement1.setPrice(17.27);
        announcement1.setPublication_date(Date.valueOf("2020-12-05"));
        announcement1.setAvailable(true);
        announcement1.setView_number(7);
        announcement1.setLocalisation("Tunis");
        announcement1.setUserId(1);
        AnnouncementManager.updateAnnouncement(3, announcement1);

        AnnouncementManager.deleteAnnouncement(3);

        AnnouncementManager.logout(3);



    }
}
