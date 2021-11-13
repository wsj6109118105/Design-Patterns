/**
 * user:lufei
 * DATE:2021/11/13
 **/
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

    public abstract void approver(int amount);   // 抽象审批方法，具体有子类自己实现
}
