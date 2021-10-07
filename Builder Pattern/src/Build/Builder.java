package Build;


/**
 * user:lufei
 * DATE:2021/10/7
 **/
public interface Builder {
    void buildBasement();

    void buildWall();

    void buildRoof();

    Building getBuilding();
}
