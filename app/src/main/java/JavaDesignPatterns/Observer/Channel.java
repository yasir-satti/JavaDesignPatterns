package JavaDesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private List<Integer> subscribers = new ArrayList<>();

    public Channel() {
    }

    public Channel(List<Integer> subscriber) {
        this.subscribers = subscriber;
    }

    public void subscribe(int i) {
        subscribers.add(i);
    }

    public void unsbscribe(Integer i) {
        subscribers.remove(1);
    }

    public int numberOfSubscribers() {
        return subscribers.size();
    }
}
