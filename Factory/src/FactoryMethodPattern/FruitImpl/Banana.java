package FactoryMethodPattern.FruitImpl;


import FactoryMethodPattern.top.Fruit;

/**
 * user:lufei
 * DATE:2021/10/5
 **/
public class Banana implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat banana");
    }
}
