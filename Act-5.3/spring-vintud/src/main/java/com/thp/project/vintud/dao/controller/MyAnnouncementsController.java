package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyAnnouncementsController {
    @Autowired
    VintudFactory vintudFactory;

    public List<AnnouncementImpl> getMyAnnouncements(int id) {
        return vintudFactory.getAnnouncementDaoImpl().disAnnByUser(id);
    }

    public void deleteAnnouncement(AnnouncementImpl announcement) {
        vintudFactory.getAnnouncementDaoImpl().deleteAnnouncement(announcement);
    }

    public String updateAnnouncement(AnnouncementImpl announcement) {
        return vintudFactory.getAnnouncementDaoImpl().updateAnnouncement(announcement);
    }
}
