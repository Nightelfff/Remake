package thread;

/*
*
* 三个窗口卖票
*
* */
class Window extends Thread{

    private static int ticket = 100;

    private static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (this){//synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(getName() + ":票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest {
    public static void main(String[] args){
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }
}
