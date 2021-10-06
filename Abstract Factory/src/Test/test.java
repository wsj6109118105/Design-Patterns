package Test;

import Brand.AlienFactory;
import Brand.PeopleFactory;
import UnitLevel.HighClassUnit;
import UnitLevel.LowClassUnit;
import UnitLevel.MidClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public class test {
    public static void main(String[] args) {
        PeopleFactory peopleFactory = new PeopleFactory(10,10);
        AlienFactory alienFactory = new AlienFactory(20,20);
        LowClassUnit lowClass1 = alienFactory.createLowClass();
        LowClassUnit lowClass = peopleFactory.createLowClass();
        lowClass.show();
        lowClass1.show();
        lowClass1.attack();
        lowClass.attack();
        MidClassUnit midClass1 = alienFactory.createMidClass();
        MidClassUnit midClass = peopleFactory.createMidClass();
        midClass1.show();
        midClass.show();
        midClass1.attack();
        midClass.attack();
        HighClassUnit highClass1 = alienFactory.createHighClass();
        HighClassUnit highClass = peopleFactory.createHighClass();
        highClass1.show();
        highClass.show();
        highClass1.attack();
        highClass.attack();

    }
}
