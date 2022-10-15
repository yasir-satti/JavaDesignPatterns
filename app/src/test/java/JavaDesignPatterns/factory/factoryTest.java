package JavaDesignPatterns.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        assertNull(pizza);
    }
}
