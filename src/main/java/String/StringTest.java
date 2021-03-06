package String;

import org.junit.Test;

/*
*
* String的使用
* 1.声明为final的，不可被继承
* 2.实现了Serializable接口：表示字符串是支持序列化的
*   实现了Comparable接口：表示String可以比较大小
* 3.内部定义了final char[] value用于存储字符串数据
* 4.不可变性
*   体现：1.当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的value进行赋值
*        2.当对现有的字符串进行连接操作时，也需要需要重新指定内存区域赋值，不能使用原有的value进行赋值
*        3.replace()....,也需要需要重新指定内存区域赋值，不能使用原有的value进行赋值
*
* 5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
* 6.字符串常量池中是不会存储相同内容的字符串的
*
* */
public class StringTest {

    /*
    * 结论：
    * 1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
    * 2.只要其中一个是变量，结果就在堆中
    *
    *
    * */
    @Test
    public void test3(){
        String s1 = "java";
        String s2 = "ccc";

        String s3 = "javaccc";
        String s4 = "java"+"ccc";
        String s5 = s1 + "ccc";
        String s6 = "java"+s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);

        String s8 = s6.intern();//在常量池
        System.out.println(s3 == s8);

    }
    /*
    * 方式一：字面量定义
    * 方式二：new+(构造器)
    *
    * */
    @Test
    public void test2(){
        //s1,s2的数据"javaee"声明在方法区的字符串常量池中
        String s1 = "javaee";
        String s2 = "javaee";
        //s3,s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaee");
        String s4 = new String("javaee");

        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);
        System.out.println(s3==s4);
    }


    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("**************************");

        String s3 = "man";
        s3 = s2 + s3;
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("**************************");

        String s4 = "man";
        String s5 = s4.replace("m","r");
        System.out.println(s4);
        System.out.println(s5);
    }


}







