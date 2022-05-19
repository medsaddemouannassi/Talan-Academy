package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserController {
    @Autowired
    VintudFactory vintudFactory;
    // Get announcements by user
    public List<AnnouncementImpl> getAnnByUser(int id) {
        return vintudFactory.getAnnouncementDaoImpl().disAnnByUser(id);
    }

}
