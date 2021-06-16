package jdk8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似
 * 二、数组引用
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> sup1 = () -> new Employee();
	}

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> fun1 = id -> new Employee(id);
        Employee employee = fun1.apply(1001);
        System.out.println(employee);

        Function<Integer,Employee> fun2 = Employee::new;
        System.out.println(fun2.apply(1002));
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> bif1 = (id,name) -> new Employee(id,name);

        BiFunction<Integer,String,Employee> bif2 = Employee::new;
        System.out.println(bif1.apply(1000, "jack"));
        System.out.println(bif2.apply(1001, "rose"));
    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> func1 = length -> new String[length];
        Function<Integer,String[]> func2 = String[]::new;
        String[] arr1 = func1.apply(5);
        String[] arr2 = func1.apply(6);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));


    }
}
