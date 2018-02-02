/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.service;

import com.elephorm.formation.core.entity.Film;
import com.elephorm.formation.core.repository.FileFilmDao;
import com.elephorm.formation.core.repository.HibernateFilmDao;
import com.elephorm.formation.core.repository.JdbcFilmDao;
import java.util.List;
        

/**
 *
 * @author JLM
 */
public class FilmService {
    
    FileFilmDao fileDao = new FileFilmDao();
    JdbcFilmDao jdbcDao = new JdbcFilmDao();
    HibernateFilmDao hibernateDao = new HibernateFilmDao();
    
    public void registerFilm(Film film){
        // Saugegaer via Fichier        
        // fileDao.save(film);
        
        // Saugegaer via JDBC
        // jdbcDao.save(film);
        
        // Saugegaer via Hibernate
        hibernateDao.save(film);
    }
    
    public Film getId(int id){
        return hibernateDao.getId(id);
    }
    
    public List<Film> findAll(){
        return hibernateDao.findAll();
    }
    
}
