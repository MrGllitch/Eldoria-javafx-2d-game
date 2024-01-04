package eu.gltch.eldoria;

import eu.gltch.eldoria.controllers.GameController;
import eu.gltch.eldoria.events.GameEvent;
import eu.gltch.eldoria.events.GameEventManager;
import eu.gltch.eldoria.objects.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {


    Parent root = FXMLLoader.load(getClass().getResource("/eu/gltch/Eldoria/MainScene.fxml"));
    primaryStage.setScene(new Scene(root, 960, 540));
    primaryStage.show();


    }

}
