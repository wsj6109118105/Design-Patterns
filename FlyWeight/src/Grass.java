/**
 * user:lufei
 * DATE:2021/10/24
 **/
public class Grass implements Drawable{

    //草地图片素材
    private String image;

    public Grass() {
        this.image = "草地";
        System.out.println("加载"+image+",耗时 0.5 S");
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("在"+x+":"+y+"处出现图片"+image);
    }
}
