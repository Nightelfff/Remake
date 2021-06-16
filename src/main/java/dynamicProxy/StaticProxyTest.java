package dynamicProxy;

/*
*
* 静态代理
*
* 特点：代理类和被代理类在编译时就确定下来了
*
* */
interface ClothFactory{

    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代理类对象初始化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂。。。");

        factory.produceCloth();

        System.out.println("代理后续工作");
    }
}

class Nike implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike生产");

    }
}

public class StaticProxyTest {
    public static void main(String[] args){
        //创建被代理类的对象
        Nike nike = new Nike();
        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}
