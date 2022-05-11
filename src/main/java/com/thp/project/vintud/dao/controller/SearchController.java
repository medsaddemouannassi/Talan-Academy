package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.Search;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.dao.factory.VintudFactoryImpl;

public class SearchController {
    VintudFactory vintudFactory = new VintudFactoryImpl();
/*
        Search search = new Search();
        search.setId(1);
        search.setClothingType("t-shirt");
        search.setSize("S");
        search.setColor("red");
        search.setMinPrice(17d);
        search.setMaxPrice(27d);
        search.setUserId(1);
        vintudFactory.getSearchDaoImpl().createSearch(search);

        vintudFactory.getSearchDaoImpl().updateSearch(search);



        vintudFactory.getSearchDaoImpl().deleteSearch(1);

 */


    // Get saved Search By User
    public Search getSavedSearch(int id) {
        return vintudFactory.getSearchDaoImpl().useSavedSearch(id);
    }
}
