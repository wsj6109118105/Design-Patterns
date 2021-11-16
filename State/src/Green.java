/**
 * user:lufei
 * DATE:2021/11/16
 **/
public class Green implements State{

    @Override
    public void switchToGreen(TrafficLight trafficLight) {
        System.out.println("ERROR!!!绿灯不能切换为绿灯");
    }

    @Override
    public void switchToRed(TrafficLight trafficLight) {
        System.out.println("ERROR!!!绿灯不能切换为红灯");
    }

    @Override
    public void switchToYellow(TrafficLight trafficLight) {
        trafficLight.setState(new Yellow());
        System.out.println("OK....黄灯亮起 5 秒");
    }
}
