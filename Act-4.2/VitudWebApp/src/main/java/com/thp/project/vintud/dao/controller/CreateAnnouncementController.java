package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;

public class CreateAnnouncementController {
    static VintudFactory vintudFactory = new VintudFactoryImpl();
    AnnouncementDao announcementDao = vintudFactory.getAnnouncementDaoImpl();

    public String createAnnouncement(AnnouncementImpl announcement) {
        return announcementDao.createAnnouncement(announcement);
    }
}
