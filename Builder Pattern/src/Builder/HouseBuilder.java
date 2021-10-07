package Builder;

import Build.Builder;
import Build.Building;

/**
 * user:lufei
 * DATE:2021/10/7
 **/
public class HouseBuilder implements Builder {
    private Building house;

    public HouseBuilder() {
        house = new Building();
    }

    @Override
    public void buildBasement() {
        house.setBasement("##########\n");
    }

    @Override
    public void buildWall() {
        house.setWall("|田|田|田|\n");
    }

    @Override
    public void buildRoof() {
        house.setRoof("/-------\\\n");
    }

    @Override
    public Building getBuilding() {
        return house;
    }
}
