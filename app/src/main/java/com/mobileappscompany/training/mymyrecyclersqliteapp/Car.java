package com.mobileappscompany.training.mymyrecyclersqliteapp;

/**
 * Created by User on 2/9/2017.
 */

public class Car {

    private int id;
    private String name;
    private String dealer;
    private String photo;

    public Car() {
    }

    public Car(int id, String name, String dealer, String photo) {
        this.id = id;
        this.name = name;
        this.dealer = dealer;
        this.photo = photo;
    }

    public Car(String name, String dealer, String photo) {
        this.name = name;
        this.dealer = dealer;
        this.photo = photo;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }
}
