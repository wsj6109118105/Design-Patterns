## 观察者模式
可以针对被观察对象与观察者对象之间一对多的依赖关系建立起一种行为自动触发的机制，当被观察者对象状态发生变化时主动
对外发起广播，以通知所有观察者做出响应。

> 这次以买家买商品为例子

卖家商品更新，则买家去买商品。

> 商店类
```java
public class Shop {
    private String product;
    private List<Buyer> buyers;

    public Shop() {
        this.product = "无商品";
        this.buyers = new ArrayList<>();
    }
    
    // 注册买家到预购清单中
    public void register(Buyer buyer) {
        buyers.add(buyer);
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;    // 有货时通知买家
        notifyBuyers();
    }

    private void notifyBuyers() {
        buyers.forEach(b->b.info(this.getProduct()));
    }
}
```
> 买家类
```java
public abstract class Buyer {
    
    private String name;

    public Buyer(String name) {
        this.name = name;
    }

    public abstract void info(String product);
}
```
> 买家1
```java
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
```
> 买家2
```java
public class HandChopper extends Buyer{
    public HandChopper(String name) {
        super(name);
    }

    @Override
    public void info(String product) {
        System.out.println(name+"购买"+product);
    }
}
```
> 测试
```java
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
```
> 输出
```shell
剁手李四购买衣服
手机张三购买手机
剁手李四购买手机
```
在本例中，各个角色如下：

目标主题：被观察的目标主题，维护观察者列表，定义注册(register)和通知(notify)方法,对应 Shop

观察者接口：定义响应方法 info,对应 Buyer

观察者实现：实现接口中的响应方法，接到通知后进行自己的处理，对应 PhoneBuyer  HandChopper

