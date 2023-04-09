/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Trunks
 */
public class MenuController implements Initializable {

    private boolean gestionOpened = false;

    @FXML
    private AnchorPane exitHamburgerPane, hamburgerPane;

    @FXML
    private Label hamburgerOpen;

    @FXML
    private ImageView exit;

    @FXML
    private VBox mainPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        exitHamburgerPane.setVisible(false);

        // cacher les boutons
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), exitHamburgerPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), hamburgerPane);
        translateTransition.setByX(-600);
        translateTransition.play();

        hamburgerOpen.setOnMouseClicked(event -> {
            exitHamburgerPane.setVisible(true);
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), exitHamburgerPane);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();
            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.2), hamburgerPane);
            translateTransition1.setByX(+600);
            translateTransition1.play();
        });

        exitHamburgerPane.setOnMouseClicked(event -> {

            closeHamburger();
        });
    }

    private void closeHamburger() {
        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.2), exitHamburgerPane);
        fadeTransition1.setFromValue(0.15);
        fadeTransition1.setToValue(0);
        fadeTransition1.play();

        fadeTransition1.setOnFinished(event1 -> {
            exitHamburgerPane.setVisible(false);
        });

        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), hamburgerPane);
        translateTransition1.setByX(-600);
        translateTransition1.play();
    }

    @FXML
    private void openGestionUsers(ActionEvent event) throws IOException {
        closeHamburger();
        mainPane.getChildren().clear();
        Parent Content = FXMLLoader.load(getClass().getResource("ajoutUser.fxml"));
        mainPane.getChildren().setAll(Content);

    }

    @FXML
    private void openGestionVehicules(ActionEvent event) throws IOException {
        closeHamburger();
        mainPane.getChildren().clear();
        Parent Content = FXMLLoader.load(getClass().getResource("Vehicule.fxml"));
        mainPane.getChildren().setAll(Content);
    }

    @FXML
    private void openDashborad(ActionEvent event) throws IOException {
        closeHamburger();
        mainPane.getChildren().clear();
        Parent Content = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        mainPane.getChildren().setAll(Content);
    }

    @FXML
    private void openModele(ActionEvent event) throws IOException  {
        closeHamburger();
        mainPane.getChildren().clear();
        Parent Content = FXMLLoader.load(getClass().getResource("Modele.fxml"));
        mainPane.getChildren().setAll(Content);
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

    @FXML
    private void openCategories(ActionEvent event) throws IOException {
        closeHamburger();
        mainPane.getChildren().clear();
        Parent Content = FXMLLoader.load(getClass().getResource("Categorie.fxml"));
        mainPane.getChildren().setAll(Content);
    }

    @FXML
    private void vehiculeopenn(ActionEvent event) throws IOException {
         closeHamburger();
        mainPane.getChildren().clear();
        Parent Content = FXMLLoader.load(getClass().getResource("Vehicule.fxml"));
        mainPane.getChildren().setAll(Content);
    }
    

}