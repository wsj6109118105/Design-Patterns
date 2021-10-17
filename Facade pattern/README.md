## 门面模式
将多个不同的子系统封装起来，对外提供同一的高层接口。也叫做外观模式。

>适用于：

1.子系统复杂，增加门面模式提供接口简单调用

2.构建多层系统结构，利用外观对象作为入口，简化层间调用

> 优点

1. 简化了调用过程，无需深入了解子系统。

2.降低耦合。

3.更好的层次划分

> 缺点

1.增加子系统，拓展子系统容易引入风险。

2.不符合开闭原则。

## 以做饭为例

整个过程需要买菜，做饭，以及最后的洗碗

**蔬菜商**
```java
public class VegVendor {
    public void purchase(){
        System.out.println("提供蔬菜");
    }
}
```
**厨师**
```java
public class Cook {
    public void cook(){
        System.out.println("下厨烹饪");
    }
}
```
**自己实现整个过程**
```java
public class Client {
    public void eat(){
        System.out.println("开始用餐");
    }
    
    public void clean(){
        System.out.println("洗碗");
    }

    public static void main(String[] args) {
        VegVendor vegVendor = new VegVendor();
        vegVendor.purchase();
        Cook cook = new Cook();
        cook.cook();
        Client client = new Client();
        client.eat();
        client.clean();
    }
}
```
结果：
```shell
提供蔬菜
下厨烹饪
开始用餐
洗碗
```
**使用门面**
```java
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
```
**实现流程**
```java
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
```
只需要调用门面的order方法即可，不在需要自己准备。
