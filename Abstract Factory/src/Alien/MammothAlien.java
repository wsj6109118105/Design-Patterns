package Alien;

import UnitLevel.HighClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public class MammothAlien extends HighClassUnit {
    public MammothAlien(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("猛犸象出现："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("猛犸象攻击："+attack);
    }
}
