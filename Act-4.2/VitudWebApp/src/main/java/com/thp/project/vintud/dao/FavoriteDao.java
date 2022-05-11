package com.thp.project.vintud.dao;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.Favorite;

public interface FavoriteDao {
    void createFavorite(int userId, int announcementId);
    void deleteFavorite(int id);
    Favorite searchFavorite(AnnouncementImpl announcement);
    void updateFavorite(Favorite favoris);
}
