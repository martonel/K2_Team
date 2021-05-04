package Controller;

import static Model.Database.delete;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static Model.Database.intoTheTXT;
import static Model.Database.randomNumIsIn;
import static Model.Database.textFromtheTXT;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class FXMLController {

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
    private Button log;

    @FXML
    private Button csomagAdatokLekerese;

    @FXML
    private Button bezar;

    @FXML
    private Button kuldes;
    
    @FXML
    private Text csomagAzonosito;
    
    @FXML
    private ChoiceBox<String> Statusz;
    
    @FXML
    private Button karbantartas;
    
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
    private Text errorMess2;
    
    @FXML
    private Text packageStatus;
        
    
    public void asd() {
        Statusz.getItems().removeAll(Statusz.getItems());
        Statusz.getItems().addAll("Option A", "Option B", "Option C");
        Statusz.getSelectionModel().select("Option B");
    }
    
    @FXML
    void login(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/fooldal.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Csomag feladása");
            stage.setScene(new Scene(parent));
            stage.show();
            
            
            //stage.setOnCloseRequest(e -> handleExit(false, e));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    
    
    @FXML
    void csomagokKarbantartasa(ActionEvent event) {       

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/csomag_karbantartasa.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("A csomagok karbantartása!");

            stage.setScene(new Scene(parent));
            stage.show();
            
            asd();
            //stage.setOnCloseRequest(e -> handleExit(false, e));
        } catch (IOException e) {
            System.out.println(e);
        }
        
        
    }

    @FXML
    void csomagAdatok(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/csomagadatok.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Csomag adatai");
            stage.setScene(new Scene(parent));
            stage.show();
            
            
            //stage.setOnCloseRequest(e -> handleExit(false, e));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) bezar.getScene().getWindow();
        stage.close();
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
    
    @FXML
    void deleteButton(ActionEvent event) {
        String azon = azonGetter.getText();
        boolean del = delete(azon);
        if(del){
            errorMess2.setText("A törlés sikeres volt!");
            errorMess2.setVisible(true);
        }
        else{
            errorMess2.setText("A törlés sikertelen volt!");
            errorMess2.setVisible(true);
        }
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
            packageStatus.setText("A csomag státusza");
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
    
    //státuszok: rendelés feldolgozása, kiszállítás alatt, kézbesítve
    
    @FXML
    void elkuld(ActionEvent event) {
        Stage stage2 = (Stage) kuldes.getScene().getWindow();
        // do what you have to do
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
           
            //String[] sp = datas.split(",");
            csomagAzonosito.setText("");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
            
    
}
