/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Wahch
 */
public class TagoDB {
     final String URL ="jdbc:mysql://127.0.0.1:3306/tago";
final String USER ="root";
final String PWD ="";
private  Connection cnx;
 private  static TagoDB instance;
 private TagoDB() {
        try {
        cnx = DriverManager.getConnection(URL, USER, PWD);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());   
    }
    }

    public static TagoDB getInstance() {
        if(instance == null){
        instance = new TagoDB();
    }
    return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
