package hello.core.gilbut.factoryMethod;

public class GiveMePizza {
    public static void main(String[] args) {
        // 팩토리 패턴만 보기 위해 일단 바로 new 선언한다.
        PizzaFactory pizzaFactory = new CheesePizzaFactory();
        Pizza pizza = pizzaFactory.createPizza("pickle");
        System.out.println("pizza = " + pizza);
    }
}
