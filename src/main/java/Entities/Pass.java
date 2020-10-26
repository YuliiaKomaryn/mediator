package Entities;

import javax.persistence.Id;


import java.util.UUID;


public class Pass {

    @Id

    private String pass_id;

    String type;

    int price;


    public Pass(String type,

                int price) {

        this.type = type;

        this.price = price;

        this.pass_id = UUID.randomUUID().toString();

    }


    public Pass() {
    }


    public String getPass_id() {
        return pass_id;
    }


    public String getType() {
        return type;
    }


    public int getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPass_id(String pass_id) {
        this.pass_id = pass_id;
    }
}

