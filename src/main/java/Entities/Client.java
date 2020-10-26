package Entities;

import javax.persistence.Id;

import java.util.UUID;


public class Client {
    @Id
    private String client_id;
    private String name;
    private String surname;
    private double temperature;

    public Client(String name,
                  String surname,
                  double temperature) {
        this.name = name;
        this.surname = surname;
        this.temperature = temperature;
        this.client_id = UUID.randomUUID().toString();
    }

    public Client() {

    }

    public String getClient_id() {
        return client_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
