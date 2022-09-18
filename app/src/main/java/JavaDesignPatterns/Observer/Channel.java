package JavaDesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Observer {
    public String name;
    private List<Subscriber> subscribers = new ArrayList<>();
    private String title;

    public Channel(String name) {
        this.name = name;
        System.out.println("New channle called " + name + " is created");
    }

    @Override
    public void subscribe(Subscriber sub) {

        subscribers.add(sub);
        System.out.println(sub.getName() + " is now subscribed to " + name + " channel");
    }

    @Override
    public void unsbscribe(Subscriber sub) {

        subscribers.remove(sub);
        System.out.println(sub.getName() + " is now unsubscribed from " + name + " channel");
    }

    @Override
    public int numberOfSubscribers() {
        return subscribers.size();
    }

    public String getTitle() {
        return "Title";
    }

    @Override
    public void upload(String title) {
        this.title = title;
        notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber sub: subscribers)
        {
            sub.update(title);
        }
    }

    public String getName() {
        return name;
    }
}
