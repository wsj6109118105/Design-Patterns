/**
 * user:lufei
 * DATE:2021/10/5
 **/
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
