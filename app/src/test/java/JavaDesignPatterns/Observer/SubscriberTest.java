package JavaDesignPatterns.Observer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriberTest {

    @Test
    public void oneUserSubsribesToChannel() {
        Channel channel = new Channel();
        channel.subscribe(1);
        assertEquals(1, channel.numberOfSubscribers());
    }
    @Test
    public void twoeUserSubsribesToChannel() {
        Channel channel = new Channel();
        channel.subscribe(1);
        channel.subscribe(2);
        assertEquals(2, channel.numberOfSubscribers());
    }
    @Test
    public void removeSubsriberFromChannel() {
        Channel channel = new Channel();
        channel.subscribe(1);
        channel.subscribe(2);
        channel.unsbscribe(1);
        assertEquals(1, channel.numberOfSubscribers());
    }
    @Test
    public void channelWithNoSubscribers() {
        Channel channel = new Channel();
        assertEquals("Channel has no subscribers", channel.numberOfSubscribers());
    }
//    @Test
//    public void tryRemoveSubscriberFromchannelWithNoSubscribers() {
//        Channel channel = new Channel();
//        channel.unsbscribe(1);
//        assertEquals("Channel has no subscribers", channel.numberOfSubscribers());
//    }
//    @Test
//    public void userSubscribesToChannel() {
//        Subscriber subscriber = new Subscriber("Yasir");
//        assertEquals("PS5 updates", subscriber.addChannel("PS5 updates"));
//    }
}

