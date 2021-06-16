package Collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
* set:无序不可重复
*       HashSet:主要实现类，线程不安全，可存储null值
*           LinkedHashSet:作为HashSet的子类，遍历可以按添加顺序遍历
*           //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录前一个数据和后一个数据
            //适合频繁的遍历
*       TreeSet:可以按照添加对象的指定属性，进行排序
*
* 1.Set接口没有额外的新方法
* 2.要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
*        并且重写的hashCode()和equals()尽可能保持一致性--相等的对象必须具有相等的散列码
*
*
* */
public class SetTest {
    /*
    * 一、无序不可重复
    * 1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。
    *
    * 2.不可重复性：取决于equals()判断时，不能返回true。
    * 二、添加元素的过程：以HashSet为例：
    * 向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
    * 此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（索引位置），判断
    * 数组此位置上是否已经有元素：
    * 如果没有，添加成功
    * 如果有，则比较hash值：
    *       若hash值不相同，则元素a添加成功
    *       若hash值相同，调元素a所在类的equals方法
    *           equals()返回true,添加失败
    *           equals()返回flase,添加成功
    *
    * 七上八下
    *
    * 底层：数组+链表
    *
    * */
    @Test
    public void test(){
        Set set = new HashSet();
        set.add(456);
        set.add(321);
        set.add("pp");
        set.add("mm");
        set.add(963);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录前一个数据和后一个数据
    //适合频繁的遍历
    @Test
    public void test2(){

    }

    //TreeSet
    /*
    * 1.相同类的对象才能添加
    * 2.两种排序方式：自然排序(实现Comparable接口)和定制排序(Comparator)
    *
    * 3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals()
    * 4.自然排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals()
    * */
    @Test
    public void test3(){
        TreeSet set = new TreeSet();

        set.add(1);
        set.add(-1);
        set.add(9);
        set.add(8);
        set.add(3);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
