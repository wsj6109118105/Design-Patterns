/**
 * user:lufei
 * DATE:2021/11/23
 **/
public class HandChopper extends Buyer{
    public HandChopper(String name) {
        super(name);
    }

    @Override
    public void info(String product) {
        System.out.println(name+"购买"+product);
    }
}
