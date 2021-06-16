package reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {

    /*
    获取构造器结构

     */
    @Test
    public void test(){
        Class<Animals> clazz = Animals.class;
        //当前类public的构造器
        Constructor<?>[] cons = clazz.getConstructors();

        for(Constructor c:cons){
            System.out.println(c);
        }

        //当前类的所有构造器
        Constructor<?>[] decons = clazz.getDeclaredConstructors();
        for(Constructor c:decons){
            System.out.println(c);
        }

    }

    //获取父类
    @Test
    public void test2(){
        Class<Animals> clazz = Animals.class;
        Class<? super Animals> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    //获取带泛型的父类
    @Test
    public void test3(){
        Class<Animals> clazz = Animals.class;
        Type superclass = clazz.getGenericSuperclass();
        System.out.println(superclass);
    }

    //获取父类的泛型
    @Test
    public void test4(){
        Class<Animals> clazz = Animals.class;
        ParameterizedType superclass = (ParameterizedType)clazz.getGenericSuperclass();
        //获取泛型类型
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);
    }

    //获取运行时类实现的接口
    @Test
    public void test5(){
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for(Class c:interfaces){
            System.out.println(c);
        }
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c:interfaces1){
            System.out.println(c);
        }
    }

    //获取运行时类的包,注解
    @Test
    public void test6(){
        Class<Person> clazz = Person.class;
        //获取运行时类的包
        Package pack = clazz.getPackage();
        System.out.println(pack);

        //获取注解
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation an:annotations){
            System.out.println(an);
        }
    }
}
