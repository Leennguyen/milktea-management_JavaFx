package com.example.milkteamanagement;
import com.example.milkteamanagement.data.DBConnection;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DBConnection db = new DBConnection();
//        db.getProducts();
//        db.insertProduct(new Product("Trà sữa khoai môn", 24000, "https://dulichkhampha24.com/wp-content/uploads/2021/04/tra-sua-ong-tho.jpg"));
//        db.updateProduct(new Product( 6,"Trà sữa khoai môn trân châu đen",25000,"https://dulichkhampha24.com/wp-content/uploads/2021/04/tra-sua-ong-tho.jpg"));
//        db.deleteProduct(4);
        db.getProducts();
    }

    public static void main(String[] args) {
        launch();
    }
}