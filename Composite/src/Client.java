import java.util.ArrayList;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/10/18
 **/
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
