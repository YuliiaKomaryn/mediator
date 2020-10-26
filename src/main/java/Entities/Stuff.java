package Entities;


import javax.persistence.Id;

import java.util.UUID;

public final class Stuff {

    @Id
    private String stuff_id;

    private String type;

    private int price;

    public Stuff(String type, int price) {

        this.type = type;

        this.price = price;

        this.stuff_id = UUID.randomUUID().toString();
    }

    public Stuff() {
    }

    public String getStuff_id() {

        return stuff_id;
    }

    public String getType() {

        return type;
    }

    public int getPrice() {

        return price;
    }

    public void setStuff_id(String stuff_id) {
        this.stuff_id = stuff_id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

}