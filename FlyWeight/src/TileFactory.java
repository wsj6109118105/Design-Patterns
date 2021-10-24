import java.util.HashMap;
import java.util.Map;

/**
 * user:lufei
 * DATE:2021/10/24
 **/
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
