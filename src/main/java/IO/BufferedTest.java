package IO;

import org.junit.Test;

import java.io.*;

/*
* 处理流之一：缓冲流的使用
*
* 1.缓冲流
* BufferedInputStream
* BufferedOutputStream
* BufferedReader
* BufferedWriter
*
* 2.作用：提供流的读取、写入的速度
*   内部缓冲区
*
*
* */
public class BufferedTest {

    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcfile = new File("爱情与友情.jpg");
            File destfile = new File("爱情与友情3.jpg");

            FileInputStream fis = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(destfile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //先关外边的
        //内层流会自动关闭


//        fos.close();
//        fis.close();

    }

}








