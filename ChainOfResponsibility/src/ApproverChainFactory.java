/**
 * user:lufei
 * DATE:2021/11/13
 **/
public class ApproverChainFactory implements ChainFactory{
    @Override
    public Approver createApproverChain() {
        Approver approver = new Staff("财务专员张飞");
        approver.setNextApprover(new Manager("财务经理")).setNextApprover(new CFO("财务总监刘备"));
        return approver;
    }
}
