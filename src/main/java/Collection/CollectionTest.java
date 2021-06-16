package Collection;

import org.junit.Test;

import java.util.*;

/*
* 一、集合框架的概述
*
* 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器
*   说明：此时的存储，内存层面，不是持久化
*
* 2.数组存储特点：
*   > 一旦初始化，长度就确定了
*   > 一旦定义好，元素类型也确定了
*   > 有序、可重复
*   > 方法太少
*
* 二、集合框架
*       Collection:
*           list:有序可重复    “动态”数组
*               ArrayList,LinkedList,Vector
*           set:无序不可重复
*               HashSet,LinkedHashSet,TreeSet
*       Map:
*           HashMap,LinkedHashMap,TreeMap,HashTable,Properties
*
* 三、Collection接口
*
*   向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()
*
*
* */
public class CollectionTest {

    @Test
    public void test1(){
        ArrayList coll = new ArrayList();

        //add()
        coll.add("aa");
        coll.add("bb");
        coll.add(123);
        coll.add(new Date());
        coll.add(new Person("Jerry",20));

        //size()
        System.out.println(coll.size());

        //addAll()   拼接
        ArrayList coll1 = new ArrayList();
        coll1.add("cc");
        coll.addAll(coll1);
        System.out.println(coll.size());

        //clear()
//        coll.clear();

        //isEmpty()
        System.out.println(coll.isEmpty());

        //contains()是否包含
        //判断时会调用equals()方法
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new Person("Jerry",20)));

        //containsAll(Collection coll2):参数是否是子集
        Collection coll2 = Arrays.asList(123);
        System.out.println(coll.containsAll(coll2));

        //remove()
        Boolean o = coll.remove("aa");
        System.out.println(coll);

        //removeAll()       移除交集
        System.out.println(coll.removeAll(coll2));

        //retainAll()       求交集给coll2
        System.out.println(coll.retainAll(coll2));

        //equals(Object obj)
        System.out.println(coll.equals(coll1));

        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //集合--》数组
        Object[] objects = coll.toArray();
        for(int i=0;i<objects.length;i++){
            System.out.println(objects[i]);
        }

        //数组--》集合
        List<String> list = Arrays.asList(new String[]{"aa", "bb"});
        System.out.println(list);

        List ints = Arrays.asList(new int[]{12, 45});
        System.out.println(ints.size());

        List ints1 = Arrays.asList(new Integer[]{12, 45});
        System.out.println(ints1.size());

        //iterator():返回Iterator接口的实例，用于遍历集合元素

    }
}
