/**
 * user:lufei
 * DATE:2021/10/18
 **/
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
