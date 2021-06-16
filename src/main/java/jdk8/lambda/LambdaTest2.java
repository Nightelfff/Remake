package jdk8.lambda;


import org.junit.Test;

import java.util.function.Consumer;

/*
* java内置的4大核心函数式接口
*
* 消费型接口
* 供给型接口
* 函数型接口
* 断定型接口
*
* */
public class LambdaTest2 {

    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("666"+aDouble);
            }
        });

        System.out.println("***************");

        happyTime(400, money->System.out.println("666"+money));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }
}
