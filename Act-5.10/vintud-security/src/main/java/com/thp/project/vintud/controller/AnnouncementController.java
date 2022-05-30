package com.thp.project.vintud.controller;

import com.thp.project.vintud.dto.AnnouncementDto;
import com.thp.project.vintud.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RestController
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @PostMapping(value = "/announcement")
    public void addAnnouncement(@RequestBody AnnouncementDto announcement) {
        this.announcementService.addAnnouncement(announcement);
    }

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping(value = "/announcement/{announcementId}")
    @ResponseBody
    public AnnouncementDto getAnnouncement(@PathVariable int announcementId) {
        return announcementService.getAnnouncementById(announcementId);
    }

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping(value = "/announcement")
    @ResponseBody
    public List<AnnouncementDto> all() {
        return announcementService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @DeleteMapping(value = "/announcement/{announcementId}")
    public void delete(@PathVariable int announcementId) {
        announcementService.delete(announcementId);
    }
}
