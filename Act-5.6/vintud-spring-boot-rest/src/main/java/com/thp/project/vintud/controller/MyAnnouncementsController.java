package com.thp.project.vintud.controller;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MyAnnouncementsController {
//    @Autowired
//    VintudFactory vintudFactory;

    public List<AnnouncementImpl> getMyAnnouncements(int id) {
        return null;
    }

    public void deleteAnnouncement(AnnouncementImpl announcement) {

    }

    public String updateAnnouncement(AnnouncementImpl announcement) {
        return null;
    }
}
