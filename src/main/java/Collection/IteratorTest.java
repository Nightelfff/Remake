package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/*
*
* 集合的遍历，使用Iterator接口
*
* */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add("aa");
        coll.add("bb");
        coll.add(123);
        coll.add(new Date());
        coll.add(new Person("Jerry",20));

        Iterator iterator = coll.iterator();
        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //方式二：
//        for(int i=0;i<coll.size();i++){
//            System.out.println(iterator.next());
//        }
        //方式三：推荐
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }


    @Test
    public void Test2(){
        Collection coll = new ArrayList();

        coll.add("aa");
        coll.add("bb");
        coll.add(123);
        coll.add(new Date());
        coll.add(new Person("Jerry",20));

        //remove()
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("aa".equals(obj)){
                iterator.remove();
            }
        }
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }



}
