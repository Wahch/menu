/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Categories;
import Utils.TagoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Wahch
 */
public class ServiceCategories  implements IService<Categories>{
     Connection cnx;
    Statement stm;
    public ServiceCategories( ) {
        cnx = TagoDB.getInstance().getCnx();
    }
    @Override
    public void add(Categories t) {
    try {
               String qry = "INSERT INTO `categories`( `nom`, `description`, `utilisationRecommendee`) VALUES ('" + t.getNom()+ "','" + t.getDescription()+ "','" + t.getUtilisationRecommendee()+"') " ;
    stm = cnx.createStatement();
    stm.executeUpdate(qry);
    
     } catch (SQLException ex) {
        System.out.println(ex.getMessage());
     }
    }

    @Override
    public List<Categories> afficher() {
        List<Categories> categories = new ArrayList<>();
    String sql = "SELECT * FROM categories WHERE `archivee` = false ";
    try
    {
         Statement statement = cnx.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Categories c = new Categories();
            c.setId(rs.getInt("id"));
            c.setNom(rs.getString("nom"));
            c.setDescription(rs.getString("description"));
            c.setUtilisationRecommendee(rs.getString("utilisationRecommendee"));
            
            categories.add(c) ; 
        }
        statement.close();
    }
    catch(SQLException ex )
    {
        System.out.println("Error: " + ex.getMessage());
    }
    
     return categories;
    }

    @Override
    public Boolean modifier(Categories t ) {
   try {
       
    //   String qry = "UPDATE `categories` SET `nom`='" + t.getNom() + "', `description`='" + t.getDescription()+ "', `utilisationRecommendee`='" + t.getUtilisationRecommendee()+ "' WHERE `id`=' " + t.getId() + "' " ;
   String qry = "UPDATE `categories` SET `description`='" + t.getDescription()+ "', `utilisationRecommendee`='" + t.getUtilisationRecommendee()+ "' WHERE `nom`='" + t.getNom() + "'";

        Statement stm = cnx.createStatement();
        int rowsUpdated = stm.executeUpdate(qry);
        return (rowsUpdated > 0);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
    }

    @Override
    public Boolean supprimer(Categories t , boolean  archivee ) {
    try {
        String qry;
        if (archivee) {
            qry = "UPDATE `Categories` SET `archivee` = true WHERE `nom`='" + t.getNom() + "'";
        } else {
            qry = "DELETE FROM `Categories` WHERE `id` = " + t.getId();
        }
        stm = cnx.createStatement();
        stm.executeUpdate(qry);
        return true;
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
    }
    public void chercher(String name) {
    try {
        String qry = "SELECT * FROM `categories` WHERE `nom` LIKE '%" + name + "%'";
        stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(qry);
        while(rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String description = rs.getString("description");
            String utilisation = rs.getString("utilisationRecommendee");
            System.out.println("ID : " + id + ", Nom : " + nom + ", Description : " + description + ", Utilisation recommandée : " + utilisation);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
    
}