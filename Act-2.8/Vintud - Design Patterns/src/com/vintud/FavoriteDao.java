package com.vintud;

public interface FavoriteDao {
    void createFavorite(Favorite favoris);
    void deleteFavorite(int id);
    Favorite searchFavorite(AnnouncementImpl announcement);
    void updateFavorite(Favorite favoris);
}
