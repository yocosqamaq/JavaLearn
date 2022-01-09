## 异常处理

![image-20220109225708239](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201092257567.png)

![image-20220109225720776](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201092257056.png)

![image-20220109225739801](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201092257113.png)

```java
import java.io.IOException;

public class Work5{
    public static void main(String[] args){
        byte[] b;
        double i;
        while(true){
            b = new byte[6];
            try{
                System.in.read(b);
                i=Double.parseDouble((new String(b).trim()));	//trim()去掉两端多余的空格
            }
            catch(IOException e){
                System.out.println("IO error");
            }
            catch(NumberFormatException e1){
                System.out.println("number plz");
            }
        }
    }
}
/*
1
2
a
>> number plz
*/
```

## try带资源

```java
try (Scanner scanner = new Scanner(System.in)) {...}
```

资源会在try结束后自动关闭

## 自定义异常

```java
class WrongInputException extends Exception {  // 自定义的类
    WrongInputException(String s) {
        super(s);
    }
}
class Input {
    void method() throws WrongInputException {
        throw new WrongInputException("Wrong input"); // 抛出自定义的类
    }
}
class TestInput {
    public static void main(String[] args){
        try {
            new Input().method();
        }
        catch(WrongInputException wie) {
            System.out.println(wie.getMessage());
        }
    } 
}
```

## 核心类

```java
//常用类库
java.awt
java.awt.event
javax.swing
javax.swing.event
java.applet
```

### File

![image-20220109232534733](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201092325993.png)

![image-20220109232812807](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201092328061.png)

### 序列化

需要先将类实现Seralizable接口

```
class equation implements Serializable
```

存入文件

```java
try {
    ObjectOutputStream os = new ObjectOutputStream(
        new FileOutputStream("file1.data"));
    os.writeObject(equation12);
    os.close();
    System.out.println("对象已写入file1.data文件");
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
```

读取文件

```java
try {
	ObjectInputStream is = new ObjectInputStream(
		new FileInputStream("file1.data"));
	ArrayList<StudentBean> list = new ArrayList<StudentBean>();
	list = (ArrayList<StudentBean>) is.readObject();
	for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i).toString());
	}
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
```

### Integer

![image-20220110005333207](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100053644.png)

### 泛型

![image-20220110013314636](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100133043.png)

![image-20220110013426699](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100134179.png)

![image-20220110013616968](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100136453.png)

![image-20220110013647161](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100136589.png)



### 类型擦除

如果没有指定泛型的类型，会将T设置成Object类型。

```java
class Y<T>{
    public Y(T a){
        System.out.println(a);
    }
}

public class Work5{
    public static void main(String[] args){
        Y a = new Y(10);//T为int
        Y b = new Y("yoco");//T为String
    }
}
//10
//yoco
```

### 泛型方法

![image-20220110014516113](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100145565.png)

![image-20220110014533012](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100145568.png)

### 通配符

![image-20220110014710339](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100147793.png)

![image-20220110014705913](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100147410.png)

### 有界泛型

![image-20220110014352564](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100143126.png)

![image-20220110014343062](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100143540.png)

![image-20220110014803041](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100148540.png)

### 注意

静态成员数据类型不能声明为泛型。

![image-20220110014905053](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100149529.png)

### String

![image-20220110015119416](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100151930.png)

![image-20220110015137330](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100151932.png)

![image-20220110015150589](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100151193.png)

![image-20220110015206843](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100152389.png)

![image-20220110015235229](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100152784.png)



## GUI

### JFrame

![image-20220109234505425](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201092345743.png)



### 按钮

![image-20220109235119322](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201092351583.png)

![image-20220110004922003](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100049356.png)

### 文本框

![image-20220109235137600](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201092351871.png)

### 布局管理器

`setLayout(new BorderLayout());`

#### BorderLayout

将容器分为五个区域：CENTER, NORTH, WEST, EAST, SOUTH

#### FlowLayout

![image-20220109235537071](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201092355336.png)

#### CardLayout

可使两个或更多个组件共享同一显示空间。

#### GridLayout

网格化。

`GridLayout(int rows, int cols[, int hgap, int vgap]);`

### 图形绘制

![image-20220110004955484](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201100049824.png)

### 实例总结

```java
//来自许老师
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Work5 extends JFrame implements ActionListener {
    boolean draw = false;
    private JButton jButton1 = null;
    private JButton jButton2 = null;
    private JButton jButton3 = null;
    private JButton jButton4 = null;

    public Work5(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        setBounds(500, 250, 300, 200);
        jButton1 = new JButton("按钮1");
        jButton2 = new JButton("按钮2");
        jButton3 = new JButton("按钮1");
        jButton4 = new JButton("按钮4");
        jButton3.setText("按钮3");
//        add(jButton1);
//        add(jButton2);
//        add(jButton3);
        add(jButton1, BorderLayout.NORTH);
        add(jButton2, BorderLayout.SOUTH);
        add(jButton3, BorderLayout.WEST);
        add(jButton4, BorderLayout.EAST);
        add(new JButton("按钮5"), BorderLayout.CENTER);
        add(new JButton("button6"),null);   //默认CENTER

        // 传匿名内部类
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1.setEnabled(false);
            }
        });

        // 传lambda
        jButton2.addActionListener(e -> jButton2.setEnabled(false));

        // 传lambda
        jButton3.addActionListener(e -> {
            draw = false;  // 控制是否绘图
            JFrame jFrame = new JFrame("图") {
                public void paint(Graphics g) {
                    super.paint(g);
                    g.setColor(Color.RED);
                    if (draw) {  // 防止窗口在实例化时即显示图形
                        g.drawOval(100, 100, 100, 100);
                        g.drawRect(300, 100, 100, 100);
                    }
                }
            };
            jFrame.setBounds(200, 200, 500, 300);
            jFrame.setVisible(true);
            jFrame.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    draw = true;
                    jFrame.repaint();
                }
            });
        });

        // 传本类
        jButton4.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        jButton4.setEnabled(false);
    }

    public static void main(String[] args) {
        Work5 guiDemo = new Work5("考试");
    }
}
```























