/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Categories;
import Entities.Modeles;
import Utils.TagoDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wahch
 */
public class ServiceModeles implements IService<Modeles> {

    Connection cnx;
    Statement stm;
    public ServiceModeles( ) {
        cnx = TagoDB.getInstance().getCnx();
    }
    @Override
    public void add(Modeles t) {
       try {
               String qry = "INSERT INTO `modeles`( `nom`, `idCategorie`, `marque`, `puissance`, `prix`) VALUES ('"+t.getNom()+"','"+t.getIdCategorie()+"','"+t.getMarque()+"','"+t.getPuissance()+"','"+t.getPrix()+"')" ;
    stm = cnx.createStatement();
    stm.executeUpdate(qry);
    
     } catch (SQLException ex) {
        System.out.println(ex.getMessage());
     }
    }

    @Override
    public List<Modeles> afficher() {
     List<Modeles> modeles = new ArrayList<>();
    String sql = "SELECT * FROM modeles WHERE `archivee` = false ";
    try
    {
         Statement statement = cnx.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Modeles m = new Modeles();
            m.setId(rs.getInt("id"));
            m.setNom(rs.getString("nom"));
            m.setIdCategorie(rs.getInt("idCategorie"));
            m.setMarque(rs.getString("marque"));
             m.setPuissance(rs.getInt("puissance"));
             m.setPrix(rs.getFloat("prix"));
            
            modeles.add(m) ; 
        }
        statement.close();
    }
    catch(SQLException ex )
    {
        System.out.println("Error: " + ex.getMessage());
    }
    
     return modeles; }

    @Override
    public Boolean modifier(Modeles t) {
       try { 
           //    String qry = "UPDATE `modeles` SET `nom`='"+t.getNom()+"',`idCategorie`='"+t.getIdCategorie()+"',`marque`='"+t.getMarque()+"',`puissance`='"+t.getPuissance()+"',`prix`='"+t.getPrix()+"' WHERE `id`='"+t.getId()+"'" ;
      String qry = "UPDATE `modeles` SET `nom`='"+t.getNom()+"',`idCategorie`='"+t.getIdCategorie()+"',`puissance`='"+t.getPuissance()+"',`prix`='"+t.getPrix()+"' WHERE `marque`='"+t.getMarque()+"'" ;
       
      Statement stm = cnx.createStatement();
        int rowsUpdated = stm.executeUpdate(qry);
        return (rowsUpdated > 0);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
    }

    @Override
    public Boolean supprimer(Modeles t ,  boolean  archivee) {
      try {
        String qry;
        if (archivee) {
            qry = "UPDATE `Modeles` SET `archivee` = true  WHERE `marque`='"+t.getMarque()+"'" ;
        } else {
            qry = "DELETE FROM `Modeles` WHERE `id` = " + t.getId();
        }
        stm = cnx.createStatement();
        stm.executeUpdate(qry);
        return true;
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return false;
    } }
    
    public void chercher(String name) {
    try {
        String qry = "SELECT * FROM `modeles` WHERE `nom` LIKE '%" + name + "%'";
        stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(qry);
        while(rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            int idCategorie = rs.getInt("idCategorie");
            String marque = rs.getString("marque");
            int puissance = rs.getInt("puissance");
            double prix = rs.getDouble("prix");
            System.out.println("ID : " + id + ", Nom : " + nom + ", ID catégorie : " + idCategorie + ", Marque : " + marque + ", Puissance : " + puissance + ", Prix : " + prix);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
    public List<Modeles> searchByPriceRange(float minPrice, float maxPrice) {
    List<Modeles> results = new ArrayList<>();
    try {
        String qry = "SELECT * FROM `modeles` WHERE `prix` BETWEEN " + minPrice + " AND " + maxPrice;
        stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(qry);
        while(rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            int idCategorie = rs.getInt("idCategorie");
            String marque = rs.getString("marque");
            int puissance = rs.getInt("puissance");
            float prix = rs.getFloat("prix");
            Modeles modele = new Modeles(id, idCategorie , puissance , nom, marque,  prix);
            results.add(modele);
            
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return results;
}
   

    
}