package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
*
* 动态代理举例
*
* */
interface Human{
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("I eat "+food);
    }
}

class HumanUtil{

    public void method1(){
        System.out.println("--------------通用方法一--------------");
    }

    public void method2(){
        System.out.println("--------------通用方法二--------------");
    }
}
/*
* 1.根据加载到内存中的被代理类，动态的创建一个代理类及其对象
* 2.动态调用被代理类的同名方法
*
* */
class ProxyFactory{

    public static Object getProxyInstance(Object obj){
        //obj 被代理对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//被代理对象初始化

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util = new HumanUtil();
        util.method1();

        //method()即为代理类对象调用的方法，也是被代理类要调用的方法

        Object returnVal = method.invoke(obj, args);

        util.method2();
        //代理类对象方法的返回值就作为当前类的invoke()的返回值
        return returnVal;
    }
}


public class DynamicProxyTest {
    public static void main(String[] args){

        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类对象
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("火锅");


        System.out.println("****************************");
        //静态变动态
        Nike nike = new Nike();
        ClothFactory proxyInstance1 = (ClothFactory)ProxyFactory.getProxyInstance(nike);
        proxyInstance1.produceCloth();

    }
}
