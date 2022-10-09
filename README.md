# Design Patterns using JAVA
## Contents

1. What is a design pattern

2. Patterns

    - Behavioural
        - Observer
    - Creational
        - Builder
    - Structural
        - Adapter 

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

### 2.1 Observer (behavioural)

    - Intent
a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

    - Problem
A CUSTOMER is interested in a specific item a STORE is about to lanuch. So either the CUSTOMER wastes time checking the avaialbility of the item or STORE wastes resources notifying wrong customers.

    - Solution
Observer pattern provides a PUBLISHER class and  a SUBSCRIBERS class. Publisher class ( in this case STORE ) sends regular stream events recieved by subscribes (in this case CUSTOMER )

Reference [Observer](https://refactoring.guru/design-patterns/observer)

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

### 2.2 Builder (Creational)

    - Intent
Builder design pattern is an alternative way to construct complex objects and should be used only when we want to build
different types of immutable objects using same object building process. The pattern allows you to produce different
types and representations of an object using the same construction code. Builder pattern aims to “Separate the
construction of a complex object from its representation so that the same construction process can create multiple
different representations.”. A builder pattern should be more like a fluent interface. A fluent interface is normally
implemented by using method cascading (or method chaining) as we see it in lambda expressions.

    - Problem
Imagine a complex object that requires laborious, step-by-step initialization of many fields and nested objects. Such
initialization code is usually buried inside a monstrous constructor with lots of parameters. Or even worse: scattered
all over the client code.

    - Solution
The Builder pattern suggests that you extract the object construction code out of its own class and move it to separate
objects called builders. The pattern organizes object construction into a set of steps . To create an object, you
execute a series of these steps on a builder object. The important part is that you don’t need to call all of the steps.
You can call only those steps that are necessary for producing a particular configuration of an object.

    - Director
You can go further and extract a series of calls to the builder steps you use to construct a product into a separate
class called director. The director class defines the order in which to execute the building steps, while the builder
provides the implementation for those steps.

Reference [Builder](https://refactoring.guru/design-patterns/builder)

    - Code example

We aim to build a desktop product with following features:
- HP desktop
- Dell desktop
- Each desktop will have its own configuration for monitor, mouse, keyboard, ..etc.

The builder is an interface that specifies the what to build

```java
package JavaDesignPatterns.Builder;

public interface Builder {

    void buildMonitor();
    void buildKeyboard();
    void buildMouse();
    void buildSpeaker();
    void buildRAM();
    void buildProcessor();
    void buildMotherboard();
}
```

Then the build concrete classes implement the methods in the builder each according to its specific features and at the
end it returns the object product

So HP desktop will be

```java
package JavaDesignPatterns.Builder;

public class HPDesktopBuilder implements Builder{

    Desktop desktop = new Desktop();
    @Override
    public void buildMonitor() {
        desktop.setMonitor("HP monitor");
    }

    @Override
    public void buildKeyboard() {
        desktop.setKeyboard("HP keyboard");
    }

    @Override
    public void buildMouse() {
        desktop.setMouse("HP mouse");
    }

    @Override
    public void buildSpeaker() {
        desktop.setSpeaker("HP speaker");
    }

    @Override
    public void buildRAM() {
        desktop.setRAM("HP RAM");
    }

    @Override
    public void buildProcessor() {
        desktop.setProcessor("HP processor");
    }

    @Override
    public void buildMotherboard() {
        desktop.setMotherboard("HP motherboard");
    }

    public Desktop getDesktop() {
        return desktop;
    }
}
```

And Dell desktop will be
```java
package JavaDesignPatterns.Builder;

public class DellDesktopBuilder implements Builder{

    Desktop desktop = new Desktop();
    @Override
    public void buildMonitor() {
        desktop.setMonitor("Dell monitor");
    }

    @Override
    public void buildKeyboard() {
        desktop.setKeyboard("Dell keyboard");
    }

    @Override
    public void buildMouse() {
        desktop.setMouse("Dell mouse");
    }

    @Override
    public void buildSpeaker() {
        desktop.setSpeaker("Dell speaker");
    }

    @Override
    public void buildRAM() {
        desktop.setRAM("Dell RAM");
    }

    @Override
    public void buildProcessor() {
        desktop.setProcessor("Dell processor");
    }

    @Override
    public void buildMotherboard() {
        desktop.setMotherboard("Dell motherboard");
    }

    public Desktop getDesktop() {
        return desktop;
    }
}
```

The Director is the one that oversees the building process and the order of the steps by passing the concerete build objects to it and then go through the build steps accordingly

```java
package JavaDesignPatterns.Builder;

public class Director {

    public void buildDellDesktop(DellDesktopBuilder dellDesktopBuilder){
        dellDesktopBuilder.buildMonitor();
        dellDesktopBuilder.buildKeyboard();
        dellDesktopBuilder.buildMouse();
        dellDesktopBuilder.buildSpeaker();
        dellDesktopBuilder.buildRAM();
        dellDesktopBuilder.buildProcessor();
        dellDesktopBuilder.buildMotherboard();
    }

    public void buildHPDesktop(HPDesktopBuilder hpDesktopBuilder){
        hpDesktopBuilder.buildMonitor();
        hpDesktopBuilder.buildKeyboard();
        hpDesktopBuilder.buildMouse();
        hpDesktopBuilder.buildSpeaker();
        hpDesktopBuilder.buildRAM();
        hpDesktopBuilder.buildProcessor();
        hpDesktopBuilder.buildMotherboard();
    }
}
```

Now to build and show the product you just need to:

- get a Director object
- pass concerete build objects
- get the product built

```java
package JavaDesignPatterns.Builder;

public class DesktopSpecsApp {

    public static void main(String[] args){

        Director director = new Director();
        DellDesktopBuilder dellBuilder = new DellDesktopBuilder();
        director.buildDellDesktop(dellBuilder);
        Desktop dellDesktop = dellBuilder.getDesktop();
        dellDesktop.showSpecs();

        HPDesktopBuilder hpBuilder = new HPDesktopBuilder();
        director.buildHPDesktop(hpBuilder);
        Desktop hpDesktop = hpBuilder.getDesktop();
        hpDesktop.showSpecs();


    }
}
```

### 2.3 Adapter (Structural)


    - Intent
Adapter pattern makes it possible to connect two incompatible interfaces that cannot be connected directly. 

    - Problem
You have an audio player ( AudioPlayer class tht implements MediaPlayer interface ) that can play mp3 files. We also have an advanced audio player 
( AdvancedMediaPlayer class that implements AdvancedMediaPlayer interface ) that can play vlc and mp4 files. Each of those players have their interfaces and conceret classes. We want the audio player to be able
to play the vlc and mp4 files format too.

    - Solution
The Adaptrr pattern solves this in the following way:
- We create MediaAdapter that implements the MediaPlayer interface
- The AudioPlayer class uses AdvancedMediaPlayer class to play the vlc and mp4 file formats

References [Adaptr](https://refactoring.guru/design-patterns/adapter) / 
[Adapter pattern tutorial](https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm) 
/ [Adapter Pattern in Java](https://www.baeldung.com/java-adapter-pattern)

    - Code example

We start by creating MediaPlayer interface with method accepting file type and file name
```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
```
Create interface AdvancedMediaPlayer to use it to pass requests by MediaAdaptor to VlcPlayer and Mp4Player classes
```java
public interface AdvancedMediaPlayer {

    void playVlc(String fileName);
    
    void playMp4(String fileName);
}
```
We create VlcPlayer class tht implements the AdvancedMediaPlayer interface
```java
public class VlcPlayer implements AdvancedMediaPlayer {

    public void playVlc(String fileName){
        System.out.println("Playing vlc file. Name: " + fileName);
    }
}
```
Mp4player class
```java
public class Mp4Player {

    public void playMp4(String fileName){
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
```
Now here is the point where the Adapter pattern works its magic. Create Adapter class MediaAdapter which does the following:

- implements the MediaPlayer interface
- It has a constructor with audio type parameter 
```java
public class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public  void play(String audioType, String fileName){
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
```
Now create concrete class AudioPlayer that does the following:
- implements MediaPlayer interface
- Plays the mp3 file format
- Calls the MediaAdaptor when either vlc or mp4 file formats are deteced
```java
public class AudioPlayer implements MediaPlayer{

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName){
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media." + audioType + " format not supported.");
        }
    }
}
```
Now you can the differernt audio formats
```java
public class AdapterApp {
   public static void main(String[] args) {
      AudioPlayer audioPlayer = new AudioPlayer();

      audioPlayer.play("mp3", "beyond the horizon.mp3");
      audioPlayer.play("mp4", "alone.mp4");
      audioPlayer.play("vlc", "far far away.vlc");
      audioPlayer.play("avi", "mind me.avi");
   }
}
```