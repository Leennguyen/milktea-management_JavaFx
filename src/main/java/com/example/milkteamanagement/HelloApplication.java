package com.example.milkteamanagement;

import data.DBConnection;
import data.models.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DBConnection db = new DBConnection();
        db.getProducts();
//        db.insertProduct(new Product("Matcha đá xay", 24000, "kikiki"));
//        db.updateProduct(new Product( 3,"Matcha đá xay không bỏ đá",25000,"kakaka"));
        db.deleteProduct(2);
    }

    public static void main(String[] args) {
        launch();
    }
}