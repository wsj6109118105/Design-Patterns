/**
 * user:lufei
 * DATE:2021/10/24
 **/
public class Tile {

    //图块所用的材质
    private String image;

    //图块所在的坐标
    private int x,y;


    public Tile(String image, int x, int y) {
        //对图块的加载
        this.image = image;
        System.out.println("加载图片"+image+",消耗0.5 S");
        this.x = x;
        this.y = y;
    }

    public void draw(){
        System.out.println("在"+x+":"+y+"处出现图片"+image);
    }
}
