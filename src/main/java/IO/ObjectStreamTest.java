package IO;


import org.junit.Test;

import java.io.*;

/*
*
* 序列化
* 对象序列化机制
*
* 对象流的使用
*
*
*
* */
public class ObjectStreamTest {

    /*
    * 序列化：将内存中的Java对象保存到磁盘中或通过网络传输出去
    * 使用ObjectOutputStream实现
    *
    * */
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.txt"));

            oos.writeObject(new String("对象流"));

            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //反序列化：还原为Java对象
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.txt"));

            String obj = (String) ois.readObject();
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}


















