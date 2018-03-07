package com.chriscorp.epay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent checkoutRoot = FXMLLoader.load(getClass().getResource("/checkoutpage1.fxml"));
        primaryStage.setTitle("Checkout page");
        primaryStage.setScene(new Scene(checkoutRoot));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
