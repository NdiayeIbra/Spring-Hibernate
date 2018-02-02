/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core;

import com.elephorm.formation.core.controller.DefaultFilmController;
import com.elephorm.formation.core.entity.Film;

/**
 *
 * @author JLM
 */
public class App3 {
    public static void main(String [] args){
        DefaultFilmController controller = new DefaultFilmController();
        // Sélection d'un film
        controller.getListeFilm();
    }
}
