package lib;

import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIO {
    Contacts contacts = new Contacts(null, null, null, null);
    public HashMap<String, Contacts> hashMap;

    public void fileOut(HashMap<String, Contacts> hashMap) {
        this.hashMap=hashMap;
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hashmapDB.txt"));
            oos.writeObject(hashMap);
            oos.close();
        } catch (IOException e){
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    public HashMap<String,Contacts> fileIn(HashMap<String, Contacts> hashMap){
        this.hashMap=hashMap;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hashMapDB.txt"));
            hashMap = (HashMap<String, Contacts>)ois.readObject();
        } catch(IOException e){
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, e);
        } catch(ClassNotFoundException e){
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, e);
        }
        return hashMap;
    }
}
