package com.vintud;

import java.util.List;

public class UserController {
    VintudFactory vintudFactory = new VintudFactoryImpl();

/*
        UserImpl user = new UserImpl();
        user.setFirstName("foulen");
        user.setLastName("ben falten");
        user.setPseudo("foulenbenfalten");
        user.setEmail("foulen@gmail.com");
        user.setPassword("Foulen777");
        user.setPhoneNumber("192019201920");
        user.setAddress("5 rue Ibn Sina");
        user.setRoleId(3);
        vintudFactory.getUserDaoImpl().signup(user);

        vintudFactory.getUserDaoImpl().login("coding@cara.com", "unmotdepassedemoussaillon");

        vintudFactory.getUserDaoImpl().logout(3);

        vintudFactory.getUserDaoImpl().updateUserProfile(user);


        vintudFactory.getAnnouncementDaoImpl().disFavByUser(2);

 */


    // Get announcements by user
    public List<AnnouncementImpl> getAnnByUser(int id) {
        return vintudFactory.getAnnouncementDaoImpl().disAnnByUser(id);
    }

    // Get favorites by user
    public List<AnnouncementImpl> getFavByUser(int id) {
        return vintudFactory.getAnnouncementDaoImpl().disFavByUser(id);
    }
}
