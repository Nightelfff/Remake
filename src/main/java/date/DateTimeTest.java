package date;

import org.junit.Test;

import java.util.Date;

/*
*
* JDK 8之前日期和时间的API测试
*
* */
public class DateTimeTest {

    /*
    * java.util.Date类
    *       java.sql.Date类
    * 1.两个构造器的使用
    *   构造器一：Date():创建一个对应当前时间的Date对象
    *   构造器二：创建制定毫秒数
    * 2.两个方法的使用
    *   toString():当前的年、月、日、时、分、秒
    *   getTime():时间戳
    *
    * 3.java.sql.Date
    *   如何实例化
    *   如何将java.util.Date对象转换为java.sql.Date对象
    * */
    @Test
    public void test2(){
        //构造器一：Date():创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Fri Jun 04 20:13:24 CST 2021

        System.out.println(date1.getTime());//1622808804774

        //构造器二：创建制定毫秒数
        Date date2 = new Date(1622808804774L);//Fri Jun 04 20:13:24 CST 2021
        System.out.println(date2);

        //java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(352153411464L);
        System.out.println(date3);//1981-02-28

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况1：
//        Date date4 = new java.sql.Date(255984984948L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况2：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }

    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //时间戳
        System.out.println(time);
    }
}
