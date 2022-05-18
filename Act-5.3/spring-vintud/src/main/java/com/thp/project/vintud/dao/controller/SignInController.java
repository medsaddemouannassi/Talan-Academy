package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.entity.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInController {
    @Autowired
    VintudFactory vintudFactory;
    public String signUp(UserImpl user) {
        return vintudFactory.getUserDaoImpl().signup(user);
    }

}
