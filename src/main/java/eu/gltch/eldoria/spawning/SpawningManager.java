package eu.gltch.eldoria;

import eu.gltch.eldoria.events.GameEvent;
import eu.gltch.eldoria.events.GameEventManager;
import eu.gltch.eldoria.objects.Enemy;
import eu.gltch.eldoria.objects.enemies.Goblin;
import javafx.geometry.Point2D;

public class SpawningManager {
    private enum {

    }
    private GameEventManager eventManager;
    private double gameTime;
    private double difficultyLevel;
    private double lastSpawnTime;
    private double spawnInterval;


    public SpawningManager() {
        this.difficultyLevel = 1;
        this.lastSpawnTime = 0;
        this.spawnInterval = 5;
        this.eventManager = GameEventManager.getInstance();
    }
    public void update(double currentTime){
        this.gameTime = currentTime;
        if (shouldSpawn()){
            spawnEnemy();

            lastSpawnTime = gameTime;
        }
    }

    private void spawnEnemy() {
        System.out.println("gametime je:" + gameTime);
        Enemy goblin = new Goblin(new Point2D(0,0),2,15);
        GameEvent spawnEvent = new GameEvent(GameEvent.EventType.SPAWN, goblin);
        eventManager.publish(spawnEvent);
    }

    private boolean shouldSpawn() {
        return gameTime - lastSpawnTime >= spawnInterval;
    }
}
