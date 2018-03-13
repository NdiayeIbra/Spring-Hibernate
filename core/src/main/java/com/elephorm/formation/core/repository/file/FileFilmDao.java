/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.repository.file;

import com.elephorm.formation.core.entity.Film;
import com.elephorm.formation.core.repository.FilmDaoInterface;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author JLM
 */
public class FileFilmDao implements FilmDaoInterface {
    // Permet de sauvegarder des films : Une ligne par film propriétés séparées par des ';'
    @Override
    public void save(Film film){
        FileWriter fw;
        try {
            fw = new FileWriter("C:\\JavaDev\\Docs\\film.txt", true);
            fw.write(String.format("Titre : %s.", film.getTitre()));
            fw.write(System.lineSeparator()); //new line
            fw.write(String.format("Genre : %s.", film.getGenre()));
            fw.write(System.lineSeparator()); //new line
            fw.write(String.format("Nbr Exemples : %d", film.getNbExemple()));
            fw.write(System.lineSeparator());

//          fw.write(String.format("I am %d years old.",age));
//          fw.write(System.lineSeparator()); //new line
//          fw.write(String.format("Today's temperature is %.2f.",temp));
//          fw.write(System.lineSeparator()); //new line

            fw.close();
        } catch (IOException ex) {
            // TODO
        }

        System.out.println("Done");
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
