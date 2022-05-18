package com.thp.project.vintud.configuration;

import com.thp.project.vintud.entity.Announcement;
import com.thp.project.vintud.entity.Category;
import com.thp.project.vintud.entity.Role;
import com.thp.project.vintud.entity.User;
import com.thp.project.vintud.entity.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.thp.project.vintud")
public class VintudConfiguration {
    @Bean
    public Announcement getAnnouncement() {
        return new AnnouncementImpl();
    }
    @Bean
    public Favorite getFavorite() {
        return new Favorite();
    }
    @Bean
    public Category getCategory() {
        return new CategoryImpl();
    }
    @Bean
    public Role getRole() {
        return new RoleImpl();
    }
    @Bean
    public Search getSearch() {
        return new Search();
    }
    @Bean
    public User getUser() {
        return new UserImpl();
    }
}
