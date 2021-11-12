/**
 * user:lufei
 * DATE:2021/11/12
 **/
public class Fish extends Mammal{
    @Override
    public void eat() {
        System.out.println("捕食小鱼");
    }

    @Override
    public void move() {
        System.out.print("鱼在水里游");
    }
}
