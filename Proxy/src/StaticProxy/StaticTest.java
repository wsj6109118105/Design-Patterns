package StaticProxy;

/**
 * user:lufei
 * DATE:2021/11/10
 **/
public class StaticTest {
    public static void main(String[] args) {
        PieServiceProxy pieServiceProxy = new PieServiceProxy();
        pieServiceProxy.make();
    }
}
