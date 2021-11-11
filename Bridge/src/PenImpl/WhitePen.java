package PenImpl;

import RulerImpl.Ruler;

/**
 * user:lufei
 * DATE:2021/11/11
 **/
public class WhitePen extends Pen{
    public WhitePen(Ruler ruler) {
        super(ruler);
    }

    @Override
    public void draw() {
        System.out.print("白");
        ruler.regularize();
    }
}
