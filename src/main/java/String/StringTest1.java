package String;

import org.junit.Test;

import java.util.Arrays;

/*
*
* String类与其他结构的转换
*
* */
public class StringTest1 {



    /*
    * String与byte[]之间的转换
    *   String --> char[]:getBytes()
    *   byte[] --> String:调String的构造器
    *
    * 编码：
    * 解码：
    *
    * */
    @Test
    public void test3(){
        String str1 = "abc123楚留香";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));

        String str2 = new String(bytes);
        System.out.println(str2);

    }


    /*
    * String与char[]之间的转换
    *
    * String --> char[]:toCharArray()
    * char[] --> String:调String的构造器
     *
    * */
    @Test
    public void test2(){
        java.lang.String str1 = "abc123";

        char[] chars = str1.toCharArray();
        for (int i = 0;i<chars.length;i++){
            System.out.println(chars[i]);
        }
        char[] arr = new char[]{'j', 'a', 'v', 'a'};
        String str2 = new String(arr);
        System.out.println(str2);

    }

    /*
    * String -->基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
    * 基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
    *
    * */
    @Test
    public void test1(){
        String str1 = "123";
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);
        System.out.println(num);
        String str2 = String.valueOf(num);
        System.out.println(str2);
    }
}
