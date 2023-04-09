/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Insets;
import Entities.Modeles;
import GUI.ItemController;
import Services.ServiceModeles;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Wahch
 */
public class FrontVehiculeController implements Initializable {

    @FXML
    private VBox choixVehicule;
    @FXML
    private HBox VehiculePrice;
    @FXML
    private ImageView VehiculeIMG;
    @FXML
    private TableView<Modeles> vehiculeViewF;
    @FXML
    private TableColumn<Modeles,String> marqueColumn;
    @FXML
    private TableColumn<Modeles,String> nomColumn;
    @FXML
    private TableColumn<Modeles,Integer> puissanceColumn;
    @FXML
    private TableColumn<Modeles,Float> prixColumn;
     ServiceModeles sm = new ServiceModeles() ;
    @FXML
    private ScrollPane scrool;
    @FXML
    private GridPane grid;
    
    List<Modeles> modeles = new ArrayList();
    Modeles e = new Modeles();
    @FXML
    private TextField searchBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
      
        marqueColumn.setCellValueFactory(new PropertyValueFactory<>("marque"));
        puissanceColumn.setCellValueFactory(new PropertyValueFactory<>("puissance"));
       prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
       vehiculeViewF.setItems(FXCollections.observableArrayList(sm.afficher()));
       searchModele();
// TODO
//        modeles = sm.afficher();
//        int col=0;
//        int row=0;
//        try {
//        for(int i=0; i<sm.afficher().size(); i++){
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(getClass().getResource("/GUI/Item.fxml"));
//            AnchorPane anchorPane =fxmlLoader.load();
//            
//            ItemController itemController = fxmlLoader.getController();
//            itemController.setData(modeles.get(i));
//            
//            if (col == 3){
//                col=0;
//                row++;
//            }
//            
//            grid.add(anchorPane, col++, row);
//            
//            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
//            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
//            grid.setMaxWidth(Region.USE_PREF_SIZE);
//            
//            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
//            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
//            grid.setMaxHeight(Region.USE_PREF_SIZE);
//            
////            grid.setMargin(anchorPane, Insets(10));
//        }
//            } catch (IOException ex) {
//                Logger.getLogger(FrontVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }    

    @FXML
    private void chercher(ActionEvent event) {
    }
        private void searchModele() {
         FilteredList<Modeles> filteredData = new FilteredList<>(FXCollections.observableArrayList(sm.afficher()),b->true);
         searchBox.textProperty().addListener((observable,oldValue,newValue)-> {
             filteredData.setPredicate(rec-> {
                 if (newValue == null || newValue.isEmpty()){
                     return true;
                 }
                 String lowerCaseFilter = newValue.toLowerCase();
                 if (rec.getNom().toLowerCase().indexOf(lowerCaseFilter)!= -1){
                 return true;
                 }
                 
                 else if (rec.getMarque().toLowerCase().indexOf(lowerCaseFilter)!= -1){
                 return true;
                 }
                 
                 else
                 return false ;
                 
             });
         });
         SortedList<Modeles> sortedData = new SortedList<>(filteredData);
         sortedData.comparatorProperty().bind(vehiculeViewF.comparatorProperty());
         vehiculeViewF.setItems(sortedData); 
    }
    
}
