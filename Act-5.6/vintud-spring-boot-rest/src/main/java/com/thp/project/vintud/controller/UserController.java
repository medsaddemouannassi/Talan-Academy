package com.thp.project.vintud.controller;

import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private AnnouncementDao announcementDao;

    @Autowired
    private UserDao userDao;

    // Get announcements by user
    @GetMapping(value = "user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<AnnouncementImpl> getAnnByUser(@PathVariable int id) {

        return announcementDao.findById(id);
    }

    @PostMapping(value = "/")
    public void addUser(@RequestBody UserImpl user) {
        System.out.println(user);
        userDao.save(user);
    }

}
