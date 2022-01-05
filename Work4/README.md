## 多线程

### 方法

1.**start()**:	1.启动当前线程2.调用线程中的run方法

2.**run()**:通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中

3.**currentThread()**:静态方法，返回执行当前代码的线程

4.**getName()**:获取当前线程的名字

(Thread.currentThread().getName()	获取当前线程的名字)

5.**setName()**:设置当前线程的名字

6.**yield()**:主动释放当前线程的执行权

7.**join()**:在线程中插入执行另一个线程，该线程被阻塞，直到插入执行的线程完全执行完毕以后，该线程才继续执行下去

8.**stop()**:过时方法。当执行此方法时，强制结束当前线程。

9.**sleep（long millitime）**：线程休眠一段时间

10.**isAlive()**：判断当前线程是否存活

![image-20220106033750938](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201060337380.png)

![image-20220106033813963](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201060338341.png)

### priority

```java
//getPriority
//MIN_PRIORITY: 1
//MAX_PRIORITY: 10
//NORM_PRIORITY: 5(默认)
```

### 互斥

```java
// 互斥
//synchronized
public synchronized int do(){...}
public void do(){
    ...
        synchronized{
        ...
    }
    ...
}
```

### extends Thread和implements Runnable

![image-20220106034639164](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201060346686.png)

Runnable容易出现脏数据，可使用`synchronized`避免。

### 锁

```java
//lock()   unlock()
Lock l = new ReentrantLock();//排他锁
l.lock();
...
l.unlock();
```

#### ReentrantReadWriteLock

读写锁，拥有`readLock()`, `writeLock()`

```java
ReentrantReadWriteLock lk = new ReentrantReadWriteLock();
Lock r = lk.readLock();
Lock w = lk.writeLock();
```



### 协作（等待通知）

#### wait

```java
Synchronized(ch){
    while(condition1){
        ch.wait();
    }
    while(condition2){
        ch.notify();
    }
}
```

#### await

```java
lock.lock();
condition.await();
lock.unlock();
//不需要synchronized
```

### 线程池

![image-20220106040343616](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201060403111.png)

![2](https://cdn.jsdelivr.net/gh/yocosqamaq/PicGo/img/202201060403111.png)





### 示例

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyF extends JFrame{
    int i;
    public MyF(){
        this.setBounds(200, 200, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
    }
    public void action() throws InterruptedException {
        while (true) {
                for (i = 1; i <= 7; i++)
                    try {
                        repaint();
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        if(i!=0)
            g.fillOval(50+i*10,50+i*10,100,100);
    }
}


class MyThread extends Thread{
    @Override
    public void run() {
        MyF w1 = new MyF();
        try {
            w1.action();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


public class Work4{
    public static void main(String[] argv){
        MyThread mythread =new MyThread();
        for(int i = 0;i<3;i++){
            Thread tmp = new Thread(mythread,"win"+i);
            tmp.start();
        }
    }


}

```





