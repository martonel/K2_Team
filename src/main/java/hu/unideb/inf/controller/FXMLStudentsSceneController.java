/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author kocsisg
 */
public class FXMLStudentsSceneController implements Initializable {

    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }
    
    
    @FXML
    private Label helloLabel;
    

    @FXML
    private Label nameLabel;

    @FXML
    private Label creditsLabel;

    @FXML
    private Label dobLabel;

    @FXML
    void HandleLoadButtonPushed(ActionEvent event) {
        nameLabel.textProperty().bind(model.getStudent().nameProperty());
        creditsLabel.setText(String.valueOf(model.getStudent().getCredits()));
        dobLabel.setText(model.getStudent().getDateOfBirth().toString());
    }
    
    @FXML
    void handleButtonPushed(ActionEvent event) {
        System.out.println("Hello world!!!");
        helloLabel.setText("Button Pushed!");
    }
    
    
    
    @FXML
    void handleChangeButtonPushed(ActionEvent event) {
        model.getStudent().setName("Tom Smith");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
