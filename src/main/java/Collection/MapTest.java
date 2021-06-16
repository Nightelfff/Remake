package Collection;

import org.junit.Test;

import java.util.*;

/*
*   Map:
*       HashMap:主要实现类；线程不安全，效率高；存储null
*           LinkedHashMap:遍历按添加的顺序，同LinkedHashSet
*                         适合频繁遍历
*       TreeMap:使用key排序，实现排序遍历
*               底层使用红黑树
*       HashTable:古老实现类；线程安全，效率低；不能存null
*           Properties:常用来处理配置文件，key和value都是String类型
*
*
*      HashMap的底层：数组+链表（7之前）
*                    数组+链表+红黑树（8）
*
*   面试题：
*   1.HashMap的底层实现原理？
*   2.HashMap和HashTable的异同？
*   3.CurrentHashMap和HashTable的异同？
*
*
*   二、Map结构的理解：
*       Map中的key:无序的、不可重复的，使用Set存储所有的key  --> key所在类要重写equals()和hashCode()
*       Map中的value:无序的、可重复的，使用Collection存储所有的value  --> value所在类要重写equals()
*       一个键值对:key-value构成了一个Entry对象。
*       Map中的entry:无序的、不可重复的，使用Set存储所有的entry
*
*   三、HashMap的底层实现原理
*       jdk7
*       添加同HashSet,
*       扩容为2倍
*
*       jdk8
*       1.new的时候并没有创建数组，
*       2.底层数组是：Node[],而非Entry[]
*       3.首次调用put()方法时，底层创建长度为16的数组
*       4.数组+链表+红黑树
*         链表长度>8,且当前数组长度>64时，此索引位置上的所有数据改为红黑树存储
*
*
*       DEFAULT_INITIAL_CAPACITY: HashMap的默认容量，16
*       DEFAULT_LOAD_FACTOR: HashMap的默认加载因子，0.75
*       threshold: 扩容的临界值 = 容量*加载因子  16*0.75=12
*       TREEIFY_THRESHOLD: Bucket中链表长度大于该默认值，转化为红黑树：8
*       MIN_TREEIFY_CAPACITY: 桶中的Node被树化时最小的hash表容量：64
*
*   四、LinkedHashMap的底层实现原理
*   五、Map的常用方法
*   六、TreeMap
* */
public class MapTest {

    //TreeMap
    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按key值排序
    @Test
    public void test4(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person u1 = (Person) o1;
                    Person u2 = (Person) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException("no");
            }
        });
        Person p1 = new Person("1",23);
        Person p2 = new Person("2",34);
        Person p3 = new Person("3",45);
        Person p4 = new Person("4",56);

        map.put(p1,98);
        map.put(p2,89);
        map.put(p3,76);
        map.put(p4,100);


        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+"------>"+entry.getValue());
        }


    }

    //Map的遍历
    @Test
    public void test3() {
        Map map = new HashMap();
        //添加
        map.put("aa", 123);
        map.put("qq", 89);
        map.put("bb", 956);
        //修改
        map.put("aa", 363);
        System.out.println(map);
        //遍历key
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历value
        Collection values = map.values();
        for(Object value:values){
            System.out.println(value);
        }
        //遍历key-value
        //entrySet()
        Set entrySet = map.entrySet();
//        System.out.println(entrySet);
        for(Object entry:entrySet){
            System.out.println(entry);
        }

    }

    //Map的常用方法
    @Test
    public void test2(){
        Map map = new HashMap();
        //添加
        map.put("aa",123);
        map.put("qq",89);
        map.put("bb",956);
        //修改
        map.put("aa",363);
        System.out.println(map);
        //putAll()
        Map map1 = new HashMap();
        map1.put("oo",123);
        map1.put("ll",89);
        map.putAll(map1);
        System.out.println(map);
        //remove()
        Object aa = map.remove("aa");
        System.out.println(aa);
        System.out.println(map);
        //clear()
        map1.clear();
        System.out.println(map1);
        //get()
        System.out.println(map.get("qq"));
        //containsKey()
        System.out.println(map.containsKey("qq"));
        //containsValue()
        System.out.println(map.containsValue(89));
        //isEmpty()
        System.out.println(map.isEmpty());
        //equals()

    }

    @Test
    public void test(){
//        Map map = new HashMap();
        LinkedHashMap map = new LinkedHashMap();
        map.put(null,null);
        map.put(123,"aa");
        map.put(456,"bb");
        System.out.println(map);

    }
}
