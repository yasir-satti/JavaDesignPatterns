# Design Patterns using JAVA
## Contents

1. What is a design pattern

2. Patterns

    - Behavioural
      - JavaDesignPatterns.Observer

## 1. What is a design pattern


A design pattern is solution for a problem, it helps you to design a solution and derive an implementation for the
solution. Design patterns are common solutions for common problems found in software design.

Design patterns is all about designing maintainable and extensible object-oriented software

A deisgn pattern usually is described having:

 - Intent
    this describes the problem and the solution

  - Motivations
    Provides more detail on the problem and how the pattern makes the solution possible

   - Structure
    Provides the classes that make the pattern solution and how they relate to each other

   - Code example
    Sample example using a language to make it easier to grasp how the pattern works

## 2. Patterns

### 2.1 JavaDesignPatterns.Observer (behavioural)

    - Intent
a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

    - Problem
A CUSTOMER is interested in a specific item a STORE is about to lanuch. So either the CUSTOMER wastes time checking the avaialbility of the item or STORE wastes resources notifying wrong customers.

    - Solution
JavaDesignPatterns.Observer pattern provides a PUBLISHER class and  a SUBSCRIBERS class. Publisher class ( in this case STORE ) sends regular stream events recieved by subscribes (in this case CUSTOMER )

Reference [JavaDesignPatterns.Observer](https://refactoring.guru/design-patterns/observer)

    - Code example

We have a channel that adds titles, and there are users who are interested to know about these titles whenever they are added.
So we have a channel with following features:
- add interested users ( subscribers) in to a list
- remove subscribers from list
- upload new title
- notify channel subscribers

```java
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
```
Then you have subscriber class that have the following features:
- update subscriber a title is loaded
- add channel the user is subscribed to
- remove channel the user was subscribed to

```java
package JavaDesignPatterns.Observer;

public class Subscriber implements Subject {

    private final String name;
    private Channel channel;
    private boolean isUpdateReceived = false;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public String update(String title) {
        isUpdateReceived = true;
        System.out.println("Hi " + name + ", " + " the title " + title + " is uploaded to PS5 channel !");
        return "Video uploaded";
    }

    @Override
    public void subscribedChannel(Channel ch){
        channel = ch;
        System.out.println(name + " channel " + ch.getName() + " is added to your channel subscription");
    }

    @Override
    public void unSubscribeChannel(){
        channel = null;
    }

    @Override
    public boolean receivedUpdate() {
        return isUpdateReceived;
    }

    public String getName() {
        return name;
    }
}
```

Now Observer pattern is based on relationship between SUBJECT ( in our example is channel ) and OBSERVER ( in our example is subscriber ). Whenever SUBJECT (also called PUBLISHER because it notifies its subscribers with change it its state) has change in state it sends notification to its subscribers.

Now the notification method is shared between the SUBJECT and OBSERVER so it is a shared interface.

Let us refactor to reflect this principle. The implementation is done in each relevant class.
```java
package JavaDesignPatterns.Observer;

public interface Subject {
    String update(String title);

    void subscribedChannel(Channel ch);

    void unSubscribeChannel();

    boolean receivedUpdate();
}
```

```java
package JavaDesignPatterns.Observer;

public interface Observer {
    void subscribe(Subscriber sub);

    void unsbscribe(Subscriber sub);

    int numberOfSubscribers();

    void upload(String title);

    void notifySubscribers();
}
```