/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.logging.Logger;

/**
 *
 * @author Wahch
 */
public class Categories {
 private int id ;
 private String nom  , description , utilisationRecommendee ; 

    public Categories() {
    }

    public Categories(int id, String nom, String description, String utilisationRecommendee) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.utilisationRecommendee = utilisationRecommendee;
    }

    public Categories(String description, String utilisationRecommendee) {
        this.description = description;
        this.utilisationRecommendee = utilisationRecommendee;
    }

    public Categories(String nom, String description, String utilisationRecommendee) {
        this.nom = nom;
        this.description = description;
        this.utilisationRecommendee = utilisationRecommendee;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getUtilisationRecommendee() {
        return utilisationRecommendee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUtilisationRecommendee(String utilisationRecommendee) {
        this.utilisationRecommendee = utilisationRecommendee;
    }

    @Override
    public String toString() {
        return "Categories{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", utilisationRecommendee=" + utilisationRecommendee + '}';
    }
   
}
