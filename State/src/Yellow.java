/**
 * user:lufei
 * DATE:2021/11/16
 **/
public class Yellow implements State{

    @Override
    public void switchToGreen(TrafficLight trafficLight) {
        trafficLight.setState(new Green());
        System.out.println("OK....绿灯亮起 5 秒");
    }

    @Override
    public void switchToRed(TrafficLight trafficLight) {
        trafficLight.setState(new Red());
        System.out.println("OK....红灯亮起 5 秒");
    }

    @Override
    public void switchToYellow(TrafficLight trafficLight) {
        System.out.println("ERROR!!!黄灯不能切换为黄灯");
    }
}
