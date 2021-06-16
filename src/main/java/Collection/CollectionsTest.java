package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Collections:操作Collection、Map的工具类
*
* 面试题：Collections和Collection的区别？
*
*
* */
public class CollectionsTest {

    @Test
    public void test(){
        List list = new ArrayList();
        list.add(123);
        list.add(56);
        list.add(321);
        list.add(789);

        System.out.println(list);
        //reverse()
        Collections.reverse(list);
        System.out.println(list);
        //shuffle()
        Collections.shuffle(list);
        System.out.println(list);
        //sort()
        Collections.sort(list);
        System.out.println(list);
        //swap()
        Collections.swap(list,1,2);
        System.out.println(list);
        //frequency()
        Collections.frequency(list,765);
        System.out.println(list);
        //copy()
        //错误写法:
//        List dest = new ArrayList();
//        Collections.copy(dest, list);
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);

        //synchronizedXxx()
        List list1 = Collections.synchronizedList(list);


    }
}
