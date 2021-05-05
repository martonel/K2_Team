/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class csomagAzonController {
    
    @FXML
    private Text csomagAzonosito;

    @FXML
    private Text csomagStatusz;

    @FXML
    private void initialize(){
        csomagAzonosito.setText(azon());
        csomagStatusz.setText("Rendelés feldolgozás alatt");
    }

    public static String azon(){
        File op = new File("C:\\Users\\kolom\\Downloads\\K2K2\\JavaFX11\\src\\main\\java\\Model\\database.txt");
        ArrayList<String> lst = new ArrayList<>();
        String az = "";
        try {
            Scanner sc = new Scanner(op, "UTF-8");
            while(sc.hasNextLine()){
                    String s = sc.nextLine();
                    lst.add(s);
            }
            sc.close();
            String[] tmp = lst.get(lst.size() - 1).split(",");
            az = tmp[0];
        } catch (FileNotFoundException ex) {
            Logger.getLogger(csomagAzonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return az;
    }
}
