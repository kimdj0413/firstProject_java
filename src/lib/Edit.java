package lib;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

import inter.editInterface;

public class Edit implements editInterface {
    Contacts contacts = new Contacts(null, null, null, null);
    Error error = new Error();
    Menu menu = new Menu();
    ArrayList<String> list = new ArrayList<>();

    private Scanner scan = new Scanner(System.in);
    private HashMap<String, Contacts> hashMap;

    private String keyTemp;
    private String tempName;
    private String tempNum;
    private String tempRelation;

    public void thisIs(HashMap<String, Contacts> hashMap, String keyTemp, String tempName) {
        this.hashMap = hashMap;
        this.keyTemp = keyTemp;
        this.tempName = tempName;
    }

    public String forEqual(String tempName, String keyTemp, HashMap<String, Contacts> hashMap) {
        thisIs(hashMap, keyTemp, tempName);

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key).getName().equals(tempName)) {
                keyTemp = key;
            }
        }
        return keyTemp;
    }

    @Override
    public void inputData(Scanner scan, HashMap<String, Contacts> hashMap, String keyTemp) {
        thisIs(hashMap, keyTemp, null);
        System.out.println("등록할 회원의 정보를 입력하세요.");
        System.out.print("이름 : ");
        String tempName = scan.nextLine();
        tempNum = error.NumberException(tempNum, scan);
        System.out.print("주소 : ");
        String tempAdd = scan.nextLine();
        tempRelation = error.RelationException(tempRelation, scan);

        contacts = new Contacts(tempName, tempNum, tempAdd, tempRelation);
        hashMap.put(tempNum, contacts);
    }

    @Override
    public void editData() {
        thisIs(hashMap, keyTemp, tempName);
        tempName = menu.Edit(tempNum, scan, tempName);
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key).getName().equals(tempName)) {
                list.add(key);
            }
        }
        System.out.println("총 " + list.size() + "명의 회원이 저장되어 있습니다.");

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ".회원정보 : 이름 = " + hashMap.get(list.get(i)).getName() + ", 전화번호 : "
                    + hashMap.get(list.get(i)).getNumber() + ", 주소 : " + hashMap.get(list.get(i)).getAddress()
                    + ", 관계 : "
                    + hashMap.get(list.get(i)).getRelation());
        }
        System.out.print("수정할 회원 번호를 입력하세요: ");
        int index = scan.nextInt();
        System.out.print("수정할 정보를 입력하세요.\n");
        tempNum = error.NumberException(tempNum, scan);
        System.out.print("주소 : ");
        String tempAdd = scan.nextLine();
        tempRelation = error.RelationException(tempRelation, scan);

        contacts = new Contacts(tempName, tempNum, tempAdd, tempRelation);
        hashMap.put(list.get(index - 1), contacts);
        list.clear();
    }

    @Override
    public void Remove(HashMap<String, Contacts> hashMap, String keyTemp) {
        thisIs(hashMap, keyTemp, null);

        hashMap.remove(keyTemp);
    }

    @Override
    public void Select(HashMap<String, Contacts> hashMap) {
        thisIs(hashMap, null, null);
        for (String key : hashMap.keySet()) {
            System.out.println("회원정보 : 이름 = " + hashMap.get(key).getName() + ", 전화번호 : "
                    + hashMap.get(key).getNumber() + ", 주소 : " + hashMap.get(key).getAddress() + ", 관계 : "
                    + hashMap.get(key).getRelation());
        }
    }

    // public void inputData(Scanner scan, HashMap<String, Contacts> hashMap, String
    // keyTemp) {
    // thisIs(hashMap, keyTemp, null);
    // System.out.println("등록할 회원의 정보를 입력하세요.");
    // System.out.print("이름 : ");
    // String tempName = scan.nextLine();
    // tempNum = error.NumberException(tempNum, scan);
    // System.out.print("주소 : ");
    // String tempAdd = scan.nextLine();
    // tempRelation = error.RelationException(tempRelation, scan);

    // contacts = new Contacts(tempName, tempNum, tempAdd, tempRelation);
    // hashMap.put(tempNum, contacts);
    // }

    // public void editData(){
    // thisIs(hashMap, keyTemp, tempName);
    // tempName = menu.Edit(tempNum, scan, tempName);
    // for(String key : hashMap.keySet()){
    // if(hashMap.get(key).getName().equals(tempName)){
    // list.add(key);
    // }
    // }
    // System.out.println("총 "+list.size()+"명의 회원이 저장되어 있습니다.");

    // for (int i=0;i<list.size();i++) {
    // System.out.println((i+1)+".회원정보 : 이름 = " + hashMap.get(list.get(i)).getName()
    // + ", 전화번호 : "
    // + hashMap.get(list.get(i)).getNumber() + ", 주소 : " +
    // hashMap.get(list.get(i)).getAddress() + ", 관계 : "
    // + hashMap.get(list.get(i)).getRelation());
    // }
    // System.out.print("수정할 회원 번호를 입력하세요: ");
    // int index = scan.nextInt();
    // System.out.print("수정할 정보를 입력하세요.\n");
    // tempNum = error.NumberException(tempNum, scan);
    // System.out.print("주소 : ");
    // String tempAdd = scan.nextLine();
    // tempRelation = error.RelationException(tempRelation, scan);

    // contacts = new Contacts(tempName, tempNum, tempAdd, tempRelation);
    // hashMap.put(list.get(index-1), contacts);
    // list.clear();
    // }

    // public void Remove(HashMap<String, Contacts> hashMap, String keyTemp) {
    // thisIs(hashMap, keyTemp, null);

    // hashMap.remove(keyTemp);
    // }

    // public void Select(HashMap<String, Contacts> hashMap) {
    // thisIs(hashMap, null, null);
    // for (String key : hashMap.keySet()) {
    // System.out.println("회원정보 : 이름 = " + hashMap.get(key).getName() + ", 전화번호 : "
    // + hashMap.get(key).getNumber() + ", 주소 : " + hashMap.get(key).getAddress() +
    // ", 관계 : "
    // + hashMap.get(key).getRelation());
    // }
    // }
}