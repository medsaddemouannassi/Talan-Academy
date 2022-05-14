package com.thp.project.vintud.dao.factory;

import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.FavoriteDao;
import com.thp.project.vintud.dao.SearchDao;
import com.thp.project.vintud.dao.UserDao;

import java.sql.Connection;

public interface VintudFactory {
    AnnouncementDao getAnnouncementDaoImpl();
    FavoriteDao getFavoriteDaoImpl();
    SearchDao getSearchDaoImpl();
    UserDao getUserDaoImpl();
    Connection getConnectionManager();
}
