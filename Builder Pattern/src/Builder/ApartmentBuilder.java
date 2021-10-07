package Builder;

import Build.Builder;
import Build.Building;

/**
 * user:lufei
 * DATE:2021/10/7
 **/
public class ApartmentBuilder implements Builder {

    private Building house;

    public ApartmentBuilder() {
        house = new Building();
    }

    @Override
    public void buildBasement() {
        house.setBasement("|______|\n");
    }

    @Override
    public void buildWall() {
        house.setWall("|口口口口|\n");
        house.setWall("|口口口口|\n");
        house.setWall("|口口口口|\n");
        house.setWall("|口口口口|\n");
    }

    @Override
    public void buildRoof() {
        house.setRoof("|------|\n");
    }

    @Override
    public Building getBuilding() {
        return house;
    }
}
