package eu.gltch.eldoria.objects;

import eu.gltch.eldoria.events.GameEvent;
import eu.gltch.eldoria.events.GameEventManager;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

abstract public class Enemy{
    private double damage;
    private double health;
    private Point2D position;
    private ImageView sprite;
    private double movementSpeed;

    public Enemy(Point2D position, Image image, double movementSpeed, double health) {
        this.position = position;
        this.sprite = new ImageView(image);
        this.movementSpeed = movementSpeed;
        this.sprite.setFitHeight(100);
        this.sprite.setPreserveRatio(true);
        this.health = health;
        this.damage = 1;
    }
    public void update(Point2D playerPosition) {
        moveToPlayer(playerPosition);
    }

    private void moveToPlayer(Point2D playerPosition) {
        Point2D direction = playerPosition.subtract(position).normalize();
        position = position.add(direction.multiply(movementSpeed));
        sprite.setY(position.getY());
        sprite.setX(position.getX());
    }

    public Node getSprite() {
        return sprite;
    }
    public Bounds getBounds(){
        return sprite.getBoundsInParent();
    }

    public void takeDamage(double damage) {
        health -= damage;

    }

    public boolean isDead() {
        if (health <= 0){
            return true;
        }
        return false;
    }

    public double getDamage() {
        return damage;
    }
}
