package com.example.library_checkout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    HelloController myController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        myController = fxmlLoader.getController();

        stage.setTitle("Library Checkout");
        stage.setScene(scene);
        stage.show();
    }

    public void stop ()throws Exception{
        myController.saveData();
    }

    public static void main(String[] args) {
        launch();
    }
}