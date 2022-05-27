package com.thp.project.vintud.service;

import com.thp.project.vintud.Config;
import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.dto.AnnouncementDto;
import com.thp.project.vintud.entity.impl.CategoryImpl;
import com.thp.project.vintud.helper.ModelMapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    UserDao userDao;
    @Autowired
    AnnouncementDao announcementDao;

    @Autowired
    ModelMapperConverter modelMapperConverter;

    public void addAnnouncement(AnnouncementDto announcement) {
        CategoryImpl category = new AnnotationConfigApplicationContext(Config.class).getBean(CategoryImpl.class);
        announcement.setCategoryId(category);
        announcement.setUser(userDao.findById(1).get());
        announcementDao.save(modelMapperConverter.toAnnouncement(announcement));
    }

    public AnnouncementDto getAnnouncementById(int announcementId) {
        return modelMapperConverter.toAnnouncementDto(announcementDao.findById(announcementId).get());
    }

    public List<AnnouncementDto> findAll() {

        return ModelMapperConverter.mapAll(announcementDao.findAll(), AnnouncementDto.class);
    }

    public void delete(int announcementId) {
        announcementDao.deleteById(announcementId);
    }
}
