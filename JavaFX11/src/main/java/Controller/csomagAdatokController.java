/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Model.Database.delete;
import static Model.Database.textFromtheTXT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class csomagAdatokController {
    
    
    @FXML
    private TextField azonGetter;

    @FXML
    private Text packageStatus;

    @FXML
    private Text packageAddr;

    @FXML
    private Text packageBillingAddr;

    @FXML
    private Text packagePhone;

    @FXML
    private Text packageName;

    @FXML
    private Text packageComm;

    @FXML
    private Button bezar;

    @FXML
    private Text errorMess2;

    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) bezar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void deleteButton(ActionEvent event) {
        if(!(azonGetter.getText().isBlank() || azonGetter.getText().isEmpty())){
            String azon = azonGetter.getText();
            boolean del = delete(azon);
            if(del){
                errorMess2.setText("A törlés sikeres volt!");
                errorMess2.setVisible(true);
                packageName.setText("Címzett neve");
                packageAddr.setText("Címzett címe");
                packageBillingAddr.setText("Szállítási cím");
                packagePhone.setText("Telefonszám");
                packageComm.setText("Megjegyzés");
                packageStatus.setText("A csomag státusza");
            }
            else{
                errorMess2.setText("A törlés sikertelen volt!");
                errorMess2.setVisible(true);
            }
        }
    }

    @FXML
    void handleGetPackageData(ActionEvent event) {
        String azon = azonGetter.getText();
        
        String back = textFromtheTXT(azon);
        
        if(back.equals("error")){
            errorMess2.setText("Nincs ilyen azonosító!");
            errorMess2.setVisible(true);
            packageName.setText("Címzett neve");
            packageAddr.setText("Címzett címe");
            packageBillingAddr.setText("Szállítási cím");
            packagePhone.setText("Telefonszám");
            packageComm.setText("Megjegyzés");
            packageStatus.setText("A csomag státusza");
        }
        else{
            errorMess2.setVisible(false);
            String[] sp = back.split(",");
            packageName.setText(sp[1]);
            packageAddr.setText(sp[2]);
            packageBillingAddr.setText(sp[3]);
            packagePhone.setText(sp[4]);
            packageComm.setText(sp[5]);
            packageStatus.setText(sp[6]);
        }
    }

    
}
