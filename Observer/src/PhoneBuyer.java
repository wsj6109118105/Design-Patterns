import javax.naming.Name;

/**
 * user:lufei
 * DATE:2021/11/23
 **/
public class PhoneBuyer extends Buyer{
    public PhoneBuyer(String name) {
        super(name);
    }

    @Override
    public void info(String product) {
        if (product.contains("手机")) {
            System.out.println(name+"购买"+product);
        }
    }
}
