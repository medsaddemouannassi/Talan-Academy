package com.thp.project.vintud;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;

public class Main {
    public static void main(String[] args) {
        VintudFactory vintudFactory = new VintudFactoryImpl();


        vintudFactory.getAnnouncementDaoImpl().disFavByUser(2);

    }
}
