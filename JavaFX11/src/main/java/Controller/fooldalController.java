/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Model.Database.intoTheTXT;
import static Model.Database.randomNumIsIn;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class fooldalController {
    
    @FXML
    private TextField nameText;

    @FXML
    private TextField addressText;

    @FXML
    private TextField billingAddressText;

    @FXML
    private TextField phonNumText;

    @FXML
    private TextField commentText;

    @FXML
    private Button kuldes;

    @FXML
    void elkuld(ActionEvent event) {
        Stage stage2 = (Stage) kuldes.getScene().getWindow();
        String datas = getDatas();
        try {
            intoTheTXT(datas);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage2.close();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/csomagazon.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Csomag adatai");
            stage.setScene(new Scene(parent));
            stage.show();
           
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public String getDatas() {
        StringBuilder sb = new StringBuilder();

        boolean bool = true;
        int i = 0;
        while(bool){
            int max = 60000;
            int min = 1;
            int diff = max - min;
            Random rn = new Random();
            i = rn.nextInt(diff + 1);
            i += min;
            bool = randomNumIsIn(i);
        }
        
        sb.append(i);
        sb.append(",");
        if (nameText.getText().isEmpty() || nameText.getText().isEmpty()) {
            sb.append("unknown");
        } else {
            sb.append(nameText.getText());
        }

        sb.append(",");
        if (addressText.getText().isEmpty() || addressText.getText().isEmpty()) {
            sb.append("unknown");
        } else {
            sb.append(addressText.getText());
        }

        sb.append(",");
        if (billingAddressText.getText().isEmpty() || billingAddressText.getText().isEmpty()) {
            sb.append("unknown");
        } else {
            sb.append(billingAddressText.getText());
        }

        sb.append(",");
        if (phonNumText.getText().isEmpty() || phonNumText.getText().isEmpty()) {
            sb.append("unknown");
        } else {
            sb.append(phonNumText.getText());
        }

        sb.append(",");
        if (commentText.getText().isEmpty() || commentText.getText().isEmpty()) {
            sb.append("Nincs");
        } else {
            sb.append(commentText.getText());
        }
        sb.append(",Rendelés feldolgozás alatt");

        return sb.toString();
    }
    
}
