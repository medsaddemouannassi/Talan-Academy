package com.thp.project.vintud.dao.factory;

import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.FavoriteDao;
import com.thp.project.vintud.dao.SearchDao;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.db.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class VintudFactoryImpl implements VintudFactory {
    @Autowired
    AnnouncementDao announcementDao;
    @Autowired
    FavoriteDao favoriteDao;
    @Autowired
    SearchDao searchDao;
    @Autowired
    UserDao userDao;

    @Override
    public AnnouncementDao getAnnouncementDaoImpl() {
        return announcementDao;
    }

    @Override
    public FavoriteDao getFavoriteDaoImpl() {
        return favoriteDao;
    }

    @Override
    public SearchDao getSearchDaoImpl() {
        return searchDao;
    }

    @Override
    public UserDao getUserDaoImpl() {
        return userDao;
    }

    @Override
    public Connection getConnectionManager() {
        return ConnectionManager.getInstance().getConnection();
    }
}
