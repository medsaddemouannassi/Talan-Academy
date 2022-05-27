package com.thp.project.vintud;

import com.thp.project.vintud.entity.impl.CategoryImpl;
import com.thp.project.vintud.entity.impl.RoleImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import com.thp.project.vintud.helper.ModelMapperConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
