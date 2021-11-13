/**
 * user:lufei
 * DATE:2021/11/13
 **/
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
