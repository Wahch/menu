/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Wahch
 */
public class Vehicules {
    private int id , idModele , kilometrage ; 
    private String matricule , couleur ;

    public Vehicules() {
    }

    public Vehicules(int id, int idModele, int kilometrage, String matricule, String couleur) {
        this.id = id;
        this.idModele = idModele;
        this.kilometrage = kilometrage;
        this.matricule = matricule;
        this.couleur = couleur;
    }

    public Vehicules(int idModele, int kilometrage, String matricule, String couleur) {
        this.idModele = idModele;
        this.kilometrage = kilometrage;
        this.matricule = matricule;
        this.couleur = couleur;
    }

    public int getId() {
        return id;
    }

    public int getIdModele() {
        return idModele;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Vehicules{" + "id=" + id + ", idModele=" + idModele + ", kilometrage=" + kilometrage + ", matricule=" + matricule + ", couleur=" + couleur + '}';
    }
    
}
