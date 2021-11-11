import PenImpl.BlackPen;
import PenImpl.WhitePen;
import RulerImpl.CircleRuler;
import RulerImpl.SquareRuler;
import RulerImpl.TriangleRuler;

/**
 * user:lufei
 * DATE:2021/11/11
 **/
public class Test {
    public static void main(String[] args) {
        new WhitePen(new CircleRuler()).draw();
        new WhitePen(new SquareRuler()).draw();
        new WhitePen(new TriangleRuler()).draw();
        new BlackPen(new TriangleRuler()).draw();
        new BlackPen(new SquareRuler()).draw();
        new BlackPen(new CircleRuler()).draw();
    }
}
