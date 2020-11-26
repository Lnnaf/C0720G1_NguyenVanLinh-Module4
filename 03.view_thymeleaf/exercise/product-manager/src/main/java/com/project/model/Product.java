package com.project.model;

public class Product {
    int id;
    String name,date,country;

    public Product() {
    }

    public Product(int id, String name, String date, String country) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
