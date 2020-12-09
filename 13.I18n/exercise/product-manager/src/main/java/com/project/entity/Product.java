package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="product")
public class Product {
  @Id
    int id_product;
    String name_product;
    @Column(name = "date", columnDefinition = "DATE")
    String date;
    String country;


    public Product() {
    }

    public Product(Integer id_product,String name_product,String date, String country){
        this.id_product=id_product;
        this.name_product=name_product;
        this.date=date;
        this.country=country;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
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
