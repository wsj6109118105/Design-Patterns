package DynamicProxy;

/**
 * user:lufei
 * DATE:2021/11/10
 **/
public class SoupImpl implements Soup{
    @Override
    public void makeSoup(String materials) {
        System.out.println("制作"+ materials +"汤");
    }
}
