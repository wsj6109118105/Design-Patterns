## 组合模式
将对象组合成树形结构以表示“部分-整体”的层次结构，使客户端对单个对象和组合对象保持一致的方式处理。

可以提取并抽象相同部分，特殊化其不同部分。提高可复用性与可拓展性。

适用于：  
1.可以忽略组合对象与单个对象的差异  
2.处理树型结构

> 优点

1.层次清晰；

2.客户端不必关注层次差异，方便控制；

3.符合开闭原则

**以文件系统目录结构为例**

> 抽象节点类，模糊文件夹和文件
```java
public abstract class Node {

    protected String name;

    public Node(String name) {
        this.name = name;
    }

    protected abstract void add(Node node);

    protected void tree(int space){
        for(int i=0;i<space;i++){
            System.out.println(" ");
        }
        System.out.println(name);
    }
}
```
其中设置了添加方法和打印方法，可以让具体的类具体实现。
> 文件夹类：继承了抽象节点，并且定义了一个次级节点列表
```java
public class Folder extends Node{

    private List<Node> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    protected void add(Node node) {
        children.add(node);
    }

    public void tree(int space){
        super.tree(space);

        space++;
        for(Node node : children){
            node.tree(space);
        }
    }
}
```
文件夹类中定义了子节点结合，并且实现了添加方法，再打印方法中先调用抽象类中的打印方法，打印自己的名字，再循环打印子节点的名字。
> 文件类：继承抽象节点
```java
public class File extends Node{

    public File(String name) {
        super(name);
    }

    @Override
    protected void add(Node node) {
        System.out.println("不能添加子节点");
    }

    public void tree(int space){
        super.tree(space);
    }
}
```
文件类没有子节点，不对添加节点方法进行实现，打印只需要打印自己的名字，调用抽象类的方法即可
> 客户端
```java
public class Client {
    public static void main(String[] args) {
        Node drive = new Folder("D盘");

        Node doc = new Folder("2021年");

        doc.add(new File("简历.doc"));

        doc.add(new File("项目介绍：组合模式"));

        drive.add(doc);

        Node music = new Folder("本地音乐");

        music.add(new File("此生不换.mp3"));

        music.add(new File("霍元甲.mp3"));

        music.add(new File("告别地球.mp3"));

        drive.add(music);

        drive.tree(4);
    }
}
```
可见只需要持有跟目录D盘就可以延伸出整个目录
```shell
    D盘
     2021年
      简历.doc
      项目介绍：组合模式
     本地音乐
      此生不换.mp3
      霍元甲.mp3
      告别地球.mp3
```

在组合模式中，作为最高层级的抽象节点类(接口)泛化了所有的节点类，使得任何"整体"或"部分"达成统一。枝叶的实现以及组合关系进一步勾勒出树型结构。
