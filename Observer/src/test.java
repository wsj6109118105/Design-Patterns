/**
 * user:lufei
 * DATE:2021/11/23
 **/
public class test {
    public static void main(String[] args) {
        Shop shop = new Shop();
        PhoneBuyer phoneBuyer = new PhoneBuyer("手机张三");
        HandChopper handChopper = new HandChopper("剁手李四");
        shop.register(phoneBuyer,handChopper);
        shop.setProduct("衣服");
        shop.setProduct("手机");
    }
}
