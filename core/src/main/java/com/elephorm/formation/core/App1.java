/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core;

import com.elephorm.formation.core.controller.DefaultFilmController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author JLM
 */
public class App1 {
    public static void main(String [] args){
        // Instanciation avec l'application context
//        DefaultFilmController controller = new DefaultFilmController();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DefaultFilmController controller = (DefaultFilmController) context.getBean("filmController");
        // Création d'un Film
        controller.createFilmFromInputConsole();
    }
}
