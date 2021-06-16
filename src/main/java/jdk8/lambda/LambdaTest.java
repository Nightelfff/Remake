package jdk8.lambda;

import org.junit.Test;

import java.util.Comparator;

/*
*
* Lambda表达式
*
* */
public class LambdaTest {

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

    @Test
    public void test2(){
        //Lambda表达式
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        int compare2 = com2.compare(32,21);
        System.out.println(compare2);

        System.out.println("---------------");
        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(32,21);
        System.out.println(compare3);

    }
}
