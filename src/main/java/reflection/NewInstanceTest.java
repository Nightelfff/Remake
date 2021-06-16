package reflection;

import org.junit.Test;

import java.util.Random;

/*
* 通过反射创建运行时类对象
*
* */
public class NewInstanceTest {

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /*
        * newInstance()：创建运行时类对象，
        * 内部调用了运行时类的空参构造器
        *
        *
        * */
        Person p1 = clazz.newInstance();
        System.out.println(p1);
    }
    //反射的动态性
    @Test
    public void test2(){
        for (int i=0;i<100;i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "java.lang.String";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
