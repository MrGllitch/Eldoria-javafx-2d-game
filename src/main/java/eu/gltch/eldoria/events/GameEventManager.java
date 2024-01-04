package eu.gltch.eldoria.events;

import java.util.ArrayList;
import java.util.List;

public class GameEventManager {
    //singleton implementation with private constructor
    private static GameEventManager instance = new GameEventManager();
    private GameEventManager() {};
    public static GameEventManager getInstance() {
        return instance;
    }
    private List<GameEventListener> listeners = new ArrayList<>();
    public void subscribe(GameEventListener listener){
        listeners.add(listener);
    }
    public void publish(GameEvent event){
        for(GameEventListener listener : listeners)
            listener.handleEvent(event);
    }
}
