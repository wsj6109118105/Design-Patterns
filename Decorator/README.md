## 装饰器
装饰器模式能够在运行时动态的为原始对象增加一些额外的功能，使其变得更强大类似于继承，但继承是在编译时通过对原始类的继承完成，装饰器则是在运行
时对原始对象动态的“包装”完成。

> 适用于

1.拓展一个类的功能。

2.动态给对象添加功能。

> 优点

1.继承的有力补充，不改变原有对象的情况下给对象拓展功能。

2.通过适用不同的装饰类，不同的组合方式，实现不同的效果。

3.符合开闭原则。

> 缺点

增加程序复杂性。

> 定义人类接口
```java
public interface Person {
    public abstract String show();
}
```
> 定义武器装饰器
```java
public class ArmDecorator implements Person{

    private Person person;    //被装饰的人

    public ArmDecorator(Person person) {
        this.person = person;
    }

    @Override
    public String show() {
        return "手拿武器的"+person.show();     //对被装饰的人的拓展
    }
}
```
> 定义战甲装饰器
```java
public class CorseletDecorator implements Person{

    private Person person;

    public CorseletDecorator(Person person) {
        this.person = person;
    }

    @Override
    public String show() {
        return "身披战甲"+person.show();
    }
}
```
> 定义士兵
```java
public class Soldier implements Person{

    @Override
    public String show() {
        return "士兵";
    }
}
```
> 客户端
```java
public class Client {
    public static void main(String[] args) {
        Person soldier = new ArmDecorator(new Soldier());
        soldier = new CorseletDecorator(soldier);
        System.out.println(soldier.show());
    }
}
```
> 通过装饰器装饰的士兵
```shell
身披战甲手拿武器的士兵
```
可以通过这种方式，给士兵添加不同的装饰器，来实现不同的效果。

