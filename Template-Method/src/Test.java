/**
 * user:lufei
 * DATE:2021/11/12
 **/
public class Test {
    public static void main(String[] args) {
        Mammal mammal = new Bird();
        mammal.live();
        mammal = new Human();
        mammal.live();;
        mammal = new Fish();
        mammal.live();
    }
}
