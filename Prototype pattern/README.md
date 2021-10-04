## 原型模式
原型实例指定创建对象的种类，通过拷贝这些原型创建新的对象。
>适用于

1.类初始化需要消耗较多资源

2.循环体中产生大量对象的时候

>缺点

1.对象需要实现object的克隆方法

2.对于对象内部的对象也要实现克隆(深拷贝)

## 例1
其中都是简单类型，可以直接浅拷贝即可
```java
public class Student {
    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```
测试：
```java
public class StudentTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        List<Student> list = new ArrayList<>();
        for(int i = 0;i<5;i++){
            Student clone =(Student) student.clone();
            clone.setName("name"+i);
            clone.setAge(16+i);
            list.add(clone);
        }
        list.forEach(System.out::println);
    }
}
```
控制台输出：
```shell
Student{name='name0', age=16}
Student{name='name1', age=17}
Student{name='name2', age=18}
Student{name='name3', age=19}
Student{name='name4', age=20}
```
改造 Student 类，加入日期属性，使用深拷贝：
```java
public class Student implements Cloneable{
    private String name;
    private int age;
    private Date date=new Date();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();
        s.setDate((Date) this.date.clone());
        return s;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
```
修改测试类：
```java
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
```
控制台输出：
```shell
Student{name='name0', age=16, date=Tue Oct 05 00:26:04 CST 2021}
Student{name='name1', age=17, date=Tue Oct 05 00:26:06 CST 2021}
Student{name='name2', age=18, date=Tue Oct 05 00:26:08 CST 2021}
Student{name='name3', age=19, date=Tue Oct 05 00:26:10 CST 2021}
Student{name='name4', age=20, date=Tue Oct 05 00:26:12 CST 2021}
```
