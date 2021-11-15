/**
 * user:lufei
 * DATE:2021/11/15
 **/
public class Calculate {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int getResult(int a,int b) {
        return strategy.calculate(a,b);
    }
}
