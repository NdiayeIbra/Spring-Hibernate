/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.repository.jdbc;

import com.elephorm.formation.core.entity.Film;
import com.elephorm.formation.core.repository.FilmDaoInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JLM
 */
@Repository
public class JdbcFilmDao implements FilmDaoInterface{
    // Instancié avec Spring
    String driverClassName;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    
    @Override
    public void save(Film film) {
        // Information d'accès à la base de données
        String url = "jdbc:mysql://localhost:3306/videos";
        String login = "root";
        String passwd = "fawzeyeni";
        Connection cn = null;
        //java.sql.Statement st = null;

        try {
            // Etape 1 : Chargement du driver
            Class.forName(driverClassName);
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

    @Override
    public Film getId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Film> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
