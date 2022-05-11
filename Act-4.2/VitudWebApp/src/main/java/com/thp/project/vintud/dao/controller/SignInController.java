package com.thp.project.vintud.dao.controller;

import com.sun.deploy.net.HttpRequest;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;
import com.thp.project.vintud.entity.User;
import com.thp.project.vintud.entity.impl.UserImpl;

public class SignInController {
    VintudFactory vintudFactory = new VintudFactoryImpl();
    UserDao userDao = vintudFactory.getUserDaoImpl();

    public String signin(UserImpl user) {
        return userDao.signup(user);
    }

}
