package jdk8.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * 1.使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *
 * 2.方法引用本质上就是Lambda表达式，所以也是函数式接口的实例
 *
 * 3.使用格式： 类（或对象）:: 方法名
 *
 * 4.三种情况
 *  对象::非静态方法
 *  类::静态方法
 *  类::非静态方法
 *
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("------------------------");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("南京");

    }
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
	    Employee emp = new Employee(1001,"tom",32,5800);
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());

    }

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(1, 2));
    }
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
        Function<Double,Long> func1 = d->Math.round(d);
        System.out.println(func1.apply(3.14));

        Function<Double,Long> func2 = Math::round;
        System.out.println(func2.apply(3.54));

    }

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("a", "b"));

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abv", "abc"));

    }

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
        BiPredicate<String,String> pre1 = (s1,s2) ->s1.equals(s2);
        System.out.println(pre1.test("a", "b"));
        BiPredicate<String,String> pre2 = String::equals;
        System.out.println(pre2.test("a", "b"));
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {

        Employee emp = new Employee(1001, "tom", 23, 9000);
        Function<Employee,String> fun1 = (t) -> t.getName();

        Function<Employee,String> fun2 = Employee::getName;
        System.out.println(fun1.apply(emp));
        System.out.println(fun2.apply(emp));

    }

}
