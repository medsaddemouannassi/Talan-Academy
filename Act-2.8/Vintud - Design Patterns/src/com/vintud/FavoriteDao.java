package com.vintud;

public interface FavoriteDao {
    void createFavorite(int userId, int announcementId);
    void deleteFavorite(int id);
    Favorite searchFavorite(AnnouncementImpl announcement);
    void updateFavorite(Favorite favoris);
}
