package IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
* RandomAccessFile的使用
* 直接继承于Object类，实现了DataInput和DataOutput接口
* 既可以输出，也可以输入
*
* 输出流会对原有文件内容进行覆盖
*
* */
public class RandomAccessFileTest {

    @Test
    public void test1(){

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("爱情与友情.jpg"), "r");
            raf2 = new RandomAccessFile(new File("爱情与友情6.jpg"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len=raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
