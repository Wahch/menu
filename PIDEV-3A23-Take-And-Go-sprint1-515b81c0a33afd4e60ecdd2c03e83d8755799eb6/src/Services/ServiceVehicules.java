/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Modeles;
import Entities.Vehicules;
import Utils.TagoDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wahch
 */
public class ServiceVehicules implements IService<Vehicules> {

     Connection cnx;
    Statement stm;
    public ServiceVehicules( ) {
        cnx = TagoDB.getInstance().getCnx();
    }
    @Override
    public void add(Vehicules t) {
     try {
               String qry = " INSERT INTO `vehicules`( `matricule`, `couleur`, `kilometrage`,  `idModele`) VALUES ('"+t.getMatricule()+"','"+t.getCouleur()+"','"+t.getKilometrage()+"','"+t.getIdModele()+"')" ;
    stm = cnx.createStatement();
    stm.executeUpdate(qry);
    
     } catch (SQLException ex) {
        System.out.println(ex.getMessage());
     }
    }

    @Override
    public List<Vehicules> afficher() {
    List<Vehicules> vehicules = new ArrayList<>();
    String sql = "SELECT * FROM vehicules WHERE `archivee` = false ";
    try
    {
         Statement statement = cnx.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Vehicules v = new Vehicules();
            v.setId(rs.getInt("id"));
            v.setMatricule(rs.getString("matricule"));
            v.setCouleur(rs.getString("couleur"));
             v.setKilometrage(rs.getInt("kilometrage"));
             v.setIdModele(rs.getInt("idModele"));
             
            
            vehicules.add(v) ; 
        }
        statement.close();
    }
    catch(SQLException ex )
    {
        System.out.println("Error: " + ex.getMessage());
    }
    
     return vehicules;
    }

    @Override
    public Boolean modifier(Vehicules t) {
     try { 
         //  String qry = "UPDATE `vehicules` SET `idModele`='"+t.getIdModele()+"',`couleur`='"+t.getCouleur()+"',`kilometrage`='"+t.getKilometrage()+"' WHERE `matricule`= '"+t.getMatricule()+"'" ;
     String qry = " UPDATE `vehicules` SET `couleur`= '"+t.getCouleur()+"'  , `kilometrage` ='"+t.getKilometrage()+"' , `idModele`= '"+t.getIdModele()+"' WHERE `matricule` = '"+t.getMatricule()+"' ";
         Statement stm = cnx.createStatement();
        int rowsUpdated = stm.executeUpdate(qry);
        return (rowsUpdated > 0);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
    }

    @Override
    public Boolean supprimer(Vehicules t, boolean archivee) {
   try {
        String qry = "DELETE FROM `vehicules` where `matricule`= '"+t.getMatricule()+"'";
        stm = cnx.createStatement();
        stm.executeUpdate(qry);
        return true;
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
    }
    public void chercher(String name) 
    {
        
    }    
}