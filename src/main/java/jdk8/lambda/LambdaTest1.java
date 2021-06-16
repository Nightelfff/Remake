package jdk8.lambda;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/*
*
* Lambda表达式的使用
*
* 1.格式
*   ->:Lambda操作符/箭头操作符
*   ->:左：lambda形参列表
*   ->:右：lambda体
*
* 2.Lambda表达式的本质：作为接口的实例---------》函数式接口：只声明了一个抽象方法
*
* 3.总结
*   左：参数类型可省略,一个时  ()  可省略
*   右：{}，一句时  return  可省略
*
* */
public class LambdaTest1 {

    //格式一：无参，无返回值
    @Test
    public void test(){

        Runnable r1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("666");
            }
        };

        r1.run();
        System.out.println("-----------------");

        Runnable r2 = () -> System.out.println("777");
        r2.run();
    }

    //格式二：单参数，无返回值
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("???");

        System.out.println("**************");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("777");
    }

    //格式三：数据类型可以省略
    @Test
    public void test3() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("???");

        System.out.println("**************");

        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("777");
    }

    @Test
    public void test4() {
        ArrayList<String> list = new ArrayList<>();

        int[] arr = {1,2,3};
    }

    //格式四：单参数可省略小括号
    @Test
    public void test5(){
        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("777");
    }

    //格式五：多参数，多执行语句，有返回值
    @Test
    public void test6(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println("****************");
        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12, 90));
    }

    //格式六:Lambda体只有一条语句时，return与大括号都可以省略
    @Test
    public void test7(){
        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(12, 27));
    }


}
