package annotation;

/*
*
* 注解的使用
* 1.理解annotation
*
* 2.annotation的使用示例
* 示例一：文档相关的注释
* 示例二：在编译时进行格式检查
*   @Override：重写
*   @Deprecated：已过时
*   @SuppressWarnings:抑制编译器警告
*
* 示例三：跟踪代码依赖性，替代配置文件
*
* 3.自定义注解
*  参照@SuppressWarnings
*
* 4.jdk 提供的4种元注解
*   元注解：注解的注解
*   @Retention:Annotation的生命周期   (SOURCE,CLASS,RUNTIME)   RUNTIME才能通过反射获取
*   @Target:限定可修饰的程序元素
*
*   @Documented:被修饰的注解在被javadoc解析时，保留下来
*   @Inherited:具有继承性
*
* 5.通过反射获取注解信息
* 6.jdk8:可重复注解，类型注解
*   6.1 可重复注解：@Repeatable
*   6.2 类型注解:
*               ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）
*               ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中
*
* */
public class Test1 {

}

@MyAnnotation("hello")
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }

}

interface Info{
    void show();
}

class Student extends Person implements Info{

    @Override
    public void walk(){
        System.out.println("学生走路");
    }

    @SuppressWarnings("unused")
    @Deprecated
    @Override
    public void show(){
        System.out.println("Info");
    }
}





