/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Modeles;
import Services.ServiceModeles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Wahch
 */
public class ItemController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label prixLabel;
    @FXML
    private ImageView img;
    ServiceModeles se = new ServiceModeles();
 Modeles m = new Modeles();
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
     public void setData(Modeles m){
        this.m = m;        
        prixLabel.setText(m.getNom());
        
    }
}
