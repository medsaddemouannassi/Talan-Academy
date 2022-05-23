package com.thp.project.vintud.controller;

import com.thp.project.vintud.Config;
import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.CategoryImpl;
import com.thp.project.vintud.entity.impl.RoleImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnnouncementController {
    @Autowired
    UserDao userDao;
    @Autowired
    AnnouncementDao announcementDao;
    // Get all announcements
    public List<AnnouncementImpl> getAnnouncements() {
        return null;
    }

    @PostMapping(value = "/announcement")
    public void addAnnouncement(@RequestBody AnnouncementImpl announcement) {
        CategoryImpl category = new AnnotationConfigApplicationContext(Config.class).getBean(CategoryImpl.class);
        announcement.setCategoryId(category);
        announcement.setUser(userDao.findById(1).get());
        this.announcementDao.save(announcement);
    }

    // Get announcements By localisation
    @GetMapping(value = "/announcement/{announcementId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<AnnouncementImpl> getAnnouncementsById(@PathVariable int announcementId) {
        return announcementDao.findById(announcementId);
    }

    @GetMapping(value = "/announcement")
    @ResponseBody
    public List<AnnouncementImpl> all() {
        return announcementDao.findAll();
    }
}
