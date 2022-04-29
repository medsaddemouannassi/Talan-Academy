package com.vintud;

public interface SearchDao {
    void createSearch(Search search);
    void deleteSearch(int id);
    Search useSavedSearch(int id);
    void updateSearch(Search search);
}
