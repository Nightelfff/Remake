package generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
*
* 泛型的使用
* 1.jdk 5.0新增的特性
*
* 2.在集合中使用泛型：
*  总结：
*  ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
*  ② 在实例化集合类时，可以指明具体的泛型类型
*  ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
*    比如：add(E e)  --->实例化以后：add(Integer e)
*  ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
*  ⑤ 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
*
* 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 GenericTest1.java
*
* 4.泛型在继承方面的体现
* 类A和类B时子父类，G<A>和G<B>不是，是并列关系
*
*
* */
public class GenericTest {

    //使用泛型之前
    @Test
    public void test(){
        ArrayList list = new ArrayList();

        list.add(1);
        //类型不安全
        list.add("add");

        for(Object score:list){
            // 强转时报错
            int score1 = (Integer) score;
            System.out.println(score1);
        }
    }

    //使用泛型
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        //避免了强转
//        list.add("add");

        for(Integer score:list){
            System.out.println(score);
        }
    }

    //类A和类B时父子类，G<A>和G<B>不是，是并列关系
    //A<G>和A<G>是父子
    @Test
    public void test3(){
        List<String>  list1 = null;
        ArrayList list2 = null;
        list1 = list2;
    }

    /*
    *
    * 通配符
    * ？
    * */
    @Test
    public void test4(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        print(list1);
        print(list2);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    * 有限制条件的通配符的使用
    *
    * */
}










