package Builder;

import Build.Builder;
import Build.Building;

/**
 * user:lufei
 * DATE:2021/10/7
 **/
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Building setBuilding() {
        System.out.println("======工程启动=====");

        builder.buildBasement();

        builder.buildWall();

        builder.buildRoof();

        return builder.getBuilding();
    }
}
