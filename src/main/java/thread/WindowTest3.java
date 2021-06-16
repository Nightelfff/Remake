package thread;

/*
* 使用同步方法解决实现Runnable接口的线程安全问题
*
* */
class Window3 implements Runnable{

    private int ticket = 100;
    Object obj = new Object();



    @Override
    public void run() {
        while(ticket > 0){
           show();
        }
    }

    private synchronized void show(){
        if (ticket > 0) {
//
            System.out.println(Thread.currentThread().getName() + "票号" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args){
        Window3 w1 = new Window3();
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