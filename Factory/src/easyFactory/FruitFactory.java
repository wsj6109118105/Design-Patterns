package easyFactory;

import easyFactory.Impl.Apple;
import easyFactory.Impl.Banana;

/**
 * user:lufei
 * DATE:2021/10/5
 **/
public class FruitFactory {

    public Fruit produce(String s){
        if(s.equalsIgnoreCase("apple")){
            return new Apple();
        }else if(s.equalsIgnoreCase("banana")){
            return new Banana();
        }else{
            return null;
        }
    }
}
