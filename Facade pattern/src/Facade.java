/**
 * user:lufei
 * DATE:2021/10/17
 **/
public class Facade {

    private VegVendor vegVendor;

    private Cook cook;

    private Waiter waiter;

    private Clean clean;

    public Facade() {
        vegVendor = new VegVendor();
        vegVendor.purchase();
        cook = new Cook();
        waiter = new Waiter();
        clean = new Clean();
    }

    public void order(){
        waiter.order();
        cook.cook();
        waiter.server();
        clean.clean();
    }
}
