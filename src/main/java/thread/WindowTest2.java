package thread;

/*
*
* 1.问题：重票和错票？
* 2.原因：一个线程还未完成操作，另一个线程就参与，也操作车票
* 3.解决：一个线程在操作时，其他线程不能参与进来
* 4.同步
*
* 方式一：同步代码块
* synchronized（同步监视器）{
*      //需要被同步的代码
* }
* 说明：1.操作共享数据的代码：需要被同步的代码
*      2.共享数据 ：多个线程共同操作的变量
*      3.同步监视器，俗称：锁。任何一个类的对象都能充当锁
*        要求：多个线程必须要共用同一把锁。
*
* 补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
* 方式二：同步方法
*    如果操作共享数据的代码完整的声明在一个方法中，我们不妨把此方法声明同步的。
*
*
* 5.同步的方式，解决了线程的安全问题
*   操作同步代码时，是单线程，效率低
* */


class Window1 implements Runnable{

    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (Window1.class){//synchronized (obj) {
                if (ticket > 0) {

//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + "票号" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args){
        Window1 w1 = new Window1();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
