/**
 * user:lufei
 * DATE:2021/10/24
 **/
public class Client {

    /*public static void main(String[] args) {
        new Tile("河流",10,10).draw();
        new Tile("河流",10,11).draw();
        new Tile("河流",10,12).draw();
        new Tile("河流",10,13).draw();
        new Tile("河流",10,14).draw();
        new Tile("河流",10,15).draw();
        new Tile("草地",11,10).draw();
        new Tile("草地",11,10).draw();
        new Tile("草地",11,10).draw();
    }*/

    public static void main(String[] args) {
        //实例化图件工厂
        TileFactory factory = new TileFactory();

        //绘制图片
        factory.getDrawable("河流").draw(10,10);
        factory.getDrawable("河流").draw(10,11);
        factory.getDrawable("河流").draw(10,12);
        factory.getDrawable("草地").draw(11,12);
        factory.getDrawable("草地").draw(12,12);
        factory.getDrawable("草地").draw(13,12);
        factory.getDrawable("道路").draw(15,12);
        factory.getDrawable("道路").draw(16,12);
        factory.getDrawable("道路").draw(19,12);
    }
}
