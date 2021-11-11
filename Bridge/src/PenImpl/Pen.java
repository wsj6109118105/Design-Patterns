package PenImpl;

import RulerImpl.Ruler;

/**
 * user:lufei
 * DATE:2021/11/11
 **/
public abstract class Pen {
    protected Ruler ruler;

    public Pen(Ruler ruler) {
        this.ruler = ruler;
    }

    public abstract void draw();
}
