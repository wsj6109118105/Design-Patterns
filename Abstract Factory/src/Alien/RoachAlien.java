package Alien;

import UnitLevel.LowClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public class RoachAlien extends LowClassUnit {
    public RoachAlien(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("蟑螂出现在："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("蟑螂攻击："+attack);
    }
}
