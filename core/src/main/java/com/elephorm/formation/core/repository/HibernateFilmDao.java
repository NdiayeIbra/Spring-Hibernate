/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.repository;

import com.elephorm.formation.core.entity.Film;
import com.elephorm.formation.core.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JLM
 */
public class HibernateFilmDao {
    public void save(Film film) {
        // 1 : Ouverture unité de travail hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // 2 : Ouverture transaction 
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            // 3 : Instanciation Objet métier (passé en paramètre)
            // 4 : Persistance Objet/Relationnel : création d'un enregistrement en base
            session.persist(film);
            
            // 5 : Fermeture transaction 
            tx.commit();
        } catch (HibernateException he1) {
            he1.printStackTrace();
            if(tx != null){
                try{
                    tx.rollback();
                }
                catch(HibernateException he2){
                    he2.printStackTrace();
                }
            }

        } finally {
            if(session != null){
                try{
                    // 6 : Fermeture unité de travail hibernate
                    session.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }

        }   
    }
    
    /**
     * On recupère le film à parti de son ID via la session
     */
    public Film getId(int id) {
        // 1 : Ouverture unité de travail hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // 2 : Ouverture transaction : pas nécesaaire pour une lecture
        Transaction tx = null;
        Film film = null;
        try {
            tx = session.beginTransaction();
            // 3 : Instanciation Objet métier (passé en paramètre)
            // 4 : Persistance Objet/Relationnel : création d'un enregistrement en base
            
            film = (Film)session.get(Film.class, id);
            
            // On gère la lazy loading : on force la récupération de l'acteur principal
            Hibernate.initialize(film.getActeurPrincipal());
            Hibernate.initialize(film.getActeurSecondaire());
            
            // 5 : Fermeture transaction 
            tx.commit();
        } catch (HibernateException he1) {
            he1.printStackTrace();
            if(tx != null){
                try{
                    tx.rollback();
                }
                catch(HibernateException he2){
                    he2.printStackTrace();
                }
            }

        } finally {
            if(session != null){
                try{
                    // 6 : Fermeture unité de travail hibernate
                    session.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }   
        return film;
    }
    
    /**
     * On recupère le film à parti de son ID via la session
     */
    public List<Film> findAll() {
        // 1 : Ouverture unité de travail hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // 2 : Ouverture transaction : pas nécesaaire pour une lecture
        Transaction tx = null;
        List<Film>  films = null;
        try {
            tx = session.beginTransaction();
            // 3 : Instanciation Objet métier (passé en paramètre)
            // 4 : Persistance Objet/Relationnel : création d'un enregistrement en base
            
            Query query = session.createQuery("from Film");
            films = query.list();
            
            // Ici on n'a pas besoin de charger les acteurs 
            // Hibernate.initialize(film.getActeurPrincipal());
            // Hibernate.initialize(film.getActeurSecondaire());
            
            // 5 : Fermeture transaction 
            tx.commit();
        } catch (HibernateException he1) {
            he1.printStackTrace();
            if(tx != null){
                try{
                    tx.rollback();
                }
                catch(HibernateException he2){
                    he2.printStackTrace();
                }
            }

        } finally {
            if(session != null){
                try{
                    // 6 : Fermeture unité de travail hibernate
                    session.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }   
        return films;
    }
}

