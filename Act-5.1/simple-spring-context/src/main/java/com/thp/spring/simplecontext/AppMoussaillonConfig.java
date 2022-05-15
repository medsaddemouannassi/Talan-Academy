package com.thp.spring.simplecontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppMoussaillonConfig {

    @Bean
    public Moussaillon moussaillon() {
        Moussaillon moussaillon = new Moussaillon();
        moussaillon.setFirstName("Johnny");
        moussaillon.setLastName("Depp");
        moussaillon.setConfig("Java");
        return moussaillon;
    }
}
