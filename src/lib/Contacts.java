package lib;

import java.io.Serializable;

public class Contacts implements Serializable{
    private String name;
    private String number;
    private String address;
    private String relation;

    public Contacts (String name, String number, String address, String relation) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.relation = relation;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getRelation() {
        return relation;
    }

    public String setName(String name) {
        this.name = name;

        return name;
    }

    public String setNumber(String number) {
        this.number = number;

        return number;
    }

    public String setAddress(String address) {
        this.address = address;

        return address;
    }

    public String setRelation(String relation) {
        this.relation = relation;

        return relation;
    }
}
