package main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import lib.Edit;
import lib.Menu;
import lib.Contacts;
import lib.FileIO;

public class Phonebook {
    public static void main(String[] args) throws Exception {
        Edit edit = new Edit();
        Menu menu = new Menu();
        FileIO fileIo = new FileIO();
        Scanner scan = new Scanner(System.in);

        String keyTemp = "";
        int menuNum = 0;
        String dummy = "";
        String tempName = "";
        boolean go = true;

        HashMap<String, Contacts> hashMap = new HashMap<String, Contacts>();

        hashMap = fileIo.fileIn(hashMap);
        while (go) {
            try {
                menu.Main();
                menuNum = scan.nextInt();
            } catch (InputMismatchException e) {
                scan.nextLine();
            }

            switch (menuNum) {
                case 1:                
                    dummy = scan.nextLine();
                    edit.inputData(scan, hashMap, keyTemp);
                    continue;
                case 2:
                    edit.Select(hashMap);
                    continue;
                case 3:
                    edit.editData();
                    continue;
                case 4:
                    tempName = menu.Delete(dummy, scan, tempName);
                    keyTemp = edit.forEqual(tempName, keyTemp, hashMap);
                    edit.Remove(hashMap, keyTemp);
                    continue;
                case 5:
                    go = false;
            }
        }
        fileIo.fileOut(hashMap);
    }
}