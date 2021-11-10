## 代理模式
为其他对象提供一种代理，以控制对这个对象的访问，代理对象在客户端和目标对象之间起到了中介的作用。

>适用于：

保护目标对象

增强目标对象

>优点：

将客户对象和真实被调用的对象隔离

降低耦合

保护目标对象，增强目标对象
> 缺点：

类的数目增加，增加复杂度

客户端和目标对象增加代理对象，造成处理速度变慢。

>静态代理：

通过在代码中显式地定义了一个代理类，在代理类中通过同名的方法对目标对象的方法进行包装，客户端通过调用代理类的方法来
调用目标对象的方法。

> 一个制作 pie 的接口
```java
public interface PieService {
    void make();
}
```
> pie 的实现
```java
public class PieServiceImpl implements PieService{
    @Override
    public void make() {
        System.out.println("制作苹果🥧");
    }
}
```
> 通过代理进行增强
```java
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
```
> 测试类
```java
public class StaticTest {
    public static void main(String[] args) {
        PieServiceProxy pieServiceProxy = new PieServiceProxy();
        pieServiceProxy.make();
    }
}
```
> 结果
```shell
准备材料
制作苹果🥧
出售
```
通过显示的定义，来达到增强的效果
> 动态代理

JDK的动态代理只能代理接口，通过接口的方法名在动态生成的代理类中调用业务实现类的同名方法。

> 制作汤接口
```java
public interface Soup {
    void makeSoup(String materials);
}
```
> 制作汤实现
```java
public class SoupImpl implements Soup{
    @Override
    public void makeSoup(String materials) {
        System.out.println("制作"+ materials +"汤");
    }
}
```
> 动态代理增强
```java
public class DynamicProxy implements InvocationHandler {
    
    // 被代理对象
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
```
> 测试
```java
public class DynamicTest {
    public static void main(String[] args) {
        PieService proxyPie = (PieService) new DynamicProxy(new PieServiceImpl()).proxy();
        proxyPie.make();
        System.out.println("====================");
        Soup proxySoup = (Soup) new DynamicProxy(new SoupImpl()).proxy();
        proxySoup.makeSoup("八宝");
    }
}
```
> 结果
```shell
准备 pie 材料
制作苹果🥧
出售 pie
====================
准备汤材料
制作八宝汤
出售汤
```
