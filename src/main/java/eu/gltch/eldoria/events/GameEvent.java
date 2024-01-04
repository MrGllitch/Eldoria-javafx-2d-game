package eu.gltch.eldoria.events;

public class GameEvent {
    public EventType getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    public enum EventType {
        SHOOT, HIT
    }
    private EventType type;
    private Object data;
    public GameEvent(EventType type, Object data){
        this.type = type;
        this.data = data;
    }
}
