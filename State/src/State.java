/**
 * user:lufei
 * DATE:2021/11/16
 **/
public interface State {

    void switchToGreen(TrafficLight trafficLight);

    void switchToRed(TrafficLight trafficLight);

    void switchToYellow(TrafficLight trafficLight);
}
