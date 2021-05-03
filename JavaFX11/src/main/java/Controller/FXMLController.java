package Controller;

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
    private Label CsomagAzonosito;
    
    @FXML
    private ChoiceBox<String> Statusz;
    
    @FXML
    private Button karbantartas;
    
    Random rand = new Random();
    
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
            //a textFromtheTXT eljáráshívás csak tesztként van benne, 
            //majd ha lesz hely ahová meg lehet jeleníteni innen ki lehet majd venni
            textFromtheTXT();
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
            //a textFromtheTXT eljáráshívás csak tesztként van benne, 
            //majd ha lesz hely ahová meg lehet jeleníteni innen ki lehet majd venni
            textFromtheTXT();
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
            //a textFromtheTXT eljáráshívás csak tesztként van benne, 
            //majd ha lesz hely ahová meg lehet jeleníteni innen ki lehet majd venni
            textFromtheTXT();
            //stage.setOnCloseRequest(e -> handleExit(false, e));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void backButton(ActionEvent event) {
        Stage stage = (Stage) bezar.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void handleGetPackageData(ActionEvent event) {

    }

    public String getDatas() {
        StringBuilder sb = new StringBuilder();
        if (nameText.getText().isEmpty()) {
            sb.append("unknown");
        } else {
            sb.append(nameText.getText());
        }

        sb.append(",");
        if (addressText.getText().isEmpty()) {
            sb.append("unknown");
        } else {
            sb.append(addressText.getText());
        }

        sb.append(",");
        if (billingAddressText.getText().isEmpty()) {
            sb.append("unknown");
        } else {
            sb.append(billingAddressText.getText());
        }

        sb.append(",");
        if (phonNumText.getText().isEmpty()) {
            sb.append("unknown");
        } else {
            sb.append(phonNumText.getText());
        }

        sb.append(",");
        if (commentText.getText().isEmpty()) {
            sb.append("unknown");
        } else {
            sb.append(commentText.getText());
        }

        return sb.toString();
    }
    
    
    @FXML
    void elkuld(ActionEvent event) {
        Stage stage2 = (Stage) kuldes.getScene().getWindow();
        // do what you have to do
        stage2.close();
        
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/csomagazon.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Csomag adatai");
            stage.setScene(new Scene(parent));
            stage.show();
            //a textFromtheTXT eljáráshívás csak tesztként van benne, 
            //majd ha lesz hely ahová meg lehet jeleníteni innen ki lehet majd venni
            textFromtheTXT();
            //stage.setOnCloseRequest(e -> handleExit(false, e));
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(CsomagAzonosito.getText());
    }
    
}
