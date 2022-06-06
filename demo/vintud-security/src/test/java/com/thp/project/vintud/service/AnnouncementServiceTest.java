package com.thp.project.vintud.service;

import com.thp.project.vintud.config.Config;
import com.thp.project.vintud.Status;
import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dto.AnnouncementDto;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.CategoryImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.project.vintud.helper.ModelMapperConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AnnouncementServiceTest {
    @Mock
    private AnnouncementDao announcementDao;

    @Autowired
    private AnnouncementService announcementService;

    private ModelMapperConverter modelMapperConverter;

    @BeforeEach
    void setUp() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        this.modelMapperConverter = applicationContext.getBean(ModelMapperConverter.class);
        this.announcementService = new AnnouncementService(this.modelMapperConverter, this.announcementDao);
    }

    @Test
    void addAnnouncement() {
//        given
        AnnouncementDto announcement = new AnnouncementDto();
        CategoryImpl category = new CategoryImpl();
        UserImpl user = new UserImpl();
        user.setUser_id(5);
        category.setCategory_id(2);
        announcement.setAnnouncement_id(1);
        announcement.setTitle("zzz");
        announcement.setDescription("zzz");
        announcement.setLocalisation("zzz");
        announcement.setAvailable(true);
        announcement.setPrice(77);
        announcement.setStatus(Status.WAITING_FOR_VALIDATION);
        announcement.setCategoryId(category);
        announcement.setUser(user);


//        when
        announcementService.addAnnouncement(announcement);
        AnnouncementImpl announcement1 = modelMapperConverter.toAnnouncement(announcement);
//        then
        ArgumentCaptor<AnnouncementImpl> argumentCaptor = ArgumentCaptor.forClass(AnnouncementImpl.class);
//        UserImpl argumentCaptor1 = modelMapperConverter.toUser(argumentCaptor.capture().);
        verify(announcementDao).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().toString()).isEqualTo(announcement1.toString());

    }

    @Test
    void canGetAnnouncementById() {
        //        given
        int id = 5;
//        when
        announcementService.getAnnouncementById(id);
//        then
        verify(announcementDao).findById(id);
    }

    @Test
    void findAll() {
//        when
        this.announcementService.findAll();
//        then
        verify(announcementDao).findAll();
    }

    @Test
    void delete() {
        //        given
        int id = 3;
//        when
        announcementService.delete(id);
//        then
        verify(announcementDao).deleteById(id);
    }
}