package com.thp.project.vintud.controller;

import com.thp.project.vintud.Config;
import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.RoleImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private AnnouncementDao announcementDao;

    @Autowired
    private UserDao userDao;

    // Get announcements by user
    @GetMapping(value = "/user/{userId}")
    @ResponseBody
    public UserImpl getUser(@PathVariable int userId) {
        return userDao.findById(userId).get();
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public List<UserImpl> all() {
        return userDao.findAll();
    }

    @PostMapping(value = "/user")
    public void addUser(@RequestBody UserImpl user) {
        RoleImpl r = new AnnotationConfigApplicationContext(Config.class).getBean(RoleImpl.class);
        user.setRole_id(r);
        this.userDao.save(user);
    }

}
