/**
 * user:lufei
 * DATE:2021/11/12
 **/
public class Human extends Mammal{
    @Override
    public void eat() {
        System.out.println("去饭店吃饭");
    }

    @Override
    public void move() {
        System.out.print("人乘坐交通工具");
    }
}
