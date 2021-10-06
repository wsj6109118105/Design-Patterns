package People;

import UnitLevel.HighClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public class BattleShip extends HighClassUnit {

    public BattleShip(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("战舰出现："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("战舰攻击："+attack);
    }
}
