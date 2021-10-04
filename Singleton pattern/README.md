## 单例模式
顾名思义，即一个类只有一个实例。

**优点：**

- 只有一个实例减少了内存开销。

- 严格控制访问。

- 避免对资源的多重占用。
### 饿汉式
直接进行实例化，在需要时返回给调用者。缺点：上来不管三七二十一直接实例化，占用不必要的内存。
```java
public class hungrySun {
    //自带一个永久的实例
    private static final hungrySun sun = new hungrySun();
    //构造方法私有化
    private hungrySun(){

    }
    //公有方法，返回自己的唯一实例
    public static hungrySun getInstance(){
        return sun;
    }

}
```
### 懒汉式
在需要使用到时才进行实例化，但是不是线程安全的。
```java
public class lazySun {
    //初始并不实例化
    private static lazySun lazySun;
    //构造方法私有化，禁止其他类调用
    private lazySun(){

    }
    //在需要时判断是否存在，不存在构造，但是存在问题，如果两个线程同时调用则可能出错
    public static lazySun getInstance(){
        if(lazySun==null){
            lazySun = new lazySun();
        }
        return lazySun;
    }
}
```
### 懒汉式(改)
1.使用了 volatile 关键字来修饰，禁止指令重排，防止线程获得空对象，报空指针异常。
2.没有对方法进行加锁，以及进行两次判断，防止线程每次每次调用都要获取锁阻塞。
```java
public class safeLazySun {
    //使用 volatile 关键字保证可见性，以及禁止指令重排，防止线程获取到空的对象
    private volatile static safeLazySun sun;
    //构造方法私有化
    private safeLazySun(){

    }

    public static safeLazySun getInstance(){
        //判断
        if(sun==null){
            //加锁，保证只有一个实例，在这里加锁，在之后则不会每次都需要加锁
            synchronized(safeLazySun.class){
                if (sun==null){
                    sun = new safeLazySun();
                }
            }
        }
        return sun;
    }
}
```
### 静态内部类
```java
public class StaticInnerClass {

    private StaticInnerClass(){

    }

    private static class Inner{
        private static StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    public StaticInnerClass getInstance(){
        return Inner.staticInnerClass;
    }
}
```
