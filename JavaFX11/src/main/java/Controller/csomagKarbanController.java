/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Model.Database.modify;
import static Model.Database.textFromtheTXT;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class csomagKarbanController {
    @FXML
    private TextField azonGetter;
    
     @FXML
    private Text packageName;
     
    @FXML
    private Text packageAddr;

    @FXML
    private Text packageBillingAddr;

    @FXML
    private Text packagePhone;

    @FXML
    private Text packageComm;
    
    @FXML
    private Text errorMess;
    
    @FXML
    private ChoiceBox Statusz;
    
    
    @FXML
    private Button bezar;
    
    @FXML
    private void initialize(){
        asd();
    }
    
    ObservableList<String> lst = FXCollections.observableArrayList("valami", "valami2");
    public void asd() {
        lst.removeAll(lst);
        String a = "Rendelés feldolgozás alatt";
        String b = "Kiszállítás alatt";
        String c = "Kézbesítve";
        lst.addAll(a, b, c);
        Statusz.getItems().clear();
        Statusz.getItems().addAll(lst);
    }
    
    @FXML
    void packageMaintenance(ActionEvent event) {
        String azon = azonGetter.getText();
        String back = textFromtheTXT(azon);
        
        if(back.equals("error")){
            errorMess.setVisible(true);
            packageName.setText("Címzett neve");
            packageAddr.setText("Címzett címe");
            packageBillingAddr.setText("Szállítási cím");
            packagePhone.setText("Telefonszám");
            packageComm.setText("Megjegyzés");
        }
        else{
            errorMess.setVisible(false);
            String[] sp = back.split(",");
            packageName.setText(sp[1]);
            packageAddr.setText(sp[2]);
            packageBillingAddr.setText(sp[3]);
            packagePhone.setText(sp[4]);
            packageComm.setText(sp[5]);
        }
    }
    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) bezar.getScene().getWindow();
        stage.close();
    }
    @FXML
    void packageModify(ActionEvent event) {
        if(!(azonGetter.getText().isBlank() || azonGetter.getText().isEmpty())){
            String azon = azonGetter.getText();
            String status = (String) Statusz.getValue();
            modify(azon, status);
        }
    }   
}
