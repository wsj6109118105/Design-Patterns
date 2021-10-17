/**
 * user:lufei
 * DATE:2021/10/17
 **/
public class Client {
    /*public void eat(){
        System.out.println("开始用餐");
    }

    public void clean(){
        System.out.println("洗碗");
    }*/

    public static void main(String[] args) {
        /*VegVendor vegVendor = new VegVendor();
        vegVendor.purchase();
        Cook cook = new Cook();
        cook.cook();
        Client client = new Client();
        client.eat();
        client.clean();*/
        Facade facade = new Facade();
        facade.order();
    }
}
