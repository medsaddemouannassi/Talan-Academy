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
    void deleteAnnouncement(int id);

    // Search announcement by name, category and/or price
    AnnouncementImpl search(String name, String category, double price);
}
