package IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/*
* File类的使用
*
* 1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
* 2. File类声明在java.io包下
* 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
*    并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
* 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".
*
* */
public class FileTest {
    /*
    1.如何创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)

    2.
    相对路径：相较于某个路径下，指明的路径。
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
     windows:\\
     unix:/
     */
    @Test
    public void test1(){
        //构造器1
        File file = new File("hello.txt");//相对于当前目录

        //构造器2
        File file1 = new File("D:\\sds", "sdsd");

        //构造器3
        File file2 = new File(file1, "hi.txt");
    }

    //File常用方法
    @Test
    public void test2(){

        File file = new File("hello.txt");
        File file1 = new File("e:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        File file2 = new File("E:\\c\\test\\test");
        String[] list = file2.list();
        for(String s:list){
            System.out.println(s);
        }

        File[] files = file2.listFiles();
        for(File f:files){
            System.out.println(f);
        }
    }


    //file1存在file2不存在才能成功
    @Test
    public void test3(){
        File file1 = new File("asd.txt");
        File file2 = new File("E:\\c\\test\\test\\asd.txt");

        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }

    //常用方法测试
    @Test
    public void test4(){
        File file = new File("E:\\c\\test\\test\\asd.txt");

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }

    /*
    创建硬盘中对应的文件或文件目录
public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建

    删除磁盘中的文件或文件目录
public boolean delete()：删除文件或者文件夹
    删除注意事项：Java中的删除不走回收站。

     */
    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }


    }
    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("d:\\io\\io1\\io3");

        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("d:\\io\\io1\\io4");

        boolean mkdir1 = file2.mkdirs();
        if(mkdir1){
            System.out.println("创建成功2");
        }
        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("D:\\io\\io1\\io4");
        file3 = new File("D:\\io\\io1");
        System.out.println(file3.delete());
    }
}
