package Alien;

import UnitLevel.MidClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public class PoisonAlien extends MidClassUnit {
    public PoisonAlien(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("毒液出现在："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("毒液攻击："+attack);
    }
}
