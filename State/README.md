## 状态模式
状态模式架构出一套完备的事物内部状态转换机制，并将内部状态包裹起来，对外部不可见，使其行为能随状态的改变而改变。

> 优点

将状态转换显示化，减少对象之间的相互依赖。

状态的职责明确，有利于程序拓展。

> 缺点

增加系统的类与对象个数。

对开闭原则支持不太好。

> 以交通灯的转换为例

交通灯有三种状态，红，黄，绿。红色----> 黄色，   绿色------> 黄色，  黄色-----> 红色/绿色。

> 状态接口
```java
// 定义三种状态转换
public interface State {
    void switchToGreen(TrafficLight trafficLight);
    
    void switchToRed(TrafficLight trafficLight);
    
    void switchToYellow(TrafficLight trafficLight);
}
```
> 红灯状态
```java
public class Red implements State{

    @Override
    public void switchToGreen(TrafficLight trafficLight) {
        System.out.println("ERROR!!!红灯不能切换为绿灯");
    }

    @Override
    public void switchToRed(TrafficLight trafficLight) {
        System.out.println("ERROR!!!红灯不能切换为红等");
    }

    @Override
    public void switchToYellow(TrafficLight trafficLight) {
        trafficLight.setState(new Yellow());
        System.out.println("OK.....黄灯亮起 5 秒");
    }
}
```
> 绿灯状态
```java
public class Green implements State{

    @Override
    public void switchToGreen(TrafficLight trafficLight) {
        System.out.println("ERROR!!!绿灯不能切换为绿灯");
    }

    @Override
    public void switchToRed(TrafficLight trafficLight) {
        System.out.println("ERROR!!!绿灯不能切换为红灯");
    }

    @Override
    public void switchToYellow(TrafficLight trafficLight) {
        trafficLight.setState(new Yellow());
        System.out.println("OK....黄灯亮起 5 秒");
    }
}
```
> 黄灯状态
```java
public class Yellow implements State{

    @Override
    public void switchToGreen(TrafficLight trafficLight) {
        trafficLight.setState(new Green());
        System.out.println("OK....绿灯亮起 5 秒");
    }

    @Override
    public void switchToRed(TrafficLight trafficLight) {
        trafficLight.setState(new Red());
        System.out.println("OK....红灯亮起 5 秒");
    }

    @Override
    public void switchToYellow(TrafficLight trafficLight) {
        System.out.println("ERROR!!!黄灯不能切换为黄灯");
    }
}
```
> 交通灯
```java
public class TrafficLight {
    
    private State state = new Red();  // 初始状态为红灯
    
    public void switchToGreen() {
        state.switchToGreen(this);
    }
    
    public void switchToRed() {
        state.switchToRed(this);
    }
    
    public void switchToYellow() {
        state.switchToYellow(this);
    }

    public void setState(State state) {
        this.state = state;
    }
}
```
> 测试
```java
public class Test {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.switchToYellow();
        trafficLight.switchToYellow();
        trafficLight.switchToGreen();
        trafficLight.switchToRed();
        trafficLight.switchToYellow();
    }
}
```
> 输出结果
```shell
OK.....黄灯亮起 5 秒
ERROR!!!黄灯不能切换为黄灯
OK....绿灯亮起 5 秒
ERROR!!!绿灯不能切换为红灯
OK....黄灯亮起 5 秒
```

