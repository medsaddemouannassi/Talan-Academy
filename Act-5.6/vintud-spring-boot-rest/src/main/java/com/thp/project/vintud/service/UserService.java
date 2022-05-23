package com.thp.project.vintud.service;

import com.thp.project.vintud.Config;
import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.dto.UserDto;
import com.thp.project.vintud.entity.impl.RoleImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.project.vintud.helper.ModelMapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    ModelMapperConverter modelMapperConverter;

    public List<UserDto> findAll() {
        return ModelMapperConverter.mapAll(userDao.findAll() , UserDto.class);
    }

    public void addUser(UserDto userDto) {
        UserImpl user = modelMapperConverter.toUser(userDto);
        RoleImpl r = new AnnotationConfigApplicationContext(Config.class).getBean(RoleImpl.class);
        r.setName("r1");
        user.setRole_id(r);
        this.userDao.save(user);
    }

    public UserDto getUser(@PathVariable int userId) {
        return modelMapperConverter.toUserDto(userDao.findById(userId).get());
    }

    public void delete(int userId) {
        userDao.deleteById(userId);
    }
}
