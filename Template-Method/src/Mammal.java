/**
 * user:lufei
 * DATE:2021/11/12
 **/
public abstract class Mammal {

    public abstract void eat();

    public abstract void move();

    public final void live() {
        move();
        eat();
    }

}
