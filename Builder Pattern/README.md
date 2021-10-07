## 建造者模式
建造者模式所构造的对象是庞大而复杂，且按照既定工序将组件组装起来的。通常将负责构建这些大型对象的工程师称为建造者。建造者模式又成为生成器模式。

>适用于：

- 复杂对象的构建
- 想将复杂对象的创建和使用分离

> 优点：

- 封装性好，创建和分离
- 拓展性好，建造类之间独立，一定程度上解耦

> 缺点:

-产品内部发生变化，建造者需要更改，成本较大。
> 本次例子以建筑物的构建为例

建筑物的构建相当复杂，这里简化为由地基，墙体，屋顶三部分构成，将三部分组装即是一个房子。

>建筑物类
```java
public class Building {
    private List<String> components = new ArrayList<>();
    
    public void setBasement(String basement) {
        this.components.add(basement);
    }
    
    public void setWall(String wall) {
        this.components.add(wall);
    }
    
    public void setRoof(String roof) {
        this.components.add(roof);
    }

    @Override
    public String toString() {
        String build = "";
        for (int i = components.size()-1;i>=0;i++){
            build+=components.get(i);
        }
        return build;
    }
}
```
定义建筑的组装。
>建造者接口
```java
public interface Builder {
    void buildBasement();

    void buildWall();

    void buildRoof();

    Building getBuilding();
}
```
定义建造者需要建造出地基，墙体，屋顶，以及返回建筑。
>别墅施工方
```java
public class HouseBuilder implements Builder {
    private Building house;

    @Override
    public void buildBasement() {
        house.setBasement("#######");
    }

    @Override
    public void buildWall() {
        house.setWall("|田|田|田|");
    }

    @Override
    public void buildRoof() {
        house.setRoof("/-----\\");
    }

    @Override
    public Building getBuilding() {
        return house;
    }
}
```
>公寓施工方
```java
public class ApartmentBuilder implements Builder {
    
    private Building house;

    @Override
    public void buildBasement() {
        house.setBasement("|______|");
    }

    @Override
    public void buildWall() {
        house.setWall("|口口口口|");
    }

    @Override
    public void buildRoof() {
        house.setRoof("|------|");
    }

    @Override
    public Building getBuilding() {
        return house;
    }
}
```
两个施工方分别建造建筑所需要的部件，并将建造好的建筑返回
>工厂流程控制
```java
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
    
    public Building setBuilding() {
        System.out.println("======工程启动=====");
        //打地基
        builder.buildBasement();
        //建造墙壁
        builder.buildWall();
        //建造屋顶
        builder.buildRoof();
        
        return builder.getBuilding();
    }
}
```
一位建造工程师来控制两个建造队的建造流程，最后返回建造好的建筑。

**总结：** 在这个例子中，建造工程师 Director 和施工方 ApartmentBuilder，HouseBuilder 构成了建造者一方，建筑物类 Building 包括了建筑物的部件组装
方法，建筑接口 Builder 定义了各个部件实现的接口，和最后返回的接口。最后在建造工程师的流程控制下，施工方根据建筑个部件的实现接口建造部件并进行组装，最后得到
一个完整的建造
