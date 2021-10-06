package top;

/**
 * user:lufei
 * DATE:2021/10/6
 **/
/*
    所有兵种的顶层接口
 */
public abstract class Unit {
    protected int attack;
    protected int defence;
    protected int health;
    protected int x;
    protected int y;

    public Unit(int attack, int defence, int health, int x, int y) {
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public abstract void show();

    public abstract void attack();
}
