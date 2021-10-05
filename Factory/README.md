## 简单工厂模式
可以将产品从客户端抽离出来，解耦，但是工厂职责过重，新增类型需要修改代码，违反开闭原则。
>顶层接口

```java
public interface Fruit {
    
    void eat();
    
}
```
>接口实现类

Apple
```java
public class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}
```
Banana
```java
public class Banana implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat banana");
    }
}
```
>工厂实现

```java
public class FruitFactory {

    public Fruit produce(String s){
        if(s.equalsIgnoreCase("apple")){
            return new Apple();
        }else if(s.equalsIgnoreCase("banana")){
            return new Banana();
        }else{
            return null;
        }
    }
}
```
>测试
```java
public class FactoryTest {

    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();
        Fruit apple = factory.produce("APPLE");
        apple.eat();
        Fruit banana = factory.produce("banana");
        banana.eat();
    }
}
```
>输出
```shell
eat apple
eat banana
```
## 工厂方法模式
让实现类来决定究竟创建那种对象，将实例化推迟到子类进行
**优点**
1.将产品从客户端分离出来，解耦
2.新加类型时，只需要新加工厂即可，无需改动原有代码。
**缺点**
类的个数过多，复杂
>水果顶层接口
```java
public interface Fruit {
    void eat();
}
```
>水果实现类

Apple
```java
public class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}
```
Banana
```java
public class Banana implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat banana");
    }
}
```
>工厂
```java
public interface FruitFactory {
    Fruit produce();
}

```
苹果工厂
```java
public class AppleFactory implements FruitFactory {
    @Override
    public Fruit produce() {
        return new Apple();
    }
}
```
香蕉工厂
```java
public class BananaFactory implements FruitFactory {
    @Override
    public Fruit produce() {
        return new Banana();
    }
}
```
>测试
```java
public class Test {
    public static void main(String[] args) {
        FruitFactory factory = new AppleFactory();
        Fruit apple = factory.produce();
        apple.eat();
        factory = new BananaFactory();
        Fruit banana = factory.produce();
        banana.eat();
    }
}
```
>输出
```shell
eat apple
eat banana
```
