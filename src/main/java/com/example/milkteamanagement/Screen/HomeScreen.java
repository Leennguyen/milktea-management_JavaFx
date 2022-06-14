package com.example.milkteamanagement.Screen;

import com.example.milkteamanagement.data.DBConnection;
import com.example.milkteamanagement.data.models.MilkTea;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreen {
    public Scene scene;
    private Stage stage;
    private final DBConnection db = new DBConnection();
    public HomeScreen(Stage stage) {
        this.stage = stage;
        render();
    }
    private void render() {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        Button btnCreate = new Button("Create new Milk Tea");
        btnCreate.setOnAction(e -> new CreateOrUpdateMilkTeaScreen(stage));
        root.add(btnCreate, 0,0);
        TableView<MilkTea> table = new TableView<>();
        table.setMinSize(800, 400);
        TableColumn<MilkTea, Integer> idCol = new TableColumn<>("ID");
        TableColumn<MilkTea, String> nameCol = new TableColumn<>("Name");
        TableColumn<MilkTea, Float> priceCol = new TableColumn<>("Price");
        TableColumn<MilkTea, String> imgCol = new TableColumn<>("Image");
        TableColumn<MilkTea, Integer> quantityCol = new TableColumn<>("Quantity");
        TableColumn<MilkTea, String> ingredientsCol = new TableColumn<>("Description");
        TableColumn<MilkTea, Void> deleteCol = new TableColumn<>("Action");
        deleteCol.setCellFactory(column -> new TableCell<>() {
            private final Button btnDel = new Button("Delete");
            private final Button btnUpdate = new Button("Update");
            private final VBox vBox = new VBox(btnDel, btnUpdate);
            {
                btnDel.setOnAction(e -> {
                    MilkTea milkTea = getTableView().getItems().get(getIndex());
                    db.deleteMilkTea(milkTea.id);
                });
                btnUpdate.setOnAction(e -> {
                    MilkTea milkTea = getTableView().getItems().get(getIndex());
                    stage.setScene(new CreateOrUpdateMilkTeaScreen(stage, milkTea).scene);
                });
            }
            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(vBox);
                }
            }
        });
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        imgCol.setCellValueFactory(new PropertyValueFactory<>("img"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ingredientsCol.setCellValueFactory(new PropertyValueFactory<>("ingredients"));

        table.getColumns().addAll(idCol, nameCol, priceCol, imgCol, quantityCol, ingredientsCol, deleteCol);
        table.setItems(FXCollections.observableList(db.getMilkTeas()));


        root.add(table, 1, 0);
        scene = new Scene(root, 1200, 600);
        show();
    }
    private void show() {
        stage.setScene(scene);
        stage.show();
    }
}
