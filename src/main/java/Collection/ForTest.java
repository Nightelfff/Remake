package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/*
*
* 增强for
*
* */
public class ForTest {

    @Test
    public void test(){
        Collection coll = new ArrayList();

        //add()
        coll.add("aa");
        coll.add("bb");
        coll.add(123);
        coll.add(new Date());
        coll.add(new Person("Jerry",20));

        //for(元素类型 局部变量:集合对象)
        //内部也是迭代器
        for(Object obj:coll){
            System.out.println(obj);
        }
    }
}
