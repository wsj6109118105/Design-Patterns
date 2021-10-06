package Brand;

import AbstractFactory.AbstractFactory;
import People.BattleShip;
import People.Marine;
import People.Tank;
import UnitLevel.HighClassUnit;
import UnitLevel.LowClassUnit;
import UnitLevel.MidClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public class PeopleFactory implements AbstractFactory {

    private int x;
    private int y;

    public PeopleFactory(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public LowClassUnit createLowClass() {
        return new Marine(x,y);
    }

    @Override
    public MidClassUnit createMidClass() {
        return new Tank(x,y);
    }

    @Override
    public HighClassUnit createHighClass() {
        return new BattleShip(x,y);
    }
}
