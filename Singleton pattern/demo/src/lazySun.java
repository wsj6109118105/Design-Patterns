/**
 * user:lufei
 * DATE:2021/10/4
 **/
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
