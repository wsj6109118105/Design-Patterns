/**
 * user:lufei
 * DATE:2021/11/12
 **/
public class Bird extends Mammal{
    @Override
    public void eat() {
        System.out.println("捕食昆虫");
    }

    @Override
    public void move() {
        System.out.print("鸟在天上飞行");
    }
}
