package FactoryMethodPattern.FactoryImpl;

import FactoryMethodPattern.FruitImpl.Banana;
import FactoryMethodPattern.top.Fruit;
import FactoryMethodPattern.top.FruitFactory;

/**
 * user:lufei
 * DATE:2021/10/5
 **/
public class BananaFactory implements FruitFactory {
    @Override
    public Fruit produce() {
        return new Banana();
    }
}
