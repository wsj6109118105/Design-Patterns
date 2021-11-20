import java.util.ArrayList;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/11/20
 **/
public class Editor {
    private Doc doc;
    private List<History> historyRecords;   // 历史记录列表
    private int historyPosition = -1;     // 历史记录当前位置

    public Editor(Doc doc) {
        System.out.println("<打开文档>");
        this.doc = doc;
        historyRecords = new ArrayList<>();     // 初始化历史记录列表
        backup();     // 保存第一份历史记录
        show();     // 显示内容
    }




    public void append(String txt) {
        System.out.println("<插入操作>");
        doc.setBody(doc.getBody()+txt);
        backup();     // 保存历史记录
        show();
    }

    public void save() {
        System.out.println("<存盘操作>");
    }

    public void delete() {
        System.out.println("<删除操作>");
        doc.setBody("");
        backup();     // 保存历史记录
        show();
    }

    private void backup() {
        historyRecords.add(doc.createHistory());
        historyPosition++;
    }

    private void show() {
        System.out.println(doc.getBody());
        System.out.println("<文档结束>");
        System.out.println("===============");
    }

    public void undo() {
        System.out.println("<撤销操作>");
        if (historyPosition==0) {
            return;
        }
        historyPosition--;
        doc.restoreHistory(historyRecords.get(historyPosition));
        show();
    }
}
