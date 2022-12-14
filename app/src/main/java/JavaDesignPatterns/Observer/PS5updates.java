/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package JavaDesignPatterns.Observer;

import JavaDesignPatterns.Observer.Channel;
import JavaDesignPatterns.Observer.Subscriber;

public class PS5updates {

    public static void main(String[] args) {

        Channel ps5Updates = new Channel("PS5");
        Subscriber sub1 = new Subscriber("Yasir");
        Subscriber sub2 = new Subscriber("Khalid");
        Subscriber sub3 = new Subscriber("Joe");
        Subscriber sub4 = new Subscriber("Sara");

        ps5Updates.subscribe(sub1);
        sub1.subscribedChannel(ps5Updates);

        ps5Updates.subscribe(sub2);
        sub1.subscribedChannel(ps5Updates);

        ps5Updates.subscribe(sub3);
        sub1.subscribedChannel(ps5Updates);

        ps5Updates.subscribe(sub4);
        sub1.subscribedChannel(ps5Updates);

        ps5Updates.upload("Tekken 8 Extreme Armagadon");

        ps5Updates.unsbscribe(sub3);
        sub3.unSubscribeChannel();

    }
}
