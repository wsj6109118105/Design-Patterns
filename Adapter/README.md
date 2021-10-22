## 适配器
适配器模式通常也被称为转换器模式，顾名思义，是进行适应与匹配工作的。
> 适用

已有的类与接口不匹配
> 优点

1.客户端与接口解耦  
2.提高了组件的可复用性
> 缺点

1.可能增加系统的复杂性。

2.降低代码可读性。

> 现有一个三相的插口
```java
public interface TriplePin {
    
    void electrify(int l,int n,int e);
}
```
分别为火线，零线，底线。
> 又有一个电视机
```java
public class TV {
    public void electrify(int l,int n){
        System.out.println("火线通电"+l+",零线通电"+n);
        System.out.println("电视节打开");
    }
}
```
电视机的插头是两相的。无法与已有的插座相匹配。
> 适配器
```java
public class Adapter implements TriplePin{
    
    private TV tv;
    
    //创建适配器时将需要接入的设备接入
    public Adapter(TV tv) {
        this.tv = tv;
    }
    
    //适配器实现目标接口
    @Override
    public void electrify(int l, int n, int e) {
        //调用被适配设备的两相通电方法，忽略底线
        tv.electrify(l,n);
    }
}
```
> 客户端
```java
public class Client {
    public static void main(String[] args) {
        //将电视机接入适配器，来适用三相插口
        TriplePin triplePin = new Adapter(new TV());
        
        triplePin.electrify(1,0,-1);
        
    }
}
```
> 输出
```shell
火线通电1,零线通电0
电视节打开
```
这样就实现了一个将电视机的亮相插口适配到三相接口的适配器，但这个适配器只能用与电视机，无法用与其他的两相插头设备，现在改写。
> 两相接口
```java
public interface DaulPin {
    
    void electrify(int l,int n);
}
```
> 修改电视机类
```java
//此处让电视节类实现两相接口
public class TV implements DaulPin{
    public void electrify(int l,int n){
        System.out.println("火线通电"+l+",零线通电"+n);
        System.out.println("电视节打开");
    }
}
```
> 修改适配类
```java
public class Adapter implements TriplePin{

    private DaulPin daulPin;
    
    //将其中接入的设备由电视机扩展为任何两相插头的设备
    public Adapter(DaulPin daulPin) {
        this.daulPin = daulPin;
    }


    //创建适配器时将需要接入的设备接入
    /*public Adapter(TV tv) {
        this.tv = tv;
    }*/

    //适配器实现目标接口
    @Override
    public void electrify(int l, int n, int e) {
        //调用被适配设备的两相通电方法，忽略底线
        //tv.electrify(l,n);
        daulPin.electrify(l,n);
    }
}
```
好了，现在只要是实现了两相接口的设备，都可以适用适配器来适配三相的插口了。
