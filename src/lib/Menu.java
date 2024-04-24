package lib;

import java.util.Scanner;

public class Menu {
    private String dummy;
    private String tempName;
    private Scanner scan;

    public void thisIs(String dummy, String tempName, Scanner scan) {
        this.dummy = dummy;
        this.scan = scan;
        this.tempName = tempName;
    }

    public void Main() {
        System.out.println("\n**********************************");
        System.out.println("   다음 메뉴 중 하나를 선택하세요");
        System.out.println("**********************************");
        System.out.println("\n1. 회원추가\n2. 회원 목록보기\n3. 회원 정보 수정하기\n4. 회원 삭제\n5. 종료");
    }

    public String Edit(String dummy, Scanner scan, String tempName) {
        thisIs(dummy, tempName, scan);
        System.out.print("수정할 회원 이름을 입력하세요 : ");
        try {
            tempName = scan.nextLine();
        } catch (NullPointerException e) {
            System.out.println("없는 회원입니다!");
        }
        
        return tempName;
    }

    public String Delete(String dummy, Scanner scan, String tempName) {
        thisIs(dummy, tempName, scan);

        dummy = scan.nextLine();
        System.out.print("삭제할 연락처 이름을 입력하세요 : ");
        tempName = scan.nextLine();

        return tempName;
    }
}