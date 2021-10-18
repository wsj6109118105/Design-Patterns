import java.util.ArrayList;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/10/18
 **/
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
