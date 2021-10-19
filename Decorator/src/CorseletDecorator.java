/**
 * user:lufei
 * DATE:2021/10/19
 **/
public class CorseletDecorator implements Person{

    private Person person;

    public CorseletDecorator(Person person) {
        this.person = person;
    }

    @Override
    public String show() {
        return "身披战甲"+person.show();
    }
}
