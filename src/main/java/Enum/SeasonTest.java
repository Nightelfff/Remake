package Enum;
/*
* 一、枚举类的使用
* 1.类的对象只有有限个，确定的。
* 2.定义一组常量
* 3.如果只有一个对象，单例模式
*
* 二、如何定义枚举类
* 方式一：jdk5.0之前
* 方式二：enum
*
* 三、Enum类常用方法
*
* 四、Enum类实现接口
* */
public class SeasonTest {
    public static void main(String[] args){
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}

//自定义枚举类
class Season{
    //1.private final属性
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3.提取当前枚举类的多个对象：public static final
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","暖花开");
    public static final Season AUTUMN = new Season("秋天","花开");
    public static final Season WINTER = new Season("冬天","开");

    //4.其他诉求：获取枚举类对象的属性，toString()

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}