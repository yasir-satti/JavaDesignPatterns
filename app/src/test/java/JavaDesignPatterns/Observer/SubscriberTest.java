package JavaDesignPatterns.Observer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriberTest {

    @Test
    public void nameOfChannel(){
        Channel channel = new Channel("Google");
        assertEquals("Google", channel.getName());
    }
    @Test
    public void nameOfSubscriber(){
        Subscriber subscriber = new Subscriber("Yasir");
        assertEquals("Yasir", subscriber.getName());
    }
    @Test
    public void addOneSubscriberToChannel() {
        Channel channel = new Channel("youtube");
        Subscriber subscriber = new Subscriber("Yasir");
        channel.subscribe(subscriber);
        assertEquals(1, channel.numberOfSubscribers());
    }
    @Test
    public void addTwoeSubscribersToChannel() {
        Channel channel = new Channel("youtube");
        Subscriber subscriber = new Subscriber("Yasir");
        channel.subscribe(subscriber);
        channel.subscribe(subscriber);
        assertEquals(2, channel.numberOfSubscribers());
    }
    @Test
    public void removeSubsriberFromChannel() {
        Channel channel = new Channel("youtube");
        Subscriber subscriber = new Subscriber("Yasir");
        channel.subscribe(subscriber);
        channel.subscribe(subscriber);
        channel.unsbscribe(subscriber);
        assertEquals(1, channel.numberOfSubscribers());
    }
    @Test
    public void channelWithNoSubscribers() {
        Channel channel = new Channel("youtube");
        assertEquals(0, channel.numberOfSubscribers());
    }
    @Test
    public void uploadToChannel() {
        Channel channel = new Channel("youtube");
        channel.upload("Title");
        assertEquals("Title", channel.getTitle());
    }
    @Test
    public void updateSubscriber() {
        Subscriber subscriber = new Subscriber("Yasir");
        assertEquals("Video uploaded", subscriber.update("title"));
    }
    @Test
    public void notifySubscriber() {
        Channel channel = new Channel("youtube");
        Subscriber subscriber = new Subscriber("Yasir");
        channel.notifySubscribers();
        assertEquals(false, subscriber.receivedUpdate());
    }
}

