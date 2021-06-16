package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*   list:有序可重复    “动态”数组
*        ArrayList: 主要实现类，线程不安全，效率高，底层使用Object[]数组存储
*        LinkedList: 更适合频繁的插入、删除操作，底层使用双向链表存储
*        Vector: 线程安全，效率低，底层使用Object[]数组存储
*
*   问:ArrayList,LinkedList,Vector异同？
*   同:都实现了List接口, 有序可重复
*
*   ArrayList源码分析
*
*   LinkedList源码分析
*
*
*
* */
public class ListTest {

    /*
    *
    * */
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("QQ");
        list.add(new Person("Tom",22));
        list.add(789);

        System.out.println(list);

        //add(index, elm)
        list.add(1,"PP");
        System.out.println(list);

        //addAll(index, elm)
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);

        //get(index)
        System.out.println(list.get(0));

        //indexOf()
        System.out.println(list.indexOf(456));

        //lastIndexOf()
        System.out.println(list.lastIndexOf(456));

        //remove()
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //set()
        list.set(1,"cc");
        System.out.println(list);

        //subList()
        System.out.println(list.subList(2, 4));
    }

}
