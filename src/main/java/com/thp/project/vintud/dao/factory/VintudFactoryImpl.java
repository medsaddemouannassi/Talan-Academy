package com.thp.project.vintud.dao.factory;

import com.thp.project.vintud.db.ConnectionManager;
import com.thp.project.vintud.dao.impl.AnnouncementDaoImpl;
import com.thp.project.vintud.dao.impl.FavoriteDaoImpl;
import com.thp.project.vintud.dao.impl.SearchDaoImpl;
import com.thp.project.vintud.dao.impl.UserDaoImpl;

import java.sql.Connection;

public class VintudFactoryImpl implements VintudFactory {
    @Override
    public AnnouncementDaoImpl getAnnouncementDaoImpl() {
        return new AnnouncementDaoImpl();
    }

    @Override
    public FavoriteDaoImpl getFavoriteDaoImpl() {
        return new FavoriteDaoImpl();
    }

    @Override
    public SearchDaoImpl getSearchDaoImpl() {
        return new SearchDaoImpl();
    }

    @Override
    public UserDaoImpl getUserDaoImpl() {
        return new UserDaoImpl();
    }

    @Override
    public Connection getConnectionManager() {
        return ConnectionManager.getInstance().getConnection();
    }
}
