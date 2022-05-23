package com.thp.project.vintud.controller;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AnnouncementController {
//    @Autowired
//    VintudFactory vintudFactory;

    // Get all announcements
    public List<AnnouncementImpl> getAnnouncements() {
        return null;
    }

    // Get announcement by title, category id and/or price
    public AnnouncementImpl getAnnouncement(String title, int categoryId, double price) {
        return null;
    }

    // Get announcements by price
    public List<AnnouncementImpl> getAnnouncementsByPrice(double minPrice, double maxPrice) {
        return null;
    }

    // Get announcements By localisation
    @GetMapping(value = "/announcement/{localisation}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AnnouncementImpl> getAnnouncementsByLocalisation(@PathVariable String localisation) {
        return null;
    }

    // Get view number
    public int getViewNumber(int id) {
        return 0;
    }

    // Get info seller
    public UserImpl getInfoSeller(AnnouncementImpl announcement) {
        return null;
    }
}
