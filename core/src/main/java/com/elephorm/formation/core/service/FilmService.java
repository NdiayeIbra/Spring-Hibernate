/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.service;

import com.elephorm.formation.core.entity.Film;
import com.elephorm.formation.core.repository.FilmDaoInterface;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
        

/**
 *
 * @author JLM
 */
@Service
public class FilmService implements FilmServiceInterface{
    // Instanciation avec Spring
   @Resource
    FilmDaoInterface dao;
    
    @Override
    @Transactional
    public void registerFilm(Film film){
        // Saugegaer génral via contrat d'interface de Spring
        dao.save(film);
    }
    
    @Override
    @Transactional
    public Film getId(int id){
        Film film = dao.getId(id);
        // Avec l'aspect trasactionel ça se gère dans le service
        Hibernate.initialize(film.getActeurPrincipal());
        Hibernate.initialize(film.getActeurSecondaire());
        return film;
    }
    
    @Override
    @Transactional
    public List<Film> findAll(){
        return dao.findAll();
    }
    
}
