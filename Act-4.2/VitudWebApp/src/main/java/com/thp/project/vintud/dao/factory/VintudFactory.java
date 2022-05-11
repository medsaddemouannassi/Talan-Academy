package com.thp.project.vintud.dao.factory;

import com.thp.project.vintud.dao.impl.AnnouncementDaoImpl;
import com.thp.project.vintud.dao.impl.FavoriteDaoImpl;
import com.thp.project.vintud.dao.impl.SearchDaoImpl;
import com.thp.project.vintud.dao.impl.UserDaoImpl;

import java.sql.Connection;

public interface VintudFactory {
    AnnouncementDaoImpl getAnnouncementDaoImpl();
    FavoriteDaoImpl getFavoriteDaoImpl();
    SearchDaoImpl getSearchDaoImpl();
    UserDaoImpl getUserDaoImpl();
    Connection getConnectionManager();
}
