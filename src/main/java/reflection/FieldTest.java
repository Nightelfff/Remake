package reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {

    @Test
    public void test1(){

        Class<Animals> clazz = Animals.class;
        //getFields()
        //获取当前运行时类及其父类中声明为public的属性
        Field[] fields = clazz.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        //getDeclaredFields():当前类的所有属性
        Field[] defields = clazz.getDeclaredFields();
        for(Field f:defields){
            System.out.println(f);
        }
    }
    //权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class<Animals> clazz = Animals.class;
        Field[] fields = clazz.getFields();
        for(Field f:fields){
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.println(Modifier.toString(modifier));
            //2.数据类型
            Class<?> type = f.getType();
            System.out.println(type.getName()+"\t");
            //3.变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
