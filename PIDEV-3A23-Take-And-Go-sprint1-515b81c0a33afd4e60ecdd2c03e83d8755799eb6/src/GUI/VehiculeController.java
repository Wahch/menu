/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Vehicules;
import Services.ServiceVehicules;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Wahch
 */
public class VehiculeController implements Initializable {
ServiceVehicules sv = new ServiceVehicules();
    @FXML
    private TableView<Vehicules> vehiculeView;
    @FXML
    private TableColumn<Vehicules, Integer> idColumn;
    @FXML
    private TableColumn<Vehicules, String> matriculeColumn;
    @FXML
    private TableColumn<Vehicules, String> couleurColumn;
    @FXML
    private TableColumn<Vehicules, Integer> kilometrageColumn;
    @FXML
    private TableColumn<Vehicules, Integer> idModeleColumn;
    @FXML
    private TextField couleurV;
    @FXML
    private TextField kilometrageV;
    @FXML
    private TextField idModeleV;
    @FXML
    private TextField matriculeV;
    @FXML
    private TableColumn<Vehicules, Boolean> archiveColumn;
    int index = -1 ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
         matriculeColumn.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        couleurColumn.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        kilometrageColumn.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
       idModeleColumn.setCellValueFactory(new PropertyValueFactory<>("idModele"));
 //    archiveColumn.setCellValueFactory(new PropertyValueFactory<>("archivee"));
       vehiculeView.setItems(FXCollections.observableArrayList(sv.afficher()));
       aff();
    }    

    @FXML
    private void matriculeU(ActionEvent event) {
        
    }

    @FXML
    private void ajouterVehicule(ActionEvent event) {
        String matricule = matriculeV.getText();
    String couleur = couleurV.getText();
    int idModele = 0;
    int kilometrage = 0;
    
    
    try {
        idModele = Integer.parseInt(idModeleV.getText());
        kilometrage = Integer.parseInt(kilometrageV.getText());
        
    } catch (NumberFormatException e) {
        // Affiche un message d'erreur si la conversion échoue
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Les champs ID modele  et kilometrage doivent contenir des nombres valides.");
        alert.showAndWait();
        return;
    }
   
    if (!isValidString(couleur)  ) {
        // Affiche un message d'erreur pour les chaînes de caractères invalides
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("LeS champs nom et marque  doit contenir uniquement des lettres.");
        alert.showAndWait();
        return;
    }
     if (!validateMatricule(matricule)  ) {
        // Affiche un message d'erreur pour les chaînes de caractères invalides
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Le champs matricule  doit etre sur la format ***TUN****.");
        alert.showAndWait();
        return;
    }
        Vehicules v = new Vehicules() ; 
        v.setMatricule(matricule);
        v.setCouleur(couleur);
         v.setKilometrage(kilometrage);
          v.setIdModele(idModele);     
       sv.add(v); 
       aff();
        Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajout réussi");
    alert.setHeaderText(null);
    alert.setContentText("Le modèle a été ajoutée avec succès.");
    alert.showAndWait();
    }

    @FXML
    private void modifierModele(ActionEvent event) {
        
        String matricule = matriculeV.getText();
    String couleur = couleurV.getText();
    int idModele = 0;
    int kilometrage = 0;
    
    
    try {
        idModele = Integer.parseInt(idModeleV.getText());
        kilometrage = Integer.parseInt(kilometrageV.getText());
        
    } catch (NumberFormatException e) {
        // Affiche un message d'erreur si la conversion échoue
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Les champs ID modele  et kilometrage doivent contenir des nombres valides.");
        alert.showAndWait();
        return;
    }
   
    if (!isValidString(couleur)  ) {
        // Affiche un message d'erreur pour les chaînes de caractères invalides
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("LeS champs nom et marque  doit contenir uniquement des lettres.");
        alert.showAndWait();
        return;
    }
     if (!validateMatricule(matricule)  ) {
        // Affiche un message d'erreur pour les chaînes de caractères invalides
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Le champs matricule  doit etre sur la format ***TUN****.");
        alert.showAndWait();
        return;
    }
        Vehicules v = new Vehicules() ; 
        v.setMatricule(matricule);
        v.setCouleur(couleur);
         v.setKilometrage(kilometrage);
          v.setIdModele(idModele);     
       sv.modifier(v); 
       aff();
        Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajout réussi");
    alert.setHeaderText(null);
    alert.setContentText("Le modèle a été modifiée avec succès.");
    alert.showAndWait();
    }
    public void aff()
    {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
         matriculeColumn.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        couleurColumn.setCellValueFactory(new PropertyValueFactory<>("couleur"));
        kilometrageColumn.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
       idModeleColumn.setCellValueFactory(new PropertyValueFactory<>("idModele"));
      
       vehiculeView.setItems(FXCollections.observableArrayList(sv.afficher()));
    }
    
public boolean validateMatricule(String matricule) {
    // Vérifier si la chaîne est vide ou null
    if (matricule == null || matricule.trim().isEmpty()) {
        return false;
    }

    // Vérifier si la chaîne correspond au format de matricule tunisien
    if (!matricule.matches("\\d{3}TUN\\d{4}")) {
        return false;
    }

    

    return true;
}
 private boolean isValidNumber(String value) {
    if (value == null || value.isEmpty()) {
        return false;
    }
    try {
        // Vérifie si la chaîne peut être convertie en nombre entier ou décimal
        Integer.parseInt(value);
        Float.parseFloat(value);
        return true;
    } catch (NumberFormatException ex) {
        return false;
    }
}
private boolean isValidString(String value) {
    if (value == null || value.isEmpty()) {
        return false;
    }
    // Vérifie si la chaîne ne contient que des lettres
    return value.matches("^[a-zA-Z]+$");
}

    @FXML
    private void selectVehicule(MouseEvent event) {
         index = vehiculeView.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
         
        idModeleV.setText((idModeleColumn.getCellData(index).toString()));
        matriculeV.setText(matriculeColumn.getCellData(index).toString());
        couleurV.setText(couleurColumn.getCellData(index).toString());
        kilometrageV.setText((kilometrageColumn.getCellData(index).toString()));
    }

    @FXML
    private void supprimerVehicule(ActionEvent event) {
        String matricule = matriculeV.getText();
    String couleur = couleurV.getText();
    int idModele = 0;
    int kilometrage = 0;
    Vehicules v = new Vehicules() ; 
        v.setMatricule(matricule);
        v.setCouleur(couleur);
         v.setKilometrage(kilometrage);
          v.setIdModele(idModele);     
       sv.supprimer(v,true); 
       aff();
        Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajout réussi");
    alert.setHeaderText(null);
    alert.setContentText("Le modèle a été supprimée avec succès.");
    alert.showAndWait();
    }

    
}
