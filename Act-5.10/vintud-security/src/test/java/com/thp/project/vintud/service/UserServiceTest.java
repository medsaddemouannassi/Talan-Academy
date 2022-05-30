package com.thp.project.vintud.service;

import com.thp.project.vintud.config.Config;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.dto.UserDto;
import com.thp.project.vintud.entity.impl.RoleImpl;
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
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserDao userDao;

    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    private ModelMapperConverter modelMapperConverter;

    @BeforeEach
    void setUp() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        this.modelMapperConverter = applicationContext.getBean(ModelMapperConverter.class);
        this.userService = new UserService(this.modelMapperConverter, this.userDao, this.passwordEncoder);
    }

    @Test
    void findAll() {
//        when
        this.userService.findAll();
//        then
        verify(userDao).findAll();
    }

    @Test
    void addUser() {
//        given
        UserDto user = new UserDto();
        RoleImpl role = new RoleImpl();
        role.setName("r1");
        user.setUser_id(1);
        user.setFirstName("zzz");
        user.setLastName("zzz");
        user.setAddress("zzz");
        user.setEmail("zzz");
        user.setPassword(this.passwordEncoder.encode("zzz"));
        user.setPseudo("zzz");
        user.setPhoneNumber("22222222");
        user.setRole_id(role);


//        when
        userService.addUser(user);
        UserImpl user1 = modelMapperConverter.toUser(user);
//        then
        ArgumentCaptor<UserImpl> argumentCaptor = ArgumentCaptor.forClass(UserImpl.class);
//        UserImpl argumentCaptor1 = modelMapperConverter.toUser(argumentCaptor.capture().);
        verify(userDao).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue().toString()).isEqualTo(user1.toString());
    }

    @Test
    void canGetUserById() {
//        given
        int id = 3;
//        when
        userService.getUserById(id);
//        then
        verify(userDao).findById(id);
    }

    @Test
    void canGetUserByUsername() {
        //        given
        String username = "ca";
//        when
        userService.getUserByUsername(username);
//        then
        verify(userDao).findUserImplByPseudo(username);
    }

    @Test
    void delete() {
        //        given
        int id = 3;
//        when
        userService.delete(id);
//        then
        verify(userDao).deleteById(id);
    }

    @Test
    void loadUserByUsername() {
        //        given
        String username = "e";
//        when
        userService.loadUserByUsername(username);
//      then
        verify(userDao).findUserImplByPseudo(username);
    }
}