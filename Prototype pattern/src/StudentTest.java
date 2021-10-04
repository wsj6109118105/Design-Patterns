import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * user:lufei
 * DATE:2021/10/5
 **/
public class StudentTest {
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        Student student = new Student();
        List<Student> list = new ArrayList<>();
        for(int i = 0;i<5;i++){
            Student clone =(Student) student.clone();
            clone.setName("name"+i);
            clone.setAge(16+i);
            clone.setDate(new Date());
            list.add(clone);
            Thread.sleep(2000);
        }
        list.forEach(System.out::println);
    }
}
