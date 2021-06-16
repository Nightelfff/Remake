package thread;

/*
* 线程通信：使用两个线程打印1-100.线程1，线程2交替打印
*
* 三个方法
* wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
* notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个wait,就唤醒优先级最高的那个
* notifyAll():唤醒所有
*
* 说明：
* 1.三种方法都必须使用在synchronized之中
* 2.三种方法的调用者必须是同步监视器
* 3.三种方法定义在Object类之中
*
* 面试题：sleep()和wait()?
* 1.声明位置不同，Thread类///Object类
* 2.调用要求不同，任何场景///同步代码块/同步方法
* 3.是否释放监视器，不会///会
*
*
* */



class Number implements Runnable{

    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {

                notify();

                if(number<=100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    try {
                        //进入阻塞
                        //wait()会释放锁,sleep并不会
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args){
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
