package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.entity.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionController {

    @Autowired
    VintudFactory vintudFactory;
    public UserImpl logIn(String email, String password) {
        return vintudFactory.getUserDaoImpl().login(email, password);
    }

    public void logOut(int id) {
        vintudFactory.getUserDaoImpl().logout(id);
    }

}
