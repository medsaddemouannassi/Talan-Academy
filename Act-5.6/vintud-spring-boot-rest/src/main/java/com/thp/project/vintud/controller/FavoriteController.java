package com.thp.project.vintud.controller;

import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FavoriteController {
//    @Autowired
//    VintudFactory vintudFactory;

    // Get favorite announcement
    public List<AnnouncementImpl> getFavorite(int id) {
        return null;
    }

    public void addToFavorite(int announcementId, int userId) {
    }

    public void deleteFromFavorite(int announcementId, int userId) {
    }
}
