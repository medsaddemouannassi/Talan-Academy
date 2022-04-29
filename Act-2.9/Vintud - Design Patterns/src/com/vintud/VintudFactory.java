package com.vintud;

import java.sql.Connection;

public interface VintudFactory {
    AnnouncementDaoImpl getAnnouncementDaoImpl();
    FavoriteDaoImpl getFavoriteDaoImpl();
    SearchDaoImpl getSearchDaoImpl();
    UserDaoImpl getUserDaoImpl();
    Connection getConnectionManager();
}
