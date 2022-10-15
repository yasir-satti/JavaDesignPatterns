package JavaDesignPatterns.factory;

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
