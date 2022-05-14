package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;

import java.util.List;

public class FavoriteController {
    VintudFactory vintudFactory = new VintudFactoryImpl();

    // Get favorite announcement
    public List<AnnouncementImpl> getFavorite(int id) {
        return vintudFactory.getFavoriteDaoImpl().disFavByUser(id);
    }

    public void addToFavorite(int announcementId, int userId) {
        vintudFactory.getFavoriteDaoImpl().createFavorite(announcementId, userId);
    }

    public void deleteFromFavorite(int announcementId, int userId) {
        vintudFactory.getFavoriteDaoImpl().deleteFavorite(announcementId, userId);
    }
}
