package Enum;
/*
 *
 * 方式二：enum
 * */
public class SeasonTest2 {
    public static void main(String[] args){
        Season1 spring = Season1.SPRING;
        //toString()
        System.out.println(spring.toString());

        //values()
        Season1[] values = Season1.values();
        for(int i=0;i<values.length;i++){
            System.out.println(values[i]);
        }

        //valueOf(String objName):根据对象名返回枚举类对象
        Season1 spring1 = Season1.valueOf("SPRING");
        System.out.println(spring1);

    }
}


//enum定义枚举类
enum Season1{
    //1.当前枚举类的多个对象,用逗号隔开
    SPRING("春天","春暖花开"),
    SUMMER("夏天","暖花开"),
    AUTUMN("秋天","花开"),
    WINTER("冬天","开");
    //1.private final属性
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求：获取枚举类对象的属性，toString()

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}