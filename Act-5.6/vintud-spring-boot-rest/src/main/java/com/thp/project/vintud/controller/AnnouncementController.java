package com.thp.project.vintud.controller;

import com.thp.project.vintud.Config;
import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.dto.AnnouncementDto;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.CategoryImpl;
import com.thp.project.vintud.entity.impl.RoleImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.project.vintud.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;

    @Transactional
    @PostMapping(value = "/announcement")
    public void addAnnouncement(@RequestBody AnnouncementDto announcement) {
        this.announcementService.addAnnouncement(announcement);
    }

    @Transactional
    @GetMapping(value = "/announcement/{announcementId}")
    @ResponseBody
    public AnnouncementDto getAnnouncement(@PathVariable int announcementId) {
        return announcementService.getAnnouncementById(announcementId);
    }

    @Transactional
    @GetMapping(value = "/announcement")
    @ResponseBody
    public List<AnnouncementDto> all() {
        return announcementService.findAll();
    }

    @Transactional
    @DeleteMapping(value = "/announcement/{announcementId}")
    public void delete(@PathVariable int announcementId) {
        announcementService.delete(announcementId);
    }
}
