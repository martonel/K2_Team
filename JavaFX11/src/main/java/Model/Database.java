/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.FXMLController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;


/**
 *
 * @author Dani
 */
public class Database {
    FXMLController fxmlcont = new FXMLController();
    
    public static void intoTheTXT(String datas) throws FileNotFoundException{
        PrintWriter pw = null;

        try {
           File file = new File("C:\\Users\\kolom\\Downloads\\K2K2\\JavaFX11\\src\\main\\java\\Model\\database.txt");
           FileWriter fw = new FileWriter(file, Charset.forName("utf-8"), true);
           pw = new PrintWriter(fw);
           pw.println(datas);
        } catch (IOException e) {
        } finally {
           if (pw != null) {
              pw.close();
           }
        }
    }
    
    
}
