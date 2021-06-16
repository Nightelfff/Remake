package String;

import org.junit.Test;

/*
* StringBuffer和StringBuilder的使用
*
* */
public class BufferBuildTest {

    /*
    *
    * StringBuffer常用方法：
    *
    */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('2');
        System.out.println(s1);
//        s1.delete(2,4);
//        System.out.println(s1);
        s1.replace(2,4,"hello");
        System.out.println(s1);
        s1.insert(2,false);//插入
        System.out.println(s1);
        s1.reverse();//反转

    }

    /*
    * String、StringBuffer、StringBuilder的异同
    * String:不可变的字符序列；底层使用char[]存储
    * StringBuffer:可变的字符序列；线程安全；效率低；底层使用char[]存储
    * StringBuilder:可变的字符序列；线程不安全；效率高；底层使用char[]存储
    *
    * 为什么可变?
    * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组
    * sb1.append('a');//value[0] = 'a';
    *
    * StringBuffer sb1 = new StringBuffer("abc");//char[] value = new char["abc".length()+16]
    * //问题1.System.out.println(sb1.length());//3
    * //问题2.扩容问题：默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中。
    *
    *       指导意义：开发中建议大家使用：StringBuffer(int capacity)或StringBuilder(int capacity)
    *
    *
    * */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'l');
        System.out.println(sb1);
        System.out.println(sb1.length());
    }
}
