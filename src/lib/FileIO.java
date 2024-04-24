package lib;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import lib.Info;

public class FileIO {
    Info info = new Info(null, null, null, null);
    public HashMap<String, Info> hashMap;

    public void fileOut(HashMap<String, Info> hashMap) {
        this.hashMap=hashMap;
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hashmapDB.txt"));
            oos.writeObject(hashMap);
            oos.close();
        } catch (IOException e){
            Logger.getLogger(Info.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    public HashMap<String,Info> fileIn(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hashMapDB.txt"));
            hashMap = (HashMap<String, Info>)ois.readObject();
        } catch(IOException e){
            Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, e);
        } catch(ClassNotFoundException e){
            Logger.getLogger(Info.class.getName()).log(Level.SEVERE, null, e);
        }
        return hashMap;
    }
}
