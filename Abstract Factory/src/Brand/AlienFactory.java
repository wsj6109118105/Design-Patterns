package Brand;

import AbstractFactory.AbstractFactory;
import Alien.MammothAlien;
import Alien.PoisonAlien;
import Alien.RoachAlien;
import UnitLevel.HighClassUnit;
import UnitLevel.LowClassUnit;
import UnitLevel.MidClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public class AlienFactory implements AbstractFactory {

    private int x;
    private int y;

    public AlienFactory(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public LowClassUnit createLowClass() {
        return new RoachAlien(x,y);
    }

    @Override
    public MidClassUnit createMidClass() {
        return new PoisonAlien(x,y);
    }

    @Override
    public HighClassUnit createHighClass() {
        return new MammothAlien(x,y);
    }
}
