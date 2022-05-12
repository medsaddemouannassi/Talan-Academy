package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;
import com.thp.project.vintud.entity.impl.UserImpl;

public class ConnectionController {
    VintudFactory vintudFactory = new VintudFactoryImpl();
    UserDao userDao = vintudFactory.getUserDaoImpl();
    public UserImpl logIn(String email, String password) {
        return userDao.login(email, password);
    }

}
