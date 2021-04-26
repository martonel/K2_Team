package hu.unideb.inf;

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

public class FXMLController {

   @FXML
    private TextField nameText;

    @FXML
    private TextField addressText;

    @FXML
    private TextField billingAddressText;

    @FXML
    private TextField phoneNumText;

    @FXML
    private TextField commentText;
    
    
    @FXML
    private Button log;
    @FXML
    void login(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/fooldal.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Hallgato");
            stage.setScene(new Scene(parent));
            stage.show();
            //stage.setOnCloseRequest(e -> handleExit(false, e));
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
    
    public String datas(){
        StringBuilder sb = new StringBuilder();
        sb.append(nameText.getText());
        
        return sb.toString();
        
    }

}

