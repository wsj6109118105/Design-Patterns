/**
 * user:lufei
 * DATE:2021/11/23
 **/
public abstract class Buyer {

    public String name;

    public Buyer(String name) {
        this.name = name;
    }

    public abstract void info(String product);
}
