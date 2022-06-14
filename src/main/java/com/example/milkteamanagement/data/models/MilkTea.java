package com.example.milkteamanagement.data.models;

public class MilkTea {
    public int id;
    public String name;
    public float price;
    public String img;
    public int quantity;
    public String ingredients;

    public MilkTea(int id, String name, float price, String img, int quantity, String ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.quantity = quantity;
        this.ingredients = ingredients;
    }

    public MilkTea(String name, float price, String img, int quantity, String ingredients) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.quantity = quantity;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getIngredients() {
        return ingredients;
    }
}
