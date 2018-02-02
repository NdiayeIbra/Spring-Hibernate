/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core;

import com.elephorm.formation.core.entity.User;
import com.elephorm.formation.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JLM
 */
public class App0 {
    public static void main(String[] args) {

            // 1 : Ouverture unité de travail hibernate
            Session session = HibernateUtil.getSessionFactory().openSession();

            // 2 : Ouverture transaction 
            Transaction tx = session.beginTransaction();

            // 3 : Instanciation Objet métier
            User user = new User();
            user.setNom("Ibra_nd");
            // 4 : Persistance Objet/Relationnel : création d'un enregistrement en base
            Integer userId = (Integer) session.save(user);
            System.out.println("Clé primaire :" + userId);

            // 5 : Fermeture transaction 
            tx.commit();

            // 6 : Fermeture unité de travail hibernate 
            session.close();

    }
}
