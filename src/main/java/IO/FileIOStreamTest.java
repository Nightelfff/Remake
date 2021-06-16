package IO;

/*
*
* FileInputStream()和FileOutputStream()的使用
*
* 结论：
* 1.文本文件：字符流
* 2.非文本文件，字节流
* 3.字节流可以复制文本，但不能读
*
* */
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStreamTest {

    @Test
    public void testFileInputStream() throws IOException {

        FileInputStream fis = null;
        try {
            File file = new File("hi.txt");

            fis = new FileInputStream(file);

            byte[] buffer = new byte[5];
            int len;
            while ((len=fis.read(buffer))!=-1){

                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null)
                fis.close();
        }
    }

    //图片复制
    @Test
    public void testphoto(){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File("爱情与友情.jpg");
            File destfile = new File("爱情与友情2.jpg");

            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            byte[] buffer = new byte[5];
            int len;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcfile = new File(srcPath);
            File destfile = new File(destPath);

            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            byte[] buffer = new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

        String srcPath = "hi.txt";
        String destPath = "hi3.txt";

        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
