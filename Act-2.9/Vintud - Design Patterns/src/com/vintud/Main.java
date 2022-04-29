package com.vintud;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        VintudFactory vintudFactory = new VintudFactoryImpl();


        vintudFactory.getAnnouncementDaoImpl().disFavByUser(2);

    }
}
