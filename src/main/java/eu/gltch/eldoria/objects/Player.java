package eu.gltch.eldoria.objects;

import eu.gltch.eldoria.events.GameEvent;
import eu.gltch.eldoria.events.GameEventManager;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player {
    private GameEventManager eventManager;
    private ImageView sprite;
    private Point2D position;
    private double speed;
    private double frames;
    public Player(GameEventManager eventManager, Point2D position, double speed){
        this.eventManager = eventManager;
        Image image = new Image("/eu/gltch/Eldoria/player.png");
        this.sprite = new ImageView(image);
        this.position = position;
        this.speed = speed;
        this.sprite.setX(this.position.getX());
        this.sprite.setY(this.position.getY());
    }

    public void update(Set<KeyCode> activeKeys, Point2D mousePosition) {
        if (activeKeys.contains(KeyCode.W)) {
            moveUp();
        }
        if (activeKeys.contains(KeyCode.A)) {
            moveLeft();
        }
        if (activeKeys.contains(KeyCode.S)) {
            moveDown();
        }
        if (activeKeys.contains(KeyCode.D)) {
            moveRight();
        }
        frames++;
        if (frames == 30){
            frames = 0;
            shoot(mousePosition);
        }
    }

    public void shoot(Point2D mousePosition){
        Point2D direction = mousePosition.subtract(position).normalize(); //calculating direction of shot
        Projectile projectile = new Projectile(5,10, this.position, direction);
        GameEvent shootEvent = new GameEvent(GameEvent.EventType.SHOOT, projectile);
        eventManager.publish(shootEvent);
    }

    public void moveUp() {
        position = position.subtract(0, speed);
        sprite.setY(position.getY());
    }

    public void moveDown() {
        position = position.add(0, speed);
        sprite.setY(position.getY());
    }

    public void moveLeft() {
        position = position.subtract(speed, 0);
        sprite.setX(position.getX());
    }

    public void moveRight() {
        position = position.add(speed, 0);
        sprite.setX(position.getX());
    }

    public ImageView getSprite() {
    return sprite;
    }

}
