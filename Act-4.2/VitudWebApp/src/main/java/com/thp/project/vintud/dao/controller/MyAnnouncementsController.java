package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;

import java.util.List;

public class MyAnnouncementsController {
    static VintudFactory vintudFactory = new VintudFactoryImpl();
    AnnouncementDao announcementDao = vintudFactory.getAnnouncementDaoImpl();

    public List<AnnouncementImpl> getMyAnnouncements(int id) {
        return announcementDao.disAnnByUser(id);
    }
}
