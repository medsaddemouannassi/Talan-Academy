package com.thp.springmvc.config;

import com.thp.springmvc.entity.Moussaillon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.thp.springmvc")
public class MoussaillonConfig {
    @Bean
    public Moussaillon moussaillon() {
        return new Moussaillon();
    }
}
