package jdk8.stream;

import jdk8.lambda.Employee;
import jdk8.lambda.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * 中间操作
 *
 *
 * */
public class StreamTest1 {
    //筛选与切片
    @Test
    public void test1(){
        //filter()
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        stream.filter(e->e.getSalary()>7000).forEach(System.out::println);
        //limit() 截断流
        list.stream().limit(3).forEach(System.out::println);
        //skip() 跳过
        list.stream().skip(3).forEach(System.out::println);
        //distinct() 筛选,去重
        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa", "b", "c", "dd");
        //map()
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);
        //flatMap()
        //类似于addAll()
    }

    //排序
    @Test
    public void test3(){
        //sorted()    自然排序
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 7);
        list.stream().sorted().forEach(System.out::println);
        //sorted(Comparator com)  定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);
    }
}
