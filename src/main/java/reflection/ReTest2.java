package reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReTest2 {

    //获取属性
    @Test
    public void test() throws Exception{
        Class<Person> clazz = Person.class;
        //创建对象
        Person p = clazz.newInstance();
        //获取属性(public)
//        Field age = clazz.getField("age");   //已经弃用
        //获取属性getDeclaredField()
        Field age = clazz.getDeclaredField("name");
        //可访问权限打开
        age.setAccessible(true);
        //设置属性值
        age.set(p,"lock");
        //获取
        Object o = age.get(p);
        System.out.println(o);
    }

    //获取方法
    @Test
    public void test2() throws Exception {

        Class<Person> clazz = Person.class;
        //创建对象
        Person p = clazz.newInstance();

        //1.获取指定方法
        //参数1：方法名
        //参数2：形参类型
        Method show = clazz.getDeclaredMethod("showNation", String.class);
        //可访问权限打开
        show.setAccessible(true);

        //invoke():
        //参数1,方法的调用者，参数2,实参
        //invoke()方法的返回值即原方法的返回值
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

    }

    //调用指定构造器
    @Test
    public void test3() throws Exception {
        Class<Person> clazz = Person.class;
        //1.获取指定的构造器
        //getDeclaredConstructor()参数：指明构造器的参数列表
        Constructor<Person> cons = clazz.getDeclaredConstructor(String.class);
        //2.访问权限
        cons.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        Person lock = cons.newInstance("Lock");
        System.out.println(lock);

    }

}
