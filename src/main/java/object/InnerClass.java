package object;/*
*
* 内部类
* 1.Java中允许一个类声明在另一个类中
*
* 2.分类：成员内部类 vs 局部内部类（方法内、代码块内、构造器内）
*
*
* */

public class InnerClass {

}

class Person{

    //成员内部类
    static class Man{


    }
    //非静态
    class Woman{

    }
    public void method(){
        //局部
        class AA{

        }
    }

    {
        //局部
        class BB{

        }
    }

    public Person(){
        //局部
        class CC{

        }
    }
}
