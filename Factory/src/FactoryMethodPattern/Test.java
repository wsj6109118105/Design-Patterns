package FactoryMethodPattern;

import FactoryMethodPattern.FactoryImpl.AppleFactory;
import FactoryMethodPattern.FactoryImpl.BananaFactory;
import FactoryMethodPattern.top.Fruit;
import FactoryMethodPattern.top.FruitFactory;

/**
 * user:lufei
 * DATE:2021/10/5
 **/
public class Test {
    public static void main(String[] args) {
        FruitFactory factory = new AppleFactory();
        Fruit apple = factory.produce();
        apple.eat();
        factory = new BananaFactory();
        Fruit banana = factory.produce();
        banana.eat();
    }
}
