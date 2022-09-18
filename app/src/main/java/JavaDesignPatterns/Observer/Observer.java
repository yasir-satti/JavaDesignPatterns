package JavaDesignPatterns.Observer;

public interface Observer {
    void subscribe(Subscriber sub);

    void unsbscribe(Subscriber sub);

    int numberOfSubscribers();

    void upload(String title);

    void notifySubscribers();
}
