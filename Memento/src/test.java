/**
 * user:lufei
 * DATE:2021/11/20
 **/
public class test {
    public static void main(String[] args) {
        Editor editor = new Editor(new Doc("设计模式"));

        editor.append("创建篇");
        editor.append("\n 单例模式");
        editor.append("\n 原型模式");
        editor.append("\n结构篇");
        editor.append("\n 门面");
        editor.append("\n 组合");
        editor.delete();
        editor.undo();
    }
}
