package DynamicProxy;

import StaticProxy.PieService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * user:lufei
 * DATE:2021/11/10
 **/
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    // 生成代理对象
    public Object proxy() {
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    /**
     *
     * @param proxy 动态生成的代理对象
     * @param method 代理方法
     * @param args 代理方法的方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        after();
        Object result = method.invoke(target,args);
        before();
        return result;
    }

    private void after() {
        if (target instanceof PieService) {
            System.out.println("准备 pie 材料");
        }else if (target instanceof Soup) {
            System.out.println("准备汤材料");
        }
    }

    private void before() {
        if (target instanceof PieService) {
            System.out.println("出售 pie");
        }else if (target instanceof Soup) {
            System.out.println("出售汤");
        }
    }
}
