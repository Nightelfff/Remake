package thread;

import java.util.concurrent.locks.ReentrantLock;

/*
*
*
* 解决线程安全问题的方式三：Lock锁
*
* 1.synchronized与lock的异同
*   synchronized机制在执行完相应的同步代码块以后，自动的释放同步监视器
*   Lock需要手动的启动同步（Lock()）,同时结束同步也需要手动的实现（unlock()）
*
* */
class newWindow implements Runnable{

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try{

                lock.lock();
                if(ticket>0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"票号为:"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}

public class DeadLock {
    public static void main(String[] args){
        newWindow w = new newWindow();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

























