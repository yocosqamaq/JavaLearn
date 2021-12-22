## easy java ui 
> ui+自定义异常+序列化写入

## 序列化

需要先将类实现Seralizable接口

```java
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

https://blog.csdn.net/github_37130188/article/details/94589960

## ui设计

idea创建.form文件

对界面进行设计

![image-20211222121112827](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202112221211880.png)

![image-20211222121101502](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202112221211577.png)

此时会自动生成变量

![image-20211222121142548](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202112221211592.png)

```java
//button按钮活动监听
QGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    QGAction();
                } catch (AWrongException e) {
                    e.printStackTrace();
                }
            }
        });

```

https://blog.csdn.net/mistyrain0109/article/details/53843134

https://www.runoob.com/w3cnote/java-swing-demo-intro.html

https://www.cnblogs.com/datacenter/p/11528749.html

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

https://www.runoob.com/java/exception-user.html
