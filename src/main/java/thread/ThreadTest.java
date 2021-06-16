package thread;
/*
* 多线程的创建，方式一：继承于Thread类
* 1.创建一个继承于Thread类的子类
* 2.重写Thread类的run()
* 3.创建Thread类的子类的对象
* 4.通过此对象调用start()
*
* 例子：遍历100以内的所有的偶数
*
* */


//1.
class MyThread extends Thread{

    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args){
        //3.
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        //设置线程优先级
        t1.setPriority(Thread.MAX_PRIORITY);

        //4.
        t1.start();

        //给线程命名
        Thread.currentThread().setName("主线程");

        //?：再启动一个线程？
        //t1.start()不行
        //t2.start()

        for(int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(i+"**********");
            }
        }
    }
}
