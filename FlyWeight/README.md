## 享元模式
提供了减少对象数量从而改善应用所需的对象结构的方式，运用共享技术有效地支持大量细粒度的对象。
> 适用于

系统内存在大量对象，并且这些对象具有相同的内部状态。

> 优点

减少对象创建，降低内存占用。
> 缺点

1.关注内外状态，关注线程安全。

2.程序逻辑复杂。

> 示例

在游戏中有各种地貌，如：河流，草地，沙漠，山川，房屋，道路，围墙，等等。如果直接加载整张地图，那么加载速度会比较慢，而且灵活性也会大打折扣，
但是，可以发现整张游戏地图都是由一个个小的单元格组成。

> 图块类
```java
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
```
> 客户端类
```java
public class Client {

    public static void main(String[] args) {
        new Tile("河流",10,10).draw();
        new Tile("河流",10,11).draw();
        new Tile("河流",10,12).draw();
        new Tile("河流",10,13).draw();
        new Tile("河流",10,14).draw();
        new Tile("河流",10,15).draw();
        new Tile("草地",11,10).draw();
        new Tile("草地",11,10).draw();
        new Tile("草地",11,10).draw();
    }
}
```
> 加载图片过程
```shell
加载图片河流,消耗0.5 S
在10:10处出现图片河流
加载图片河流,消耗0.5 S
在10:11处出现图片河流
加载图片河流,消耗0.5 S
在10:12处出现图片河流
加载图片河流,消耗0.5 S
在10:13处出现图片河流
加载图片河流,消耗0.5 S
在10:14处出现图片河流
加载图片河流,消耗0.5 S
在10:15处出现图片河流
加载图片草地,消耗0.5 S
在11:10处出现图片草地
加载图片草地,消耗0.5 S
在11:10处出现图片草地
加载图片草地,消耗0.5 S
在11:10处出现图片草地
```
可以看到，加载图片耗时非常大，每一张图片都需要消耗事件，即使是相同的图片。

**使用享元模式优化**
> 绘图接口
```java
public interface Drawable {
    
    //绘图方法，接收坐标
    void draw(int x,int y);   
}
```
> 河流类
```java
public class River implements Drawable{
    
    //河流图片素材
    private String image;

    public River() {
        this.image = "河流";
        System.out.println("加载"+image+",耗时 0.5 S");
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("在"+x+":"+y+"处出现图片"+image);
    }
}
```
> 草地类
```java
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
```
> 道路类
```java
public class Stone implements Drawable{
    
    //道路图片素材
    private String image;

    public Stone() {
        this.image = "道路";
        System.out.println("加载"+image+",耗时 0.5 S");
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("在"+x+":"+y+"处出现图片"+image);
    }
}
```
> 图件工厂类(关键)
```java
public class TileFactory {
    
    //图库
    private Map<String,Drawable> images;

    public TileFactory() {
        images = new HashMap<String,Drawable>();
    }
    
    public Drawable getDrawable(String image){
        //缓存池中如果没有图片，则实例化并且放入缓存中
        if(!images.containsKey(image)){
            switch (image){
                case "河流":  
                    images.put(image,new River());
                    break;
                case "草地":  
                    images.put(image,new Grass());
                    break;
                case "道路":   
                    images.put(image,new Stone());    
            }
        }
        //至此，缓存池里已经有了图片，可以直接取得并返回。
        return images.get(image);
    }
}
```
> 客户端
```java
public class Client {

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
```
> 加载过程
```shell
加载河流,耗时 0.5 S
在10:10处出现图片河流
在10:11处出现图片河流
在10:12处出现图片河流
加载草地,耗时 0.5 S
在11:12处出现图片草地
在12:12处出现图片草地
在13:12处出现图片草地
加载道路,耗时 0.5 S
在15:12处出现图片道路
在16:12处出现图片道路
在19:12处出现图片道路
```
可以看到加载需要时间大大减少。
> 总结

这里通过享元模式将图片的内蕴状态”图片“维护起来，将外蕴状态”坐标“抽离出来，并定义在接口参数中。这是享元工厂就可以将图件对象共享，供外部使用。
