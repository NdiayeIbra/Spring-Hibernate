/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core;

import com.elephorm.formation.core.controller.DefaultFilmController;
import com.elephorm.formation.core.entity.Film;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author JLM
 */
public class App3 {
    public static void main(String [] args){
         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DefaultFilmController controller = (DefaultFilmController) context.getBean("filmController");
        // Sélection d'un film
        controller.getListeFilm();
    }
}
