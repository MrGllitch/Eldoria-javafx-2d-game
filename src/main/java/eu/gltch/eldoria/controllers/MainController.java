package eu.gltch.eldoria.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public void start(MouseEvent mouseEvent) throws IOException {
    Scene gameScene = new Scene(FXMLLoader.load(getClass().getResource("/eu/gltch/Eldoria/GameScene.fxml")));
    Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

    stage.setScene(gameScene);
    stage.show();
    }
    public void end(MouseEvent mouseEvent) {
    }
}
