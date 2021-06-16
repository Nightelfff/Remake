package date;

import org.junit.Test;

import java.util.Arrays;

/*
*
* 一、java对象不能直接比较大小
* 二、Comparable接口的使用            自然排序
*   String类、包装类等实现了Comparable接口，重写了compareTo()方法
* 三、Comparator                    定制排序
*
*
* */
public class CompareTest {

    @Test
    public void test1(){
        String[] arr = {"aa", "bb", "dd", "cc"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
