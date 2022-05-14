package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;

import java.util.List;

public class UserController {
    VintudFactory vintudFactory = new VintudFactoryImpl();
    // Get announcements by user
    public List<AnnouncementImpl> getAnnByUser(int id) {
        return vintudFactory.getAnnouncementDaoImpl().disAnnByUser(id);
    }

}
