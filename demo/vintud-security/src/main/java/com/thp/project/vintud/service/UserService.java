package com.thp.project.vintud.service;

import com.thp.project.vintud.dao.UserDao;
import com.thp.project.vintud.dto.UserDto;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.project.vintud.helper.ModelMapperConverter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserDao userDao;

    private final ModelMapperConverter modelMapperConverter;
    private final PasswordEncoder passwordEncoder;

    public UserService(ModelMapperConverter modelMapperConverter, UserDao userDao, PasswordEncoder passwordEncoder) {
        this.modelMapperConverter = modelMapperConverter;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> findAll() {
        return ModelMapperConverter.mapAll(userDao.findAll() , UserDto.class);
    }
                                            
    public void addUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserImpl user = modelMapperConverter.toUser(userDto);
        this.userDao.save(user);
    }

    public UserDto getUserById(int userId) {
        return modelMapperConverter.toUserDto(userDao.findById(userId));
    }

    public UserDto getUserByUsername(String username) {
        return modelMapperConverter.toUserDto(Optional.ofNullable(userDao.findUserImplByPseudo(username)));
    }
    public void delete(int userId) {
        userDao.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserImpl user = userDao.findUserImplByPseudo(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole_id().getName()));
        return new User(user.getPseudo(), user.getPassword(), authorities);
    }
}
