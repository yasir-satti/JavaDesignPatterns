package JavaDesignPatterns.Observer;

public interface Subject {
    String update(String title);

    void subscribedChannel(Channel ch);

    void unSubscribeChannel();

    boolean receivedUpdate();
}
