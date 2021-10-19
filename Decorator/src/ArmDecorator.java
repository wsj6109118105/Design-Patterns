/**
 * user:lufei
 * DATE:2021/10/19
 **/
public class ArmDecorator implements Person{

    private Person person;

    public ArmDecorator(Person person) {
        this.person = person;
    }

    @Override
    public String show() {
        return "手拿武器的"+person.show();
    }
}
