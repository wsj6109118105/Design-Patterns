package Build;

import java.util.ArrayList;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/10/7
 **/
public class Building {
    private List<String> components = new ArrayList<>();

    public void setBasement(String basement) {
        this.components.add(basement);
    }

    public void setWall(String wall) {
        this.components.add(wall);
    }

    public void setRoof(String roof) {
        this.components.add(roof);
    }

    @Override
    public String toString() {
        String build = "";
        for (int i = components.size()-1;i>=0;i--){
            build+=components.get(i);
        }
        return build;
    }
}
