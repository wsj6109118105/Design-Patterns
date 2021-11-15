/**
 * user:lufei
 * DATE:2021/11/15
 **/
public class Test {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.setStrategy(new Addition());
        System.out.println(calculate.getResult(5, 8));
        calculate.setStrategy(new Subtraction());
        System.out.println(calculate.getResult(8, 5));
        calculate.setStrategy(new multiplication());
        System.out.println(calculate.getResult(8, 5));
    }
}
