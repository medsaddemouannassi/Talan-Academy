package com.thp.project.vintud.service;

import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.dto.AnnouncementDto;
import com.thp.project.vintud.helper.ModelMapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    UserDao userDao;
    private final AnnouncementDao announcementDao;

    private final ModelMapperConverter modelMapperConverter;

    public AnnouncementService(ModelMapperConverter modelMapperConverter, AnnouncementDao announcementDao) {
        this.modelMapperConverter = modelMapperConverter;
        this.announcementDao = announcementDao;
    }

    public void addAnnouncement(AnnouncementDto announcement) {
        announcementDao.save(modelMapperConverter.toAnnouncement(announcement));
    }

    public AnnouncementDto getAnnouncementById(int announcementId) {
        return modelMapperConverter.toAnnouncementDto(announcementDao.findById(announcementId));
    }

    public List<AnnouncementDto> findAll() {
        return ModelMapperConverter.mapAll(announcementDao.findAll(), AnnouncementDto.class);
    }

    public void delete(int announcementId) {
        announcementDao.deleteById(announcementId);
    }
}
