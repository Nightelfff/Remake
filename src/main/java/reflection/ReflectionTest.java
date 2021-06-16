package reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    //反射之前
    @Test
    public void test1(){

        //1.创建Person类的对象
        Person p1 = new Person("Tom", 23);

        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构
        //比如:name、showNation()以及私有的构造器
    }

    @Test
    public void test2() throws Exception {
        //1.通过反射，创建Person类的对象
        Class<Person> clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("jack", 78);
        Person p = (Person) obj;
        System.out.println(obj.toString());
        //2.通过反射，调用对象指定的属性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射，可以调用Person类的私有结构
        //私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("rose");
        System.out.println(p1);
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"safagg");
        System.out.println(p1);
        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object o = showNation.invoke(p1, "中国");
        System.out.println(o);

    }
    //疑问：怎么创建对象？
    //直接new
    //动态再用反射

    //疑问：是否破环了封装性？
    //没有，

    /*
    * 关于java.lang.Class类的理解
    * 1.类的加载过程：
    * 程序经过javac.exe命令以后，会产生一个或多个字节码文件(.class结尾)
    * 接着我们使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件
    * 加载到内存中。此过程就称为类的加载。加载到内存中的类称为运行时类，此运行时类，
    * 就作为Class的一个实例。
    *
    * */

    //获取Class的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象: getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方法三：Class的静态方法：forName()
        Class clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);
        //方法四：使用类的加载器：Classloader   (了解 )
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("java.lang.String");
        System.out.println(clazz4);


    }
}
