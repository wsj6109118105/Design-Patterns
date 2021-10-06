package People;

import UnitLevel.LowClassUnit;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
public class Marine extends LowClassUnit {
    public Marine(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("出现位置:"+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("士兵攻击："+attack);
    }
}
