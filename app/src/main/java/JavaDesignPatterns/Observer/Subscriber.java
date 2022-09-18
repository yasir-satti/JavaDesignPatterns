package JavaDesignPatterns.Observer;

public class Subscriber {

    private final String name;
    private Channel channel;
    private boolean isUpdateReceived = false;

    public Subscriber(String name) {
        this.name = name;
    }

    public String update(String title) {
        isUpdateReceived = true;
        System.out.println("Hi " + name + ", " + " the title " + title + " is uploaded to PS5 channel !");
        return "Video uploaded";
    }

    public void subscribedChannel(Channel ch){
        channel = ch;
        System.out.println(name + " channel " + ch.getName() + " is added to your channel subscription");
    }

    public void unSubscribeChannel(){
//        System.out.println(name + " channel " + channel.getName() + " is removed from your channel subscription");
        channel = null;
    }

    public boolean receivedUpdate() {
        return isUpdateReceived;
    }

    public String getName() {
        return name;
    }
}
