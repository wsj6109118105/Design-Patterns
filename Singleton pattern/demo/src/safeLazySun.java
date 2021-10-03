/**
 * user:lufei
 * DATE:2021/10/4
 **/
public class safeLazySun {
    //使用 volatile 关键字保证可见性，以及禁止指令重排，防止线程获取到空的对象
    private volatile static safeLazySun sun;
    //构造方法私有化
    private safeLazySun(){

    }

    public static safeLazySun getInstance(){
        //判断
        if(sun==null){
            //加锁，保证只有一个实例，在这里加锁，在之后则不会每次都需要加锁
            synchronized(safeLazySun.class){
                if (sun==null){
                    sun = new safeLazySun();
                }
            }
        }
        return sun;
    }
}
