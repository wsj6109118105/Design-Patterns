## 桥接
能够将抽象与实现分离，使二者单独变化而不受对方约束，使用时再将他们组合起来，

> 适用与

抽象和实体实现之间增加更多的灵活。

一个类存在多个变化的维度，并且需要独立拓展。

不希望适用继承。

> 优点

分离抽象部分和具体实现部分。

提高了系统可拓展性。

符合开闭原则和合成复用原则。

> 缺点

增加系统的理解和设计难度。

> 尺子接口
```java
// 尺子类接口
public interface Ruler {
    void regularize();
}
```
> 尺子实现：三种尺子
```java
public class SquareRuler implements Ruler{
    @Override
    public void regularize() {
        System.out.println("口");
    }
}
```
```java
public class CircleRuler implements Ruler{
    @Override
    public void regularize() {
        System.out.println("⚪");
    }
}
```
```java
public class TriangleRuler implements Ruler{
    @Override
    public void regularize() {
        System.out.println("▲");
    }
}
```
> 画笔
```java
public abstract class Pen {
    protected Ruler ruler;
    
    public Pen(Ruler ruler) {
        this.ruler = ruler;
    }
    
    public abstract void draw();
}
```
> 黑色画笔
```java
public class BlackPen extends Pen{

    public BlackPen(Ruler ruler) {
        super(ruler);
    }

    @Override
    public void draw() {
        System.out.println("黑");
        ruler.regularize();
    }
}
```
> 白色画笔
```java
public class WhitePen extends Pen{
    public WhitePen(Ruler ruler) {
        super(ruler);
    }

    @Override
    public void draw() {
        System.out.println("白");
        ruler.regularize();
    }
}
```
> 客户端
```java
public class Test {
    public static void main(String[] args) {
        new WhitePen(new CircleRuler()).draw();
        new WhitePen(new SquareRuler()).draw();
        new WhitePen(new TriangleRuler()).draw();
        new BlackPen(new TriangleRuler()).draw();
        new BlackPen(new SquareRuler()).draw();
        new BlackPen(new CircleRuler()).draw();
    }
}
```
> 结果
```shell
白⚪
白口
白▲
黑▲
黑口
黑⚪
```
客户端对各种画笔和尺子进行了相关的实例化操作，此时，客户端可以任意组装自己需要的颜色和形状进行绘图了。
