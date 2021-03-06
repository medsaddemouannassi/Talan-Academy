package com.thp.project.vintud.dao;

import com.thp.project.vintud.entity.impl.Search;

public interface SearchDao {
    void createSearch(Search search);
    void deleteSearch(int id);
    Search useSavedSearch(int id);
    void updateSearch(Search search);
}
