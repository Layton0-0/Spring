package hello.core.gilbut.factoryMethod;

public class CheesePizzaFactory extends PizzaFactory{
    @Override
    Pizza createPizza(String name) {
        switch (name) {
            case "pickle":
                return new CheesePicklePizza();
            case "onion":
                return new CheeseOnionPizza();
        }
        return null;
    }
}
