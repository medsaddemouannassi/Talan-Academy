package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.entity.impl.Search;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;

public class SearchController {
    VintudFactory vintudFactory = new VintudFactoryImpl();

    // Get saved Search By User
    public Search getSavedSearch(int id) {
        return vintudFactory.getSearchDaoImpl().useSavedSearch(id);
    }
}
