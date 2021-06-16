package jdk8.stream;


import jdk8.lambda.Employee;
import jdk8.lambda.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 终止操作
 *
 * */
public class StreamTest2 {

    //1.匹配与查找
    @Test
    public void test(){
        //allMatch()
        List<Employee> employees = EmployeeData.getEmployees();
        System.out.println(employees.stream().allMatch(e -> e.getAge() > 18));
        //anyMatch()
        System.out.println(employees.stream().anyMatch(e -> e.getSalary() > 10000));
        //noneMatch()
        System.out.println(employees.stream().noneMatch(e -> e.getSalary() > 10000));
        //findFirst()
        System.out.println(employees.stream().findFirst());
        //findAny()
        System.out.println(employees.stream().findAny());
        //count()
        System.out.println(employees.stream().filter(e -> e.getSalary() > 10000).count());
        //max()
        System.out.println(employees.stream().map(e->e.getSalary()).max(Double::compare));
        //min()
        System.out.println(employees.stream().min((e1,e2) ->Double.compare(e1.getSalary(),e2.getSalary())));
        //foreach()
        employees.stream().forEach(System.out::println);
    }

    //归约
    @Test
    public void test2(){
        //reduce
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 78, 9, 0);
        System.out.println(list.stream().reduce(0, Integer::sum));

        //reduce(BinaryOperator)
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> stream = employees.stream().map(Employee::getSalary);
        System.out.println(stream.reduce(Double::sum));
    }

    //收集
    @Test
    public void test3(){
        List<Employee> employees = EmployeeData.getEmployees();

        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 7000).collect(Collectors.toList());

        employeeList.forEach(System.out::println);
    }
}
