package StaticProxy;

/**
 * user:lufei
 * DATE:2021/11/10
 **/
public class PieServiceProxy {
    private PieService pieService;

    public PieServiceProxy() {
        pieService = new PieServiceImpl();
    }

    public void make() {
        before();
        pieService.make();
        after();
    }

    private void after() {
        System.out.println("出售");
    }

    private void before() {
        System.out.println("准备材料");
    }
}
