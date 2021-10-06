package AbstractFactory;

import People.Marine;
import UnitLevel.HighClassUnit;
import UnitLevel.LowClassUnit;
import UnitLevel.MidClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public interface AbstractFactory {

    LowClassUnit createLowClass();

    MidClassUnit createMidClass();

    HighClassUnit createHighClass();
}
