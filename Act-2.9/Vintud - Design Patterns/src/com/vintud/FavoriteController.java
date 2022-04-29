package com.vintud;

import java.sql.Date;

public class FavoriteController {
    public static void main(String[] args) {
        VintudFactory vintudFactory = new VintudFactoryImpl();

        vintudFactory.getFavoriteDaoImpl().createFavorite(1,2);


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

        Favorite favorite = new Favorite();
        favorite.setId(1);
        favorite.setAnnouncementId(2);
        favorite.setUserId(1);
        vintudFactory.getFavoriteDaoImpl().updateFavorite(favorite);

        vintudFactory.getFavoriteDaoImpl().searchFavorite(announcement1);

        vintudFactory.getFavoriteDaoImpl().deleteFavorite(2);
    }
}
