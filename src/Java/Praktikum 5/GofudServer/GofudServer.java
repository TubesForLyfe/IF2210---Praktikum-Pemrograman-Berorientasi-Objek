import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class GofudServer implements EventBroker {
    // maps a topic to a list of subscribers
    // feel free to change/add data structures
    private Map<String, ArrayList<Subscriber>> topics;

    public GofudServer() {
        this.topics = new HashMap<>();
    }

    // TODO: method when server/broker is sending an event through a topic
    public void sendEvent(String topic, Event event) {
        if (this.topics.containsKey(topic)) {
            // Send event to all subscribers
            for (Subscriber subscriber : this.topics.get(topic)) {
                subscriber.onEvent(event);
            }
        }
    }

    // TODO: method when a subscriber wants to subscribe to a topic
    public void addSubscriber(String topic, Subscriber subscriber) {
        if (!this.topics.containsKey(topic)) {
            // If topic does not exist
            this.topics.put(topic, new ArrayList<Subscriber>());
        }
        this.topics.get(topic).add(subscriber);
    }
}