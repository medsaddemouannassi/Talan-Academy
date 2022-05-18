package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAnnouncementController {
    @Autowired
    VintudFactory vintudFactory;

    public String createAnnouncement(AnnouncementImpl announcement) {
        return vintudFactory.getAnnouncementDaoImpl().createAnnouncement(announcement);
    }
}
