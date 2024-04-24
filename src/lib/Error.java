package lib;

import java.util.Arrays;
import java.util.Scanner;

class NumberException extends Exception {
    public NumberException(String msg) {
        super(msg);
    }
}

class RelationException extends Exception {
    public RelationException(String msg) {
        super(msg);
    }
}

public class Error {
    private String tempNum;
    private String tempClass;
    private Scanner scan;

    public String NumberException(String tempNum, Scanner scan) {
        this.tempNum = tempNum;
        this.scan = scan;
        while (true) {
            try {
                System.out.print("전화번호(ex: 01012345678) : ");
                tempNum = scan.nextLine();
                if (tempNum.matches("\\d+") == false) {
                    throw new NumberException("숫자만 입력하세요!");
                }
                break;
            } catch (NumberException e) {
                System.out.println(e.getMessage());
            }
        }
        return tempNum;
    }

    public String RelationException(String tempClass, Scanner scan) {
        this.tempClass = tempClass;
        this.scan = scan;
        while (true) {
            try {
                System.out.print("관계(ex. 가족, 친구, 회사, 기타) : ");
                tempClass = scan.nextLine();
                if (!Arrays.asList("가족", "친구", "회사", "기타").contains(tempClass)) {
                    throw new RelationException("가족, 친구, 회사, 기타 중 하나를 입력하세요!");
                }
                break;
            } catch (RelationException e) {
                System.out.println(e.getMessage());
            }
        }
        return tempClass;
    }
}