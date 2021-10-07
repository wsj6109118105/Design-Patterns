import Builder.ApartmentBuilder;
import Builder.Director;
import Builder.HouseBuilder;

/**
 * user:lufei
 * DATE:2021/10/7
 **/
public class Test {
    public static void main(String[] args) {
        Director director = new Director(new HouseBuilder());
        System.out.println(director.setBuilding());
        director.setBuilder(new ApartmentBuilder());
        System.out.println(director.setBuilding());
    }
}
