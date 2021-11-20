/**
 * user:lufei
 * DATE:2021/11/20
 **/
public class Doc {

    private String title;   // 文档标题
    private String body;    // 文档内容

    public Doc(String title) {
        this.title = title;
        this.body = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public History createHistory() {
        return new History(body);     // 创建历史快照
    }

    public void restoreHistory(History history) {
        this.body = history.getBody();     // 恢复历史记录
    }
}
