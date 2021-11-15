## 策略
策略模式定义了算法家族，分别封装起来，让它们之间可以互相替换。此模式让算法的变化不会影响到使用算法的用户。策略模式
常用于消除大量的if else代码。

> 适用于

系统有很多类，他们的区别仅仅在于行为不同。

一个系统需要动态的在几种算法之间选择一种。
> 以计算器为例

对于各种计算器，都是基于两个数字型入参的运算接口。并返回结果，如此可以将算法抽离出来，使其独立于计算机，并各自封装
，使用哪种算法就接入哪个。
> 算法策略接口
```java
public interface Strategy {
    
    int calculate(int a,int b);
}
```
> 加法策略
```java
public class Addition implements Strategy{
    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}
```
> 减法策略
```java
public class Subtraction implements Strategy{
    @Override
    public int calculate(int a, int b) {
        return a-b;
    }
}
```
> 乘法策略
```java
public class multiplication implements Strategy{
    @Override
    public int calculate(int a, int b) {
        return a*b;
    }
}
```
> 计算器类
```java
public class Calculate {
    private Strategy strategy;
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public int getResult(int a,int b) {
        return strategy.calculate(a,b);
    }
}
```
> 客户端测试类
```java
public class Test {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.setStrategy(new Addition());
        System.out.println(calculate.getResult(5, 8));
        calculate.setStrategy(new Subtraction());
        System.out.println(calculate.getResult(8, 5));
        calculate.setStrategy(new multiplication());
        System.out.println(calculate.getResult(8, 5));
    }
}
```
> 结果
```shell
13
3
40
```
**策略模式让策略与系统环境彻底解耦，通过对算法策略的抽象，拆分，再拼装，接入，使系统行为的可塑性得到增强，并且将
策略的实现解放，即插即用。**
