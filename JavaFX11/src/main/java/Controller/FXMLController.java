package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLController {

    @FXML
    private Button log;

    @FXML
    private Button csomagAdatokLekerese;
    
    @FXML
    private Button karbantartas;
     
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
}
