package com.vintud;

public interface VintudFactory {
    default VintudFactory createInstance(int i) {
        return i == 0 ? ConnectionManager.getInstance() : i == 1 ? new AnnouncementDaoImpl() : i == 2 ? new FavoriteDaoImpl() : i == 3 ? new SearchDaoImpl() : new UserDaoImpl();
    }
}
