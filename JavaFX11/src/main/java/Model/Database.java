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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dani
 */

class lstHelper{
    private String addr;
    private String billAddr;
    private String phoneN;
    private String comm;

    public lstHelper(String addr, String billAddr, String phoneN, String comm) {
        this.addr = addr;
        this.billAddr = billAddr;
        this.phoneN = phoneN;
        this.comm = comm;
    }
    
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getBillAddr() {
        return billAddr;
    }

    public void setBillAddr(String billAddr) {
        this.billAddr = billAddr;
    }

    public String getPhoneN() {
        return phoneN;
    }

    public void setPhoneN(String phoneN) {
        this.phoneN = phoneN;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    @Override
    public String toString() {
        return addr + ", " + billAddr + ", " + phoneN + ", " + comm;
    }
    
}

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
    
    public static void textFromtheTXT(){
        File op = new File("C:\\Users\\kolom\\Downloads\\K2K2\\JavaFX11\\src\\main\\java\\Model\\database.txt");
        HashMap<String, ArrayList<lstHelper>> mp = new HashMap<>();
        
        try {
            Scanner sc = new Scanner(op, "UTF-8");
            String[] sp;
            while(sc.hasNextLine()){
                ArrayList<lstHelper> lst = new ArrayList<>();
                sp = sc.nextLine().split(",");
                lst.add(new lstHelper(sp[1], sp[2], sp[3], sp[4]));
                if(!mp.containsKey(sp[0])){
                    mp.put(sp[0], lst);
                }
                else{
                    mp.get(sp[0]).add(new lstHelper(sp[1], sp[2], sp[3], sp[4]));
                }
                
            }
            for(var item : mp.entrySet()){
                System.out.println(item.getKey());
                int i = 1;
                for(var it : item.getValue()){
                    System.out.print("Csomag " + i + ":" + it + "\n");
                    i++;
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
