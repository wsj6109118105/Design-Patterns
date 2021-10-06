## 抽象工厂模式
抽象工厂模式（Abstract factory pattern）提供了一系列相关或者相互依赖的对象的接口。
```shell
星际战争
人类兵种与外星兵种
共分三个等级
抽象出兵种作为顶级接口
抽象出三级兵种作为各个的标准定义
人类工厂实现人类的兵种
外星工厂实现外星兵种
```
>顶级接口兵种

```java
public abstract class Unit {
    protected int attack;
    protected int defence;
    protected int health;
    protected int x;
    protected int y;

    public Unit(int attack, int defence, int health, int x, int y) {
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.x = x;
        this.y = y;
    }
    
    public abstract void show();
    
    public abstract void attack();
}
```
>三个等级的兵种

低级：
```java
public abstract class LowClassUnit extends Unit {
    public LowClassUnit(int x, int y) {
        super(5, 2, 35, x, y);
    }
}
```
中级：
```java
public abstract class MidClassUnit extends Unit {
    public MidClassUnit(int x, int y) {
        super(10, 4, 70, x, y);
    }
}
```
高级：
```java
public abstract class HighClassUnit extends Unit {
    public HighClassUnit(int x, int y) {
        super(20, 8, 140, x, y);
    }
}
```
在这级接口中已经将兵种的攻击，防御，生命定义，将具体位置留出来让工厂创建时实现
>人类兵种实现

```java
public class Marine extends LowClassUnit {
    public Marine(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("出现位置:"+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("士兵攻击："+attack);
    }
}
```
```java
public class Tank extends MidClassUnit {
    
    public Tank(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("坦克出现在："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("坦克攻击："+attack);
    }
}
```
```java
public class BattleShip extends HighClassUnit {
    
    public BattleShip(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("战舰出现："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("战舰攻击："+attack);
    }
}
```
相当于人类品牌的三个流水线，用来生产士兵用。
>外星兵种

```java
public class RoachAlien extends LowClassUnit {
    public RoachAlien(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("蟑螂出现在："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("蟑螂攻击："+attack);
    }
}
```
```java
public class PoisonAlien extends MidClassUnit {
    public PoisonAlien(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("毒液出现在："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("毒液攻击："+attack);
    }
}
```
```java
public class MammothAlien extends HighClassUnit {
    public MammothAlien(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("猛犸象出现："+x+" "+y);
    }

    @Override
    public void attack() {
        System.out.println("猛犸象攻击："+attack);
    }
}
```
相当于外星人品牌的兵种生产线。
>定义抽象工厂

```java
public interface AbstractFactory {

    LowClassUnit createLowClass();

    MidClassUnit createMidClass();

    HighClassUnit createHighClass();
}
```
抽象工厂定义了三个兵种的生产接口
>人类工厂

```java
public class PeopleFactory implements AbstractFactory {
    
    private int x;
    private int y;

    public PeopleFactory(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public LowClassUnit createLowClass() {
        return new Marine(x,y);
    }

    @Override
    public MidClassUnit createMidClass() {
        return new Tank(x,y);
    }

    @Override
    public HighClassUnit createHighClass() {
        return new BattleShip(x,y);
    }
}
```
实现抽象工厂接口，对三个兵种做了自己品牌的实现。
>外星人工厂
```java
public class AlienFactory implements AbstractFactory {
    
    private int x;
    private int y;

    public AlienFactory(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public LowClassUnit createLowClass() {
        return new RoachAlien(x,y);
    }

    @Override
    public MidClassUnit createMidClass() {
        return new PoisonAlien(x,y);
    }

    @Override
    public HighClassUnit createHighClass() {
        return new MammothAlien(x,y);
    }
}
```
实现抽象工厂接口，对三个兵种做了自己品牌的实现。

对兵种的划分，以及各个品牌的兵种的实现都已完成，接下来可以通过工厂来生产兵种了。


总结：在这个例子里，有两个不同的品牌，人类与外星人，每个品牌又有三个系列的产品，分别为三个等级的兵种，将共有的 3 个兵种抽象成顶层类，在其下实现
各个兵种的规范，此时对系列产品的定义完成，接下来生成抽象的工厂接口来给出每个工厂需要实现的 3 个产品的生产接口，创建不同的品牌去实现接口，根据规
范来实现本品牌的产品。

想要新的工厂就实现抽象接口，并根据接口实现自己的实现类，即可生产出自己品牌的产品。

![](https://note.youdao.com/yws/api/personal/file/WEBbee5ffb08382671522b7016e38948b76?method=download&shareKey=b1df4e0344299fc0938fc39567022aea)
