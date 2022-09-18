package JavaDesignPatterns.Observer;

public class Subscriber {

    private String name;
    private Channel channel = new Channel();

    public String update() {
        String update = "Video uploaded";
        return update;
    }

    public String getName() {
        return name;
    }

    public String addChannel(String channel) {
        return channel;
    }

    public void subscribeToChannel(String ch) {
//        channel = ch;
    }
}
