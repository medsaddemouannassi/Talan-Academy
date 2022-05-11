package com.thp.project.vintud.dao.controller;

import com.sun.deploy.net.HttpRequest;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;
import com.thp.project.vintud.entity.User;
import com.thp.project.vintud.entity.impl.UserImpl;

public class SignInController {
    VintudFactory vintudFactory = new VintudFactoryImpl();
    public void signIn(HttpRequest request) {
        UserImpl user = new UserImpl();
        /*vintudFactory.getUserDaoImpl().signup(UserImpl);*/
    }
}
