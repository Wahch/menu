/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Categories;
import Services.ServiceCategories;
import java.net.URL;
import java.time.Duration;
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
public class CategorieController implements Initializable {

    @FXML
    private TableView<Categories> categorieView;
    @FXML
    private TableColumn<Categories, Integer> idColumn;
    @FXML
    private TableColumn<Categories, String> nomColumn;
    @FXML
    private TableColumn<Categories, String> descriptionColumn;
    @FXML
    private TextField nomC;
    @FXML
    private TextField descriptionC;
    @FXML
    private TextField utilisationC;
    @FXML
    private TableColumn<Categories, String> utilisationColumn;
     ServiceCategories sc = new ServiceCategories();
     int index = -1 ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        utilisationColumn.setCellValueFactory(new PropertyValueFactory<>("utilisationRecommendee"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
      
        categorieView.setItems(FXCollections.observableArrayList(sc.afficher()));
        aff();

    }    





    @FXML
private void ajouterCategorie(ActionEvent event) {
    String nom = nomC.getText();
    String description = descriptionC.getText();
    String utilisation = utilisationC.getText();
    if (!isValidString(nom) || !isValidString(description) || !isValidString(utilisation)) {
        // Affiche un message d'erreur pour les chaînes de caractères invalides
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Les champs nom , description et utilisation doivent contenir uniquement des lettres.");
        alert.showAndWait();
        return;
    }
    
    Categories c = new Categories();
    c.setNom(nom);
    c.setDescription(description);
    c.setUtilisationRecommendee(utilisation);
    sc.add(c);
    aff();
    
    // Affiche un message d'information pour indiquer que l'ajout a réussi
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajout réussi");
    alert.setHeaderText(null);
    alert.setContentText("La catégorie a été ajoutée avec succès.");
    alert.showAndWait();
}


    @FXML
    private void updateCategories(ActionEvent event) {
        
   
      String nom = nomC.getText();
    String description = descriptionC.getText();
    String utilisation = utilisationC.getText();
     
    if (!isValidString(nom) || !isValidString(description) || !isValidString(utilisation)) {
        // Affiche un message d'erreur pour les chaînes de caractères invalides
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Les champs nom , description et utilisation doivent contenir uniquement des lettres.");
        alert.showAndWait();
        return;
    }
    
    Categories c = new Categories();
    c.setNom(nom);
    c.setDescription(description);
    c.setUtilisationRecommendee(utilisation);
    sc.modifier(c);
    aff();
    
    // Affiche un message d'information pour indiquer que l'ajout a réussi
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajout réussi");
    alert.setHeaderText(null);
    alert.setContentText("La catégorie a été modifiee avec succès.");
    alert.showAndWait();
    }
    public void aff( )
    {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        utilisationColumn.setCellValueFactory(new PropertyValueFactory<>("utilisationRecommendee"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
      
        categorieView.setItems(FXCollections.observableArrayList(sc.afficher()));
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
    private void selectCategorie(MouseEvent event) {
        index = categorieView.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        nomC.setText((nomColumn.getCellData(index).toString()));
        utilisationC.setText((utilisationColumn.getCellData(index).toString()));
        descriptionC.setText((descriptionColumn.getCellData(index).toString()));
    }

    @FXML
    private void supprimerCatg(ActionEvent event) {
        String nom = nomC.getText();
    String description = descriptionC.getText();
    String utilisation = utilisationC.getText();
        Categories c = new Categories();
    c.setNom(nom);
    c.setDescription(description);
    c.setUtilisationRecommendee(utilisation);
    sc.supprimer(c,true);
    aff();
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajout réussi");
    alert.setHeaderText(null);
    alert.setContentText("Le modèle a été supprimée avec succès.");
    alert.showAndWait();
    }

   
    
}
