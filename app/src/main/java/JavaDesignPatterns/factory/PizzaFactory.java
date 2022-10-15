package JavaDesignPatterns.factory;

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
