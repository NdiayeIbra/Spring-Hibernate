/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.repository.hibernate;

import com.elephorm.formation.core.entity.Film;
import com.elephorm.formation.core.repository.FilmDaoInterface;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JLM
 */
@Repository
public class HibernateFilmDao implements FilmDaoInterface{
    
    // Avec l'injection de Spring de la SessionFactory, on n'a plus besoin de HibernateUtil
    @Resource
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Film film) {
        
        Session session = sessionFactory.getCurrentSession();
       
        session.persist(film);
         
    }
    
    /**
     * On recupère le film à parti de son ID via la session
     */
    @Override
    public Film getId(int id) {
        // 1 : Ouverture unité de travail hibernate
        Session session = sessionFactory.getCurrentSession();

        // 2 : Ouverture transaction : pas nécesaaire pour une lecture
        Film film = null;
            
            film = (Film)session.get(Film.class, id);
            
            // On gère la lazy loading : on force la récupération de l'acteur principal
            // Avec l'aspect trasactionel ça se gère dans le service
//            Hibernate.initialize(film.getActeurPrincipal());
//            Hibernate.initialize(film.getActeurSecondaire());
            
        return film;
    }
    
    /**
     * On recupère le film à parti de son ID via la session
     */
    @Override
    public List<Film> findAll() {
        // 1 : Ouverture unité de travail hibernate
        Session session = sessionFactory.getCurrentSession();

        // 2 : Ouverture transaction : pas nécesaaire pour une lecture
        List<Film>  films = null;
            // 3 : Instanciation Objet métier (passé en paramètre)
            // 4 : Persistance Objet/Relationnel : création d'un enregistrement en base
            
            Query query = session.createQuery("from Film");
            films = query.list();
            
            // Ici on n'a pas besoin de charger les acteurs 
            // Hibernate.initialize(film.getActeurPrincipal());
            // Hibernate.initialize(film.getActeurSecondaire());
            
            // 5 : Fermeture transaction 
       
        return films;
    }
}

