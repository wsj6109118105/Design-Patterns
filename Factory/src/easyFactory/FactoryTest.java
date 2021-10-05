package easyFactory;

/**
 * user:lufei
 * DATE:2021/10/5
 **/
public class FactoryTest {

    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();
        Fruit apple = factory.produce("APPLE");
        apple.eat();
        Fruit banana = factory.produce("banana");
        banana.eat();
    }
}

