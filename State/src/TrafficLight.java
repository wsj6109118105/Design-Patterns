/**
 * user:lufei
 * DATE:2021/11/16
 **/
public class TrafficLight {

    private State state = new Red();  // 初始状态为红灯

    public void switchToGreen() {
        state.switchToGreen(this);
    }

    public void switchToRed() {
        state.switchToRed(this);
    }

    public void switchToYellow() {
        state.switchToYellow(this);
    }

    public void setState(State state) {
        this.state = state;
    }
}
