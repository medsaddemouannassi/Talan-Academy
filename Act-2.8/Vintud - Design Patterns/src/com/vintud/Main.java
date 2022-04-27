package com.vintud;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        VintudFactory vintudFactory = new VintudFactoryImpl();

        UserImpl user = new UserImpl();
        user.setFirstName("foulen");
        user.setLastName("ben falten");
        user.setPseudo("foulenbenfalten");
        user.setEmail("foulen@gmail.com");
        user.setPassword("Foulen777");
        user.setPhoneNumber("192019201920");
        user.setAddress("5 rue Ibn Sina");
        user.setRoleId(3);
        vintudFactory.getUserDaoImpl().signup(user);

        vintudFactory.getUserDaoImpl().login("coding@cara.com", "unmotdepassedemoussaillon");

        vintudFactory.getUserDaoImpl().logout(3);


        vintudFactory.getUserDaoImpl().updateUserProfile(user);

        vintudFactory.getUserDaoImpl().displayInfoSeller(1);


        vintudFactory.getAnnouncementDaoImpl().displayAnnouncements();

        System.out.println((Status.WAITING_FOR_VALIDATION));
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

        vintudFactory.getAnnouncementDaoImpl().deleteAnnouncement(3);

        vintudFactory.getAnnouncementDaoImpl().searchAnnouncement("este",3,null);

        vintudFactory.getAnnouncementDaoImpl().filterAnnouncementByPrice(10d,90d);

        vintudFactory.getAnnouncementDaoImpl().filterAnnouncementByLocalisation("s");

        vintudFactory.getAnnouncementDaoImpl().SendReqReserveArticle(1);

        vintudFactory.getAnnouncementDaoImpl().displayViewNumber(1);


        vintudFactory.getFavoriteDaoImpl().createFavorite(1,2);



        Favorite favorite = new Favorite();
        favorite.setId(1);
        favorite.setAnnouncementId(2);
        favorite.setUserId(1);
        vintudFactory.getFavoriteDaoImpl().updateFavorite(favorite);

        vintudFactory.getFavoriteDaoImpl().searchFavorite(announcement1);

        vintudFactory.getFavoriteDaoImpl().deleteFavorite(2);



        Search search = new Search();
        search.setId(1);
        search.setClothingType("t-shirt");
        search.setSize("S");
        search.setColor("red");
        search.setMinPrice(17d);
        search.setMaxPrice(27d);
        search.setUserId(1);
        vintudFactory.getSearchDaoImpl().createSearch(search);

        vintudFactory.getSearchDaoImpl().updateSearch(search);

        vintudFactory.getSearchDaoImpl().useSavedSearch(1);


        vintudFactory.getSearchDaoImpl().deleteSearch(1);




    }
}
