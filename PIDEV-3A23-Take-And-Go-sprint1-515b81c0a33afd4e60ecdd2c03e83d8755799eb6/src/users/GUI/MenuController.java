/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Wahch
 */
public class MenuController implements Initializable {

    @FXML
    private Label hamburgerOpen;
    @FXML
    private ImageView exit;
    @FXML
    private AnchorPane exitHamburgerPane;
    @FXML
    private VBox mainPane;
    @FXML
    private AnchorPane hamburgerPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openDashborad(ActionEvent event) {
    }

    @FXML
    private void openGestionUsers(ActionEvent event) {
    }

    @FXML
    private void openGestionVehicules(ActionEvent event) {
    }

    @FXML
    private void openDashborad(MouseEvent event) {
    }

    @FXML
    private void openGestionUsers(KeyEvent event) {
    }

    @FXML
    private void openGestionVehicules(KeyEvent event) {
    }
    
}
