package com.vintud;

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
