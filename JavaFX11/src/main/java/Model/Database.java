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
    private String name;
    private String addr;
    private String billAddr;
    private String phoneN;
    private String comm;
    private String status;

    public lstHelper(String name, String addr, String billAddr, String phoneN, String comm, String status) {
        this.name = name;
        this.addr = addr;
        this.billAddr = billAddr;
        this.phoneN = phoneN;
        this.comm = comm;
        this.status = status;
        
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return name + "," + addr + "," + billAddr + "," + phoneN + "," + comm + "," + status;
    }
    
}

public class Database {
    
    public static File FileOpening(){
        return new File("D:\\Suli\\SFM\\K2_Team6\\JavaFX11\\src\\main\\java\\Model\\database.txt");
    }
    
    FXMLController fxmlcont = new FXMLController();
    
    
    public static void intoTheTXT(String datas) throws FileNotFoundException{
        PrintWriter pw = null;

        try {
           File file = FileOpening();
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
    
    public static boolean randomNumIsIn(int randomNum){
        File op = FileOpening();
        try {
            Scanner sc = new Scanner(op, "UTF-8");
            String[] sp;
            while(sc.hasNextLine()){
                sp = sc.nextLine().split(",");
                int randomNumTest = Integer.parseInt(sp[0]);
                if(randomNumTest == randomNum){
                    sc.close();
                    return true;
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean delete(String azon){
        File op = FileOpening();
        ArrayList<String> lst = new ArrayList<>();
        boolean del = true;
        int counter = 0;
        try {
            Scanner sc = new Scanner(op, "UTF-8");
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                if(!s.contains(azon)){
                    lst.add(s);
                }
                counter++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        File file = FileOpening();
        PrintWriter pw;
        try {
            //FileWriter fw = new FileWriter(file, Charset.forName("utf-8"), true);
            pw = new PrintWriter(file, Charset.forName("utf-8"));
            for(int i = 0; i < lst.size(); i++){
                    pw.println(lst.get(i));
            }
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(counter == lst.size())
            del = false;
        else
            del = true;
        return del;
    }
    public static void modify(String azon, String status){
        File op = FileOpening();
        ArrayList<String> lst = new ArrayList<>();
        boolean del = true;
        //int counter = 0;
        try {
            Scanner sc = new Scanner(op, "UTF-8");
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                if(!s.contains(azon)){
                    lst.add(s);
                }
                else{
                    String[] tmp = s.split(",");
                    tmp[6] = status;
                    s = tmp[0] + "," + tmp[1] + "," + tmp[2] + "," + tmp[3] + "," + tmp[4] + "," + tmp[5] + "," + tmp[6];
                    lst.add(s);
                }
                //counter++;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        File file = FileOpening();
        PrintWriter pw;
        try {
            //FileWriter fw = new FileWriter(file, Charset.forName("utf-8"), true);
            pw = new PrintWriter(file, Charset.forName("utf-8"));
            for(int i = 0; i < lst.size(); i++){
                    pw.println(lst.get(i));
            }
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*if(counter == lst.size())
            del = false;
        else
            del = true;
        
        /*if(counter == lst.size())
            del = false;
        else
            del = true;
        return del;*/
    }
    
    public static String textFromtheTXT(String azon){
        File op = FileOpening();
        HashMap<String, ArrayList<lstHelper>> mp = new HashMap<>();
        
        String back = "";
        try {
            Scanner sc = new Scanner(op, "UTF-8");
            String[] sp;
            while(sc.hasNextLine()){
                ArrayList<lstHelper> lst = new ArrayList<>();
                sp = sc.nextLine().split(",");
                lst.add(new lstHelper(sp[1], sp[2], sp[3], sp[4], sp[5], sp[6]));
                if(!mp.containsKey(sp[0])){
                    mp.put(sp[0], lst);
                }
                else{
                    mp.get(sp[0]).add(new lstHelper(sp[1], sp[2], sp[3], sp[4], sp[5], sp[6]));
                }
                
            }
            
            for(var item : mp.entrySet()){
                if(azon.equals(item.getKey())){
                    back = item.getKey() + ",";
                    for(var it : item.getValue()){
                        back = back.concat(it.toString());
                    }
                }
            }
            
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(back.isBlank() || back.isEmpty()){
            back = "error";
        }
        return back;
    }
}
