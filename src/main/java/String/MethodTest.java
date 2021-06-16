package String;

import org.junit.Test;

public class MethodTest {

    @Test
    public void test2(){
        String s1 = "Hello1World";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));//是否相等
        System.out.println(s1.equalsIgnoreCase(s2));//忽略大小写
        System.out.println(s1.concat(s2));//拼接
        System.out.println(s1.compareTo(s2));//比较大小
        System.out.println(s1.substring(2,5));//截取
        System.out.println(s1.endsWith("ld"));//是否以...结尾
        System.out.println(s1.startsWith("l",2));//从2开始
        System.out.println(s1.contains("or"));//是否包含“”
        System.out.println(s1.indexOf("or"));//包含，索引
        System.out.println(s1.lastIndexOf("or"));//最后一次出现
        System.out.println(s1.lastIndexOf("or",7));//最后一次出现
        System.out.println(s1.replace("Hello","fuck"));
        System.out.println(s1.replaceAll("\\d+",","));//数字换成,
        System.out.println(s1.matches("\\d+"));
        System.out.println(s1.split("1"));
    }

    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());

        String s2 = "    hello    ";
        System.out.println(s2.trim());




    }
}
