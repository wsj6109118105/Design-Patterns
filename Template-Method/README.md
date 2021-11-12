## 模板方法
模板方法是对一系列类，行为(方法)的模式化。将总结出来的行为规律固化在基类中，对具体的行为实现则进行抽象化，并交给
子类实现。
> 优点

提高复用性；

提高拓展性；

符合开闭原则。
> 缺点

类的数目增加；

增加了系统实现的复杂度；

父类添加新的抽象方法，所有子类都要改一遍。

> 定义一个生存接口
```java
public abstract class Mammal {
    
    public abstract void eat();
    
    public abstract void move();
    
    public final void live() {
        move();
        eat();
    }
    
}
```
生存方式固有，都是移动，吃东西，所以 live 方法用 final 修饰，不允许子类重写。而移动方式，吃的东西各不相同，
需要子类自己实现。
> 定义人类
```java
public class Human extends Mammal{
    @Override
    public void eat() {
        System.out.println("去饭店吃饭");
    }

    @Override
    public void move() {
        System.out.print("人乘坐交通工具");
    }
}
```
人类实现自己的移动和吃的方法。
> 定义鱼类
```java
public class Fish extends Mammal{
    @Override
    public void eat() {
        System.out.println("捕食小鱼");
    }

    @Override
    public void move() {
        System.out.print("鱼在水里游");
    }
}
```
鱼类同样实现自己的方式。
> 定义鸟类
```java
public class Bird extends Mammal{
    @Override
    public void eat() {
        System.out.println("捕食昆虫");
    }

    @Override
    public void move() {
        System.out.print("鸟在天上飞行");
    }
}
```
> 定义客户端
```java
public class Test {
    public static void main(String[] args) {
        Mammal mammal = new Bird();
        mammal.live();
        mammal = new Human();
        mammal.live();;
        mammal = new Fish();
        mammal.live();
    }
}
```
> 结果
```shell
鸟在天上飞行捕食昆虫
人乘坐交通工具去饭店吃饭
鱼在水里游捕食小鱼
```
模板方法可以将总结出来的规律沉淀为一种既定的格式，并固化于模板中以供子类继承，对未确立下来的方法进行抽象，使得其
得以延续，多态化。
