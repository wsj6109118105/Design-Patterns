/**
 * user:lufei
 * DATE:2021/10/19
 **/
public class Client {
    public static void main(String[] args) {
        Person soldier = new ArmDecorator(new Soldier());
        soldier = new CorseletDecorator(soldier);
        System.out.println(soldier.show());
    }
}
