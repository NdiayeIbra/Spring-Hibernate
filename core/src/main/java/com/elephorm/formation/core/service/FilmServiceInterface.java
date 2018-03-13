/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.service;

import com.elephorm.formation.core.entity.Film;
import java.util.List;

/**
 *
 * @author ibran
 */
public interface FilmServiceInterface {
        public void registerFilm(Film film);
    
    public Film getId(int id);
    
    public List<Film> findAll();
    
}
