package com.thp.project.vintud.config;

import com.thp.project.vintud.entity.impl.CategoryImpl;
import com.thp.project.vintud.entity.impl.RoleImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.project.vintud.helper.ModelMapperConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {
    @Bean
    RoleImpl role() {
        return new RoleImpl();
    }
    @Bean
    CategoryImpl category() {
        return new CategoryImpl();
    }
    @Bean
    UserImpl user() {
        return new UserImpl();
    }
    @Bean
    ModelMapperConverter modelMapperConverter() {
        return new ModelMapperConverter();
    }
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
