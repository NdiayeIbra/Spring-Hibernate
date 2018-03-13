/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.repository;

import com.elephorm.formation.core.entity.Film;
import java.util.List;

/**
 *
 * @author ibran
 */
public interface FilmDaoInterface {
    public void save(Film film);
    public Film getId(int id);
    public List<Film> findAll();
    
}
