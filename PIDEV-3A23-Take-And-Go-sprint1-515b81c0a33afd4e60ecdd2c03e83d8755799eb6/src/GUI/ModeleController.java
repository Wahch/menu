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
public class ModeleController implements Initializable {

    @FXML
    private TableColumn<Modeles, Integer> idColumn;
    @FXML
    private TableColumn<Modeles, String> nomColumn;
    @FXML
    private TableColumn<Modeles, Integer> idCategorieColumn;
    @FXML
    private TableColumn<Modeles, String> marqueColumn;
    @FXML
    private TableColumn<Modeles, Integer> puissanceColumn;
    @FXML
    private TableColumn<Modeles, Float> prixColumn;
    @FXML
    private TableColumn<Modeles, Integer> archiveeColumn;
    @FXML
    private TextField nomM;
    @FXML
    private TextField idC;
    @FXML
    private TextField marqueM;
    @FXML
    private TextField puissanceM;
    @FXML
    private TextField prixM;
     ServiceModeles sm = new ServiceModeles() ;
    @FXML
    private TableView<Modeles> modeleView;
int index = -1 ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idCategorieColumn.setCellValueFactory(new PropertyValueFactory<>("idCategorie"));
        marqueColumn.setCellValueFactory(new PropertyValueFactory<>("marque"));
        puissanceColumn.setCellValueFactory(new PropertyValueFactory<>("puissance"));
       prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
       modeleView.setItems(FXCollections.observableArrayList(sm.afficher()));
    }    

//    @FXML
//    private void ajouterModele(ActionEvent event) {
//        Modeles m = new Modeles() ; 
//        m.setMarque(marqueM.getText());
//        m.setNom(nomM.getText());
//        m.setIdCategorie(Integer.parseInt(idC.getText()));
//        m.setPuissance(Integer.parseInt(puissanceM.getText()));
//        m.setPrix(Float.parseFloat(prixM.getText()));
//      
//        sm.add(m); 
//    }
@FXML
private void ajouterModele(ActionEvent event) {
    String marque = marqueM.getText();
    String nom = nomM.getText();
    int idCategorie = 0;
    int puissance = 0;
    float prix = 0.0f;
    
    try {
        idCategorie = Integer.parseInt(idC.getText());
        puissance = Integer.parseInt(puissanceM.getText());
        prix = Float.parseFloat(prixM.getText());
    } catch (NumberFormatException e) {
        // Affiche un message d'erreur si la conversion échoue
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Les champs ID catégorie, puissance et prix doivent contenir des nombres valides.");
        alert.showAndWait();
        return;
    }
   
    if (!isValidString(nom) ||  !isValidString(marque) ) {
        // Affiche un message d'erreur pour les chaînes de caractères invalides
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("LeS champs nom et marque  doit contenir uniquement des lettres.");
        alert.showAndWait();
        return;
    }
    
    Modeles m = new Modeles();
    m.setMarque(marque);
    m.setNom(nom);
    m.setIdCategorie(idCategorie);
    m.setPuissance(puissance);
    m.setPrix(prix);
    sm.add(m);
    aff( );
    
    // Affiche un message d'information pour indiquer que l'ajout a réussi
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajout réussi");
    alert.setHeaderText(null);
    alert.setContentText("Le modèle a été ajouté avec succès.");
    alert.showAndWait();
}

    @FXML
    private void modifierModele(ActionEvent event) {
        String marque = marqueM.getText();
    String nom = nomM.getText();
    int idCategorie = 0;
    int puissance = 0;
    float prix = 0.0f;
    
    try {
        idCategorie = Integer.parseInt(idC.getText());
        puissance = Integer.parseInt(puissanceM.getText());
        prix = Float.parseFloat(prixM.getText());
    } catch (NumberFormatException e) {
        // Affiche un message d'erreur si la conversion échoue
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Les champs ID catégorie, puissance et prix doivent contenir des nombres valides.");
        alert.showAndWait();
        return;
    }
   
    if (!isValidString(nom) ||  !isValidString(marque) ) {
        // Affiche un message d'erreur pour les chaînes de caractères invalides
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("LeS champs nom et marque  doit contenir uniquement des lettres.");
        alert.showAndWait();
        return;
    }
    
    Modeles m = new Modeles();
    m.setMarque(marque);
    m.setNom(nom);
    m.setIdCategorie(idCategorie);
    m.setPuissance(puissance);
    m.setPrix(prix);
    sm.modifier(m);
    aff( );
    
    // Affiche un message d'information pour indiquer que l'ajout a réussi
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajout réussi");
    alert.setHeaderText(null);
    alert.setContentText("Le modèle a été modifiée avec succès.");
    alert.showAndWait();
    }
     public void aff( )
    {
       idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idCategorieColumn.setCellValueFactory(new PropertyValueFactory<>("idCategorie"));
        marqueColumn.setCellValueFactory(new PropertyValueFactory<>("marque"));
        puissanceColumn.setCellValueFactory(new PropertyValueFactory<>("puissance"));
       prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
      
       modeleView.setItems(FXCollections.observableArrayList(sm.afficher()));
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
    private void selectModele(MouseEvent event) {
        index = modeleView.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
         nomM.setText((nomColumn.getCellData(index).toString()));
        idC.setText((idCategorieColumn.getCellData(index).toString()));
        puissanceM.setText(puissanceColumn.getCellData(index).toString());
        prixM.setText(prixColumn.getCellData(index).toString());
        marqueM.setText((marqueColumn.getCellData(index).toString()));
        
    }

    @FXML
    private void supprimerModele(ActionEvent event) {
        String marque = marqueM.getText();
    String nom = nomM.getText();
    int idCategorie = 0;
    int puissance = 0;
    float prix = 0.0f;
    Modeles m = new Modeles();
    m.setMarque(marque);
    m.setNom(nom);
    m.setIdCategorie(idCategorie);
    m.setPuissance(puissance);
    m.setPrix(prix);
    sm.supprimer(m,true);
    aff( );
    
    // Affiche un message d'information pour indiquer que l'ajout a réussi
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajout réussi");
    alert.setHeaderText(null);
    alert.setContentText("Le modèle a été supprimée avec succès.");
    alert.showAndWait();
    }


    
}
