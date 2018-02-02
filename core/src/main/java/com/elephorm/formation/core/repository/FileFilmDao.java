/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.repository;

import com.elephorm.formation.core.entity.Film;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author JLM
 */
public class FileFilmDao {
    // Permet de sauvegarder des films : Une ligne par film propriétés séparées par des ';'
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
    
}
