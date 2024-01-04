package eu.gltch.eldoria.controllers;

import eu.gltch.eldoria.events.GameEvent;
import eu.gltch.eldoria.events.GameEventListener;
import eu.gltch.eldoria.events.GameEventManager;
import eu.gltch.eldoria.objects.Player;
import eu.gltch.eldoria.objects.Projectile;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.*;

import static eu.gltch.eldoria.events.GameEvent.EventType.SHOOT;

public class GameController implements Initializable, GameEventListener {
    @FXML
    private AnchorPane rootNode;

    private GameEventManager eventManager = GameEventManager.getInstance();

    private Point2D mousePosition;


    private Set<KeyCode> activeKeys = new HashSet<>();

    private List<Projectile> projectiles = new ArrayList<>();

    //private GameLoop gameLoop;
    private AnimationTimer gameLoop;
    private Player player;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            Scene scene = rootNode.getScene();
            setupKeyListeners(scene);
        });

        eventManager.subscribe(this);
        player = new Player(eventManager, new Point2D(100,100),5);
        rootNode.getChildren().add(player.getSprite());



        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                updateGameState();
            }
        };
        gameLoop.start();


    }

    private void updateGameState() {
       player.update(activeKeys, mousePosition);
       for (Projectile projectile : projectiles) {
           projectile.update();}
       //for (Enemy enemy : enemies) {
       //    enemy.update;
       //}
    }

    private void setupKeyListeners(Scene scene) {
    scene.setOnKeyPressed(event -> {
        activeKeys.add(event.getCode());
    });
    scene.setOnKeyReleased(event -> {
        activeKeys.remove(event.getCode());
    });
    scene.setOnMouseMoved(event -> {
        mousePosition = new Point2D(event.getSceneX(),event.getSceneY());
    });
    }

    @Override
    public void handleEvent(GameEvent event) {
        switch (event.getType()){
            case SHOOT:
                createProjectile((Projectile) event.getData());
        }
    }

    private void createProjectile(Projectile projectile) {
        System.out.println("vytvářím projektil v metodě createProjectile");
        projectiles.add(projectile); // add projectile to list of projectiles
        rootNode.getChildren().add(projectile.getSprite()); // showing projectile on map
    }
}
