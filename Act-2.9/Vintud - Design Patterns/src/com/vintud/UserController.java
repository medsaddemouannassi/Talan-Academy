package com.vintud;

public class UserController {
    public static void main(String[] args) {
        VintudFactory vintudFactory = new VintudFactoryImpl();

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

        vintudFactory.getAnnouncementDaoImpl().disAnnByUser(1);

        vintudFactory.getAnnouncementDaoImpl().disFavByUser(2);

    }
}
