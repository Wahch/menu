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
public class Modeles {
  private  int id , idCategorie , puissance	 ;
  private   String nom  , marque ; 
  private float prix ; 

    public Modeles() {
    }

    public Modeles(int id, int idCategorie, int puissance, String nom, String marque, float prix) {
        this.id = id;
        this.idCategorie = idCategorie;
        this.puissance = puissance;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
    }

    public Modeles(int idCategorie, int puissance, String nom, String marque, float prix) {
        this.idCategorie = idCategorie;
        this.puissance = puissance;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public int getPuissance() {
        return puissance;
    }

    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public float getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Modeles{" + "id=" + id + ", idCategorie=" + idCategorie + ", puissance=" + puissance + ", nom=" + nom + ", marque=" + marque + ", prix=" + prix + '}';
    }

    public String getImgSrc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
