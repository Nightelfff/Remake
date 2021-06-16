package date;

import org.junit.Test;

import java.time.*;
import java.util.Date;

public class JDK8Date {

    @Test
    public void testDate(){
        //偏移量问题
        Date date = new Date(2020-1900, 9-1, 8);
        System.out.println(date);
    }

    @Test
    public void test(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():获取指定时间
        LocalDateTime of = LocalDateTime.of(2020, 10, 12, 13, 14, 15);
        System.out.println(of);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());

        //with()     修改不可变
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime1 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //plus()
        LocalDateTime localDateTime2 = localDateTime.plusMonths(4);
        LocalDateTime localDateTime3 = localDateTime.minusDays(4);
    }

    @Test
    public void test2(){
        //now()本初子午线
        Instant instant = Instant.now();
        System.out.println(instant);

        //+8hours
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //时间戳
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli() 实例化
        Instant instant1 = Instant.ofEpochMilli(1550475314878L);
        System.out.println(instant1);

    }
}
