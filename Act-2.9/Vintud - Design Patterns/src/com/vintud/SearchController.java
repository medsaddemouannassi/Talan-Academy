package com.vintud;

public class SearchController {
    public static void main(String[] args) {
        VintudFactory vintudFactory = new VintudFactoryImpl();

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

        vintudFactory.getSearchDaoImpl().useSavedSearch(1);


        vintudFactory.getSearchDaoImpl().deleteSearch(1);
    }
}
