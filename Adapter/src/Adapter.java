/**
 * user:lufei
 * DATE:2021/10/22
 **/
public class Adapter implements TriplePin{

    private DaulPin daulPin;

    //将其中接入的设备由电视机扩展为任何两相插头的设备
    public Adapter(DaulPin daulPin) {
        this.daulPin = daulPin;
    }


    //创建适配器时将需要接入的设备接入
    /*public Adapter(TV tv) {
        this.tv = tv;
    }*/

    //适配器实现目标接口
    @Override
    public void electrify(int l, int n, int e) {
        //调用被适配设备的两相通电方法，忽略底线
        //tv.electrify(l,n);
        daulPin.electrify(l,n);
    }
}
