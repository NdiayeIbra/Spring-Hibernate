/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elephorm.formation.core.entity;

import java.util.Set;

/**
 *
 * @author JLM
 */
public class Film {
    private Integer id;
    private String titre;
    private String genre;
    private Integer nbExemple;
    private Acteur acteurPrincipal;
    // Relation Many-to-one : plusieurs films peuvent référencer le meme acteur
    // Unidirecrtionnelle : l'acteur n'est pas obligé de connaitre son Film

    private Set<Acteur> acteurSecondaire;

    public Set<Acteur> getActeurSecondaire() {
        return acteurSecondaire;
    }

    public void setActeurSecondaire(Set<Acteur> acteurSecondaire) {
        this.acteurSecondaire = acteurSecondaire;
    }
    
    public Acteur getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(Acteur acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNbExemple(Integer nbExemple) {
        this.nbExemple = nbExemple;
    }

    public Integer getNbExemple() {
        return nbExemple;
    }

    @Override
    public String toString() {
        return "Film [ " + " Titre = " + titre + ", Genre = " + genre + ", nbExemple = " + nbExemple + ']';
    }
    
    
}
