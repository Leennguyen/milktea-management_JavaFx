package com.example.milkteamanagement.Screen;

import com.example.milkteamanagement.data.DBConnection;
import com.example.milkteamanagement.data.models.MilkTea;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CreateOrUpdateMilkTeaScreen {
    public Scene scene;
    private final Stage stage;
    private final DBConnection db = new DBConnection();
    public CreateOrUpdateMilkTeaScreen(Stage stage) {
        this.stage = stage;
        render(null);
    }
    public CreateOrUpdateMilkTeaScreen(Stage stage, MilkTea milkTea) {
        this.stage = stage;
        render(milkTea);
    }
    public void render(MilkTea milkTea) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        Label lbName = new Label("Name: ");
        root.add(lbName, 0, 0);
        TextField txtName = new TextField(milkTea != null ? milkTea.name : "");
        root.add(txtName, 1, 0);
        Label lbPrice = new Label("Price: ");
        root.add(lbPrice, 0, 1);
        TextField txtPrice = new TextField(milkTea != null ? String.valueOf(milkTea.price) : "");
        root.add(txtPrice, 1, 1);
        Label lbImg = new Label("Img: ");
        root.add(lbImg, 0, 3);
        TextField txtImg = new TextField(milkTea != null ? milkTea.img : "");
        root.add(txtImg, 1, 3);
        Label lbQuantity = new Label("Quantity: ");
        root.add(lbQuantity, 0, 4);
        TextField txtQuantity = new TextField(milkTea != null ? String.valueOf(milkTea.quantity) : "");
        root.add(txtQuantity, 1, 4);
        Label lbIngredients = new Label("Ingredients: ");
        root.add(lbIngredients, 0, 5);
        TextField txtIngredients = new TextField(milkTea != null ? milkTea.ingredients : "");
        root.add(txtIngredients, 1, 5);

        Button btnBack = new Button("Back");
        btnBack.setOnAction(e -> stage.setScene(new HomeScreen(stage).scene));
        root.add(btnBack, 0, 6);
        Button btnSave = new Button("Save");
        btnSave.setOnAction(e -> {
            if (milkTea == null){
                db.insertMilkTea(
                    new MilkTea(
                        txtName.getText(),
                        Float.parseFloat(txtPrice.getText()),
                        txtImg.getText(),
                        Integer.parseInt(txtQuantity.getText()),
                        txtIngredients.getText()
                    )
                );
            }
            else {
                milkTea.name = txtName.getText();
                milkTea.price = Float.parseFloat(txtPrice.getText());
                milkTea.img = txtImg.getText();
                milkTea.quantity = Integer.parseInt(txtQuantity.getText());
                milkTea.ingredients = txtIngredients.getText();
                db.updateMilkTea(milkTea);
            }
            stage.setScene(new HomeScreen(stage).scene);
        });
        root.add(btnSave, 1, 6);

        scene = new Scene(root, 800, 600);
        show();
    }
    private void show() {
        stage.setScene(scene);
        stage.show();
    }
}
