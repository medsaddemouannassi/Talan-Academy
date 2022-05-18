package com.thp.project.vintud.dao.controller;

import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.entity.impl.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchController {
    @Autowired
    VintudFactory vintudFactory;

    // Get saved Search By User
    public Search getSavedSearch(int id) {
        return vintudFactory.getSearchDaoImpl().useSavedSearch(id);
    }
}
