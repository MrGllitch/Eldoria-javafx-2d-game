package eu.gltch.eldoria.objects;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Projectile {
    private Circle sprite;
    private double damage;
    private double speed;
    private Point2D position;
    private Point2D direction;

    public Projectile(double damage, double speed, Point2D position, Point2D direction) {
        this.damage = damage;
        this.speed = speed;
        this.position = position;
        this.direction = direction;
        this.sprite = new Circle(15,Color.RED);
        this.sprite.setCenterX(position.getX());
        this.sprite.setCenterY(position.getY());
        System.out.println("direction je:" + direction);
    }
    public void update(){
        position = position.add(direction.multiply(speed));
        sprite.setCenterX(position.getX());
        sprite.setCenterY(position.getY());
    }

    public Circle getSprite() {
        return sprite;
    }
}
