package JavaDesignPatterns.factory;

public class MCRPizzaOrdersApp {

    public static void main(String[] args){
        MCRPizzaStore mcrPizzaStore = new MCRPizzaStore();

        Pizza cheesePizza = mcrPizzaStore.orderPizza("cheese");

        Pizza pepperoniPizza = mcrPizzaStore.orderPizza("pepperoni");
    }
}
