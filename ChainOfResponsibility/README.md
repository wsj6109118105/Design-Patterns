## 责任链
责任链是由很多责任节点串联起来的一条任务链条，其中每一个责任节点都是一个业务处理环节。

> 适用于

一个请求的处理需要多个对象当中的一个或多个协作处理。
> 优点

请求的发送者和接受者解耦；

责任链可以动态的组合。

> 缺点

责任链过长或者处理时间过长，影响性能，

责任链可能过多。

> 一个审批流程

不同的审批人，有不同的审批职权范围，超出范围则需要向上级汇报。
直到问题解决为止。

> 审批人
```java
public abstract class Approver {

    protected String name;    // 抽象出审批人的名字

    protected Approver nextApprover;  // 下一位审批人，更高级的领导

    public Approver(String name) {
        this.name = name;
    }
    
    protected Approver setNextApprover(Approver approver) {
        nextApprover = approver;
        return nextApprover;
    }
    
    public abstract void approver();   // 抽象审批方法，具体有子类自己实现
}
```
> 财务专员
```java
public class Staff extends Approver{
    public Staff(String name) {
        super(name);
    }

    @Override
    public void approver(int amount) {
        if (amount <= 1000) {
            System.out.println(name+"审批通过");
        }else {
            System.out.println(name+"无权审批，升级处理。");
            this.nextApprover.approver(amount);
        }
    }
}
```
> 财务经理
```java
public class Manager extends Approver{

    public Manager(String name) {
        super(name);
    }

    @Override
    public void approver(int amount) {
        if (amount <= 5000) {
            System.out.println(name+"审批通过");
        }else {
            System.out.println(name+"无权审批，升级处理。");
            this.nextApprover.approver(amount);
        }
    }
}
```
> 财务总监类
```java
public class CFO extends Approver{

    public CFO(String name) {
        super(name);
    }

    @Override
    public void approver(int amount) {
        if (amount <= 10000) {
            System.out.println(name+"审批通过");
        }else {
            System.out.println(name+"驳回申请");
        }
    }
}
```
> 客户端测试
```java
public class Test {
    public static void main(String[] args) {
        ChainFactory chainFactory = new ApproverChainFactory();
        Approver approverChain = chainFactory.createApproverChain();
        approverChain.approver(1000);
        approverChain.approver(4500);
        approverChain.approver(6000);
        approverChain.approver(12000);
    }
}
```
> 结果
```shell
财务专员张飞审批通过
财务专员张飞无权审批，升级处理。
财务经理审批通过
财务专员张飞无权审批，升级处理。
财务经理无权审批，升级处理。
财务总监刘备审批通过
财务专员张飞无权审批，升级处理。
财务经理无权审批，升级处理。
财务总监刘备驳回申请
```
