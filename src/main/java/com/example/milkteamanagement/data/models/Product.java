package com.example.milkteamanagement.data.models;

public class Product {
    public int id;
    public String name;
    public float price;
    public String img;

    public Product() {
    }

    public Product(int id, String name, float price, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public Product(String name, float price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }
}
