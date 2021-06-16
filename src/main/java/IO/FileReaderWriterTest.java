package IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *
 *
 *
 * */
public class FileReaderWriterTest {
    //读文件
    //read()返回读入的一个字符。如果达到文件末尾,返回-1
    //保证流的关闭,使用try-catch-finally
    //读入的文件必须存在
    @Test
    public void testFileReader(){
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hi.txt");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read()返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while(data!=-1){
//            System.out.print((char)data);
//            data = fr.read();
//        }
            //方式二：
            int data;
            while ((data=fr.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.关闭流
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //read()重载,一次读多个,char[]
    @Test
    public void testFileReader1(){
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hi.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            char[] cbuf = new char[5];
            int len;
            while ((len=fr.read(cbuf))!=-1){
                //错误写法
//                for(int i=0;i<cbuf.length;i++) {
//                    System.out.print(cbuf[i]);
//                }
                for(int i=0;i<len;i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.资源的关闭
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /*
    *
    * 写出
    * 说明：
    * 1.对应的文件可以不存在，输出会自动创建文件，如果存在会覆盖文件（false）
    *
    *
    * */
    @Test
    public void testFileWriter(){
        FileWriter fw = null;
        try {
            File file = new File("hi.txt");
            fw = new FileWriter(file);
            fw.write("仁慈的父\n");
            fw.write("我已坠入\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileFW(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcfile = new File("hi.txt");
            File destfile = new File("hi2.txt");

            fr = new FileReader(srcfile);
            fw = new FileWriter(destfile);

            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }





}
