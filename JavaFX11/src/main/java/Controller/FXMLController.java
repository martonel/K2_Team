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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    void login(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/fooldal.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Hallgato");
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
    void sendButton(ActionEvent event) {
        String datas = getDatas();
        System.out.println(datas);
        try {
            intoTheTXT(datas);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDatas(){
        StringBuilder sb = new StringBuilder();
        if(nameText.getText().isEmpty()){
            sb.append("unknown");
        }
        else{
            sb.append(nameText.getText());
        }
        
        sb.append(",");
        if(addressText.getText().isEmpty()){
            sb.append("unknown");
        }
        else{
            sb.append(addressText.getText());
        }
        
        sb.append(",");
        if(billingAddressText.getText().isEmpty()){
            sb.append("unknown");
        }
        else{
            sb.append(billingAddressText.getText());
        }
        
        sb.append(",");
        if(phonNumText.getText().isEmpty()){
            sb.append("unknown");
        }
        else{
            sb.append(phonNumText.getText());
        }
        
        sb.append(",");
        if(commentText.getText().isEmpty()){
            sb.append("unknown");
        }
        else{
            sb.append(commentText.getText());
        }
        
        return sb.toString();
    }
    
    
}
