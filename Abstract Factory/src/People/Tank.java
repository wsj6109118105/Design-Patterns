package People;

import UnitLevel.MidClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public class Tank extends MidClassUnit {

    public Tank(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("坦克出现在："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("坦克攻击："+attack);
    }
}
