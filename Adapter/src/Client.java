/**
 * user:lufei
 * DATE:2021/10/22
 **/
public class Client {
    public static void main(String[] args) {
        //将电视机接入适配器，来适用三相插口
        TriplePin triplePin = new Adapter(new TV());

        triplePin.electrify(1,0,-1);

    }
}
