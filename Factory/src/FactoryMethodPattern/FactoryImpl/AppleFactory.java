package FactoryMethodPattern.FactoryImpl;

import FactoryMethodPattern.FruitImpl.Apple;
import FactoryMethodPattern.top.Fruit;
import FactoryMethodPattern.top.FruitFactory;

/**
 * user:lufei
 * DATE:2021/10/5
 **/
public class AppleFactory implements FruitFactory {
    @Override
    public Fruit produce() {
        return new Apple();
    }
}
