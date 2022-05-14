package com.thp.project.vintud.dao;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.Favorite;

import java.util.List;

public interface FavoriteDao {
    List<AnnouncementImpl> disFavByUser(int id);
    void createFavorite(int userId, int announcementId);
    void deleteFavorite(int announcementId, int userId);
    Favorite searchFavorite(AnnouncementImpl announcement);
    void updateFavorite(Favorite favoris);
}
