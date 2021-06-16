package thread;
/*
*
* 创建线程的方式三：实现Callable接口。---JDK5.0新增
*
* 1.call()可以有返回值
* 2.call()可以抛出异常
* 3.Callable支持泛型
*
*
* */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//1.创建Callable的实现类
class NumThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception{
        int sum = 0;
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class CallableTest {
    public static void main(String[] args){
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将对象传入FutureTask构造器中，船舰FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.创建Thread对象
        new Thread(futureTask).start();

        try {
            //6.获取call方法返回值
            //get()返回值即FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
