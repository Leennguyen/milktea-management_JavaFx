package com.example.milkteamanagement.data.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//tạo một đối tượng để lưu trữ thông tin trong mảng
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
    public ImageView getImageView() {
        try {
            var imgView = new ImageView(new Image(this.img));
            imgView.setFitHeight(100);
            imgView.setFitWidth(100);
            return imgView;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public int getQuantity() {
        return quantity;
    }

    public String getIngredients() {
        return ingredients;
    }
}
