package com.example.milkteamanagement;

import com.example.milkteamanagement.Screen.HomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApplication extends Application {
    @Override
    public void start(Stage stage){
        new HomeScreen(stage);
    }
    public static void main(String[] args) {
        launch();
    }
}