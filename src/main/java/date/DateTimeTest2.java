package date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
* 1.
*
* */
public class DateTimeTest2 {
    //SimpleDateFormat格式化和解析
    //1、格式化：日期-->字符串
    //2、解析：字符串-->日期

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化,默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析
        String str = "21-6-6 下午2:16";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //***********************
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);
    }

    /*
    * Calendar 日历类(抽象类)
    *
    * */

    @Test
    public void testCalendar(){
        //1.实例化
        //方式1.创建子类的对象
        //方式2.调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,5);
        //getTime():日历类-->Date
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime():Date-->日历类
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    }
}











