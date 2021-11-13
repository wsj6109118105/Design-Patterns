/**
 * user:lufei
 * DATE:2021/11/13
 **/
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
