package com.vintud;

import java.util.List;

public interface AnnouncementDao {
    // Display all announcements
    List<AnnouncementImpl> displayAnnouncements();

    // Create announcement
    void createAnnouncement(AnnouncementImpl announcement);

    // Update announcement
    void updateAnnouncement(AnnouncementImpl announcement);

    // Delete announcement
    void deleteAnnouncement(AnnouncementImpl announcement);

    // Search announcement by name, category and/or price
    AnnouncementImpl searchAnnouncement(String name, Integer category, Double price);

    // Filter announcements by price
    List<AnnouncementImpl> filterAnnouncementByPrice(Double minPrice, Double maxPrice);

    // Filter announcements by localisation
    List<AnnouncementImpl> filterAnnouncementByLocalisation(String localisation);

    // Send request to reserve article
    void SendReqReserveArticle(int id);

    // Display view number
    int displayViewNumber(int id);
}
