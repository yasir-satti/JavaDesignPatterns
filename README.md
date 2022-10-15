# Design Patterns using JAVA
## Contents

1. What is a design pattern

2. Patterns

    - Behavioural
        - Observer
    - Creational
        - Builder
        - Factory method
    - Structural
        - Adapter 

## 1. What is a design pattern


A design pattern is solution for a problem, it helps you to design a solution and derive an implementation for the
solution. Design patterns are common solutions for common problems found in software design.

Design patterns is all about designing maintainable and extensible object-oriented software.

Type of design patterns:
- Creational Patterns: These design patterns provide ways to create objects while hiding the creation logic, instead of instantiating objects directly using the new operator. This gives the program more flexibility in deciding which objects need to be created for a given use case.
- Structural Patterns: These design patterns deal with class and object composition. The concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionality.
- Behavioral Patterns: These design patterns are specifically concerned with communication between objects.

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
The Adapter pattern solves this in the following way:
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
public class Mp4Player implements AdvancedMediaPlayer{

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

### 2.4 Factory Method (Creational)


    - Intent
- Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
- Defining a "virtual" constructor.
- The new operator considered harmful. There is a difference between requesting an object and creating one. The new operator always creates an object, and fails to encapsulate object creation. A Factory Method enforces that encapsulation, and allows an object to be requested without inextricable coupling to the act of creation.


     - Problem
  Imagine that you’re creating a logistics management application. The first version of your app can only handle transportation by trucks, so the bulk of your code lives inside the Truck class.

After a while, your app becomes pretty popular. Each day you receive dozens of requests from sea transportation companies to incorporate sea logistics into the app.
Great news, right? But how about the code? At present, most of your code is coupled to the Truck class. Adding Ships into the app would require making changes to the entire codebase. Moreover, if later you decide to add another type of transportation to the app, you will probably need to make all of these changes again.

As a result, you will end up with pretty nasty code, riddled with conditionals that switch the app’s behavior depending on the class of transportation objects.

    - Solution
The Factory Method pattern suggests that you replace direct object construction calls (using the new operator) with calls to a special factory method. Don’t worry: the objects are still created via the new operator, but it’s being called from within the factory method. Objects returned by a factory method are often referred to as products.

Factory Method is to creating objects as Template Method is to implementing an algorithm. A superclass specifies all standard and generic behavior (using pure virtual "placeholders" for creation steps), and then delegates the creation details to subclasses that are supplied by the client.

Factory Method makes a design more customizable and only a little more complicated. Other design patterns require new classes, whereas Factory Method only requires a new operation.

People often use Factory Method as the standard way to create objects; but it isn't necessary if: the class that's instantiated never changes, or instantiation takes place in an operation that subclasses can easily override (such as an initialization operation).

Factory Methods are routinely specified by an architectural framework, and then implemented by the user of the framework.

References [Adaptr](https://refactoring.guru/design-patterns/adapter) /
[Adapter pattern tutorial](https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm)
/ [Adapter Pattern in Java](https://www.baeldung.com/java-adapter-pattern)

    - Code example

Let us create pizza with different types ( pepperoni, cheese ).

So we start by having an abstract pizza class
```java
abstract class Pizza {}
```
We have our pizza type classes that extend the abstract pizza class
```java
class PepperoniPizza extends Pizza {}
```
```java
class CheesePizza extends Pizza {}
```
We have our pizza store class with one method which creates the requested pizza
```java
class PizzaFactory {
    public Pizza createPizza(String pizzaType) {
        if (pizzaType.equals("pepperoni")) {
            return new PepperoniPizza();
        } else if (pizzaType.equals("cheese")){
            return new CheesePizza();
        }
    }
}
```

The abstract Pizza class will have methods to create a requested pizza. The implementation will be left to the concrete classes CheesePizza and PepperoniPizza
```java
abstract class Pizza {
    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void box();
}
```
the conceret classes implementation
```java
public class CheesePizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing cheese pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking cheese pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting cheese pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing cheese pizza");
    }

}
```
```java
public class PepperoniPizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing pepperoni pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking pepperoni pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pepperoni pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing pepperoni pizza");
    }
}
```
The factoryPizza class is where the order and creation of the pizza happens. Here we will have a conceret orderPizza method taking the type of pizza ordered as input. Then the type of pizza is passed to an abstract createPizza method which is implemented by a pizzaStore conceret class that instatiate the needed class to fulfill the pizza order. After that it proceeds with the pizza creation steps.
```java
public abstract class PizzaFactory {
    public Pizza orderPizza(String pizzaType) {

        Pizza pizza = createPizza(pizzaType);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String pizzaType);

}
```

The PizzaStore conceret class
```java
public class MCRPizzaStore extends PizzaFactory{
    @Override
    protected Pizza createPizza(String pizzaType) {
        if (pizzaType.equals(("cheese"))) {
            return new CheesePizza();
        } else if (pizzaType.equals("pepperoni")) {
            return new PepperoniPizza();
        } else {
            return null;
        }
    }
}
```
It instatiates the relevant class required by the order
```java
public class CheesePizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing cheese pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking cheese pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting cheese pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing cheese pizza");
    }

}
```
```java
public class PepperoniPizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing pepperoni pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking pepperoni pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pepperoni pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing pepperoni pizza");
    }
}
```
Now you can make the orders
```java
public class MCRPizzaOrdersApp {

    public static void main(String[] args){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();

        Pizza cheesePizza = mcrPizzaStore.orderPizza("cheese");

        Pizza pepperoniPizza = mcrPizzaStore.orderPizza("pepperoni");
    }
}
```
The benefits of using the factory method are:

- You only need to instatiate the pizza store and then specify the pizza type
- The abstract Pizza class provides flexibility and leave the implementation to the concerete classes extending it
- How the implementation is done is completely hidden

Find below the test
```java
public class factoryTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        System.setOut(printStream);
    }

    @Test
    void prepareCheesePizza(){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();
        Pizza cheesePizza = mcrPizzaStore.createPizza("cheese");
        cheesePizza.prepare();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals("Preparing cheese pizza", builderOutput);
    }

    @Test
    void bakeCheesePizza(){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();
        Pizza cheesePizza = mcrPizzaStore.createPizza("cheese");
        cheesePizza.bake();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals("Baking cheese pizza", builderOutput);
    }

    @Test
    void cutCheesePizza(){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();
        Pizza cheesePizza = mcrPizzaStore.createPizza("cheese");
        cheesePizza.cut();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals("Cutting cheese pizza", builderOutput);
    }

    @Test
    void boxCheesePizza(){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();
        Pizza cheesePizza = mcrPizzaStore.createPizza("cheese");
        cheesePizza.box();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals("Boxing cheese pizza", builderOutput);
    }

    @Test
    void preparePepperoniPizza(){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();
        Pizza pepperoniPizza = mcrPizzaStore.createPizza("pepperoni");
        pepperoniPizza.prepare();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals("Preparing pepperoni pizza", builderOutput);
    }

    @Test
    void bakePepperoniPizza(){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();
        Pizza pepperoniPizza = mcrPizzaStore.createPizza("pepperoni");
        pepperoniPizza.bake();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals("Baking pepperoni pizza", builderOutput);
    }

    @Test
    void cutPepperoniPizza(){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();
        Pizza pepperoniPizza = mcrPizzaStore.createPizza("pepperoni");
        pepperoniPizza.cut();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals("Cutting pepperoni pizza", builderOutput);
    }

    @Test
    void boxPepperoniPizza(){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();
        Pizza pepperoniPizza = mcrPizzaStore.createPizza("pepperoni");
        pepperoniPizza.box();
        String builderOutput = outputStreamCaptor.toString().trim();
        assertEquals("Boxing pepperoni pizza", builderOutput);
    }

    @Test
    void orderWrongPizza(){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();
        Pizza pizza = mcrPizzaStore.createPizza("anchovi");
        assertEquals(null, pizza);
    }
}
```