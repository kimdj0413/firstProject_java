package inter;

import java.util.HashMap;
import java.util.Scanner;

import lib.Contacts;

/**
 * editInterface
 */
public interface editInterface {
    void inputData(Scanner scan, HashMap<String, Contacts> hashMap, String keyTemp);
    void editData();
    void Remove(HashMap<String, Contacts> hashMap, String keyTemp);
    void Select(HashMap<String, Contacts> hashMap);
}