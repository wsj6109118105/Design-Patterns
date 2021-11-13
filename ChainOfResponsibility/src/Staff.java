/**
 * user:lufei
 * DATE:2021/11/13
 **/
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
