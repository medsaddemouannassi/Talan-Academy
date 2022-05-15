package com.thp.spring.simplecontext;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppXMLMain {
    public static void main(String[] args) {
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        Moussaillon moussaillon = vApplicationContext.getBean("moussaillon", Moussaillon.class);
        System.out.println("Le prénom du moussaillon : " + moussaillon.getFirstName());
        System.out.println("Le nom du moussaillon : " + moussaillon.getLastName());
        System.out.println("Configuration utilisée : " + moussaillon.getConfig());
        System.out.println("Bravo, vous venez de créer votre premier contexte Spring en " + moussaillon.getConfig() + "!!");
    }
}
