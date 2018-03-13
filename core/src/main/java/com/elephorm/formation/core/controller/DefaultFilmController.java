/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.controller;

import com.elephorm.formation.core.entity.Acteur;
import com.elephorm.formation.core.entity.Film;
import com.elephorm.formation.core.service.FilmServiceInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author JLM
 */
@Controller(value = "filmController")
public class DefaultFilmController {
    @Autowired
    private FilmServiceInterface service;
    
    public void setService(FilmServiceInterface service) {
        this.service = service;
    }
    
    public void createFilmFromInputConsole(){
        Film film = new Film();
        Scanner sc = new Scanner(System.in);
        System.out.println("************* Ajout d'un Film ************** ");
        System.out.println("Donner un titre : ");
        film.setTitre(sc.next());
        System.out.println("Donner un genre : ");
        film.setGenre(sc.next());
        System.out.println("Donner le nombre d'exemplaire : ");
        film.setNbExemple(Integer.parseInt(sc.next()));
        
        // Ajout d'un acteur principal :
        System.out.println("************* Ajout d'un Acteur Princiapl ************** ");
        Acteur acteurPrincipal = new Acteur();
        System.out.println("Donner un nom : ");
        acteurPrincipal.setNom(sc.next());
        System.out.println("Donner un prénom : ");
        acteurPrincipal.setPrenom(sc.next());
        
        film.setActeurPrincipal(acteurPrincipal);
        
                // Ajout d'un acteur principal :
        System.out.println("************* Ajout des Acteurs Secondaire ************** ");
        List<Acteur> acteurSecondaires = new ArrayList<>();
               
        System.out.println("Donner le nombre d'acteur secondaires : ");
        int nbr = Integer.parseInt(sc.next());
        for(int i = 0; i< nbr; i++){
            Acteur acteurSecondaire = new Acteur();
            System.out.println("Donner un nom : ");
            acteurSecondaire.setNom(sc.next());
            System.out.println("Donner un prénom : ");
            acteurSecondaire.setPrenom(sc.next());  
            acteurSecondaires.add(acteurSecondaire);
        }
       film.setActeurSecondaire(new HashSet<>(acteurSecondaires));
        
        // Appel du service
        // FilmService service = new FilmService(); Instanciation avec Spring
        service.registerFilm(film);
    }
    
    public void getDescriptifFilmFromInputConsole(){
        int id;
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner un Numéro de Film : ");
        id = Integer.parseInt(sc.next());
        
        Film film =  service.getId(id);    
        
        System.out.println("Le film est : " + film.toString());
        System.out.println("Son Acteur Secondaire : " + film.getActeurPrincipal().toString());
        film.getActeurSecondaire().forEach((acteur) -> {
            System.out.println(acteur.toString());
        });
        System.out.println("Son Acteur Pricipal : " + film.getActeurPrincipal().toString());

    }

    public void getListeFilm() {
        List<Film>  films = service.findAll();
        films.forEach((film) -> {
            System.out.println(film.toString());
        });
    }

    
}
