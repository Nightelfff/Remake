package generic;
//如何自定义泛型结构：泛型类、泛型接口；泛型方法


import org.junit.Test;

import java.util.List;

public class GenericTest1 {

    @Test
    public void test(){
        //如果定义了泛性类，实例化没有指明，认为Object类型
        //建议在实例化时带上泛型
        Order order = new Order();
        order.setT(123);
        order.setT("ace");

        Order<Integer> order1 = new Order<Integer>("1", 2, 3);

        order1.setT(6);
        System.out.println(order1);
    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //
        sub1.setT(1122);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setT("order2");

    }

    //测试泛型方法
    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值
        //静态方法不能使用类的泛型
        //泛型方法可以定义为静态的
        Order<String> order = new Order<>();
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> list = order.copy(arr);
        System.out.println(list);
    }


}
