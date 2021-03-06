package thread;
/*
* 创建多线程的方式二：实现Runnable接口
* 1.创建一个实现了Runnable接口的类
* 2.实现类去实现Runnable中的抽象方法：run()
* 3.创建实现类的对象
* 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
* 5.通过Thread类的对象调用start()
*
* 两种方法哪个更好
* Runnable
* 原因：1.实现的方式没有类的单继承性的局限性
*      2.实现的方式更适合来处理多个线程有共享数据的情况
*
* 联系：Thread类也实现了Runnable
*      都需要重写run()。
* */

//1.
class MThread implements Runnable{
    //2.
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args){
        //3.
        MThread mThread = new MThread();
        //4.
        Thread t1 = new Thread(mThread);
        //5.
        t1.setName("Thread 1");
        t1.start();

        Thread t2 = new Thread(mThread);
        t2.setName("Thread 2");
        t2.start();

    }
}
