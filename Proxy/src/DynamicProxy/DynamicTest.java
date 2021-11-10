package DynamicProxy;

import StaticProxy.PieService;
import StaticProxy.PieServiceImpl;

/**
 * user:lufei
 * DATE:2021/11/10
 **/
public class DynamicTest {
    public static void main(String[] args) {
        PieService proxyPie = (PieService) new DynamicProxy(new PieServiceImpl()).proxy();
        proxyPie.make();
        System.out.println("====================");
        Soup proxySoup = (Soup) new DynamicProxy(new SoupImpl()).proxy();
        proxySoup.makeSoup("八宝");
    }
}
