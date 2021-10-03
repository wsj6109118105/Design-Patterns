/**
 * user:lufei
 * DATE:2021/10/4
 **/
public class hungrySun {
    //自带一个永久的实例
    private static final hungrySun sun = new hungrySun();
    //构造方法私有化
    private hungrySun(){

    }
    //公有方法，返回自己的唯一实例
    public static hungrySun getInstance(){
        return sun;
    }

}
