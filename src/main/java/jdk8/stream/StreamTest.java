package jdk8.stream;

import jdk8.lambda.Employee;
import jdk8.lambda.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算
 *
 * 2.
 * 1>Stream自己不会存储元素
 * 2>Stream不会改变源对象，而会返回一个持有结果的新Stream
 * 3>操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream执行流程
 * 1>实例化
 * 2>一系列中间操作
 * 3>终止操作
 *
 * 4.说明
 *      一个中间操作链，对数据源的数据进行处理
 *      一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 * */
public class StreamTest {

    //创建Stream

    //方式一：集合
    @Test
    public void test(){
        List<Employee> employees = EmployeeData.getEmployees();
        //顺序流
        Stream<Employee> stream = employees.stream();
        //并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //方式二：数组
    @Test
    public void test2(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1000, "jack");
        Employee e2 = new Employee(2000, "rose");
    }

    //方式三：of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //方式四：创建无限流
    @Test
    public void test4(){
        //迭代
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
