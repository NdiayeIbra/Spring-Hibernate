/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.repository;

import com.elephorm.formation.core.entity.Film;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JLM
 */
public class JdbcFilmDao {
    public void save(Film film) {
        // Information d'accès à la base de données
        String url = "jdbc:mysql://localhost:3306/videos";
        String login = "root";
        String passwd = "fawzeyni";
        Connection cn = null;
        //java.sql.Statement st = null;

        try {
            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            // Etape 2 : récupération de la connexion
            cn = DriverManager.getConnection(url, login, passwd);
            System.out.println("CONNEXION OK");
            
            // Etape 3 : Création d'un statement
            //st = cn.createStatement();
            String sql = "INSERT INTO movie (TITLE,MOVIE_TYPE,COPIES) VALUES (?, ?, ?)";

            PreparedStatement statement = cn.prepareStatement(sql);
            
            // Générate Key Automatic
            // PreparedStatement statement = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, film.getTitre());
            statement.setString(2, film.getGenre());
            statement.setInt(3, film.getNbExemple());
            
            // Etape 4 : exécution requête
            statement.executeUpdate();

            // Si récup données alors étapes 5 (parcours Resultset)

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // TODO: handle exception
         finally {
            try {
            // Etape 6 : libérer ressources de la mémoire.
                    cn.close();
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
    }

}
