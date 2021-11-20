## 备忘录
备忘录模式可以在不破坏元对象封装性的前提下捕获其在某些时刻的内部状态，并像历史状态一样将他们保留在元对象之外，以备
恢复之用。

> 以文档为例子

文档需要有恢复功能来保证避免潜在的错误，或失误的操作。当需要回退时，将内容换为历史快照。

> 历史快照类
```java
public class History {
    
    private String body;  // 用于备份文档

    public History(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
```
> 文档类
```java
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
```
文档类中加入了生成历史快照的功能，以及恢复历史记录。
> 编辑器类
```java
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
```
编辑器类，当对文档进行操作的时候，会生成一个快照。
> 客户端类
```java
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
```
> 输出结果
```shell
<打开文档>

<文档结束>
===============
<插入操作>
创建篇
<文档结束>
===============
<插入操作>
创建篇
 单例模式
<文档结束>
===============
<插入操作>
创建篇
 单例模式
 原型模式
<文档结束>
===============
<插入操作>
创建篇
 单例模式
 原型模式
结构篇
<文档结束>
===============
<插入操作>
创建篇
 单例模式
 原型模式
结构篇
 门面
<文档结束>
===============
<插入操作>
创建篇
 单例模式
 原型模式
结构篇
 门面
 组合
<文档结束>
===============
<删除操作>

<文档结束>
===============
<撤销操作>
创建篇
 单例模式
 原型模式
结构篇
 门面
 组合
<文档结束>
===============
```
> 各个角色定义
- 元：状态需要被记录的元对象   对应 Doc
- 备忘录：与元角色相仿，但是只要记录元角色状态    对应 History
- 看护人：历史记录的维护者，持有所有历史记录，并且提供元数据的恢复操作    对应 Editor

