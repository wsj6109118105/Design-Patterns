/**
 * user:lufei
 * DATE:2021/10/22
 **/
//此处让电视节类实现两相接口
public class TV implements DaulPin{
    public void electrify(int l,int n){
        System.out.println("火线通电"+l+",零线通电"+n);
        System.out.println("电视节打开");
    }
}
