package IO;

import org.junit.Test;

import java.io.*;

/*
* 其他流的使用
* 1.标准的输入、输出流
* 2.打印流
* 3.数据流
*
* */
public class OtherStream {

    /*
    * 1.标准的输入、输出流
    * System.in
    * System.out
    *
    * 1.2
    *   setIn()/setOut()
    *
    * 大小写转化
    * */
    public static void main(String[] args) {


        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));


            while (true) {
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("over");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //3.数据流
    //用于读取或写出基本数据类型的变量或字符串
    @Test
    public void test3() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("hi.txt"));

        dos.writeUTF("666");
        dos.flush();
        dos.writeInt(6);
        dos.flush();

        dos.close();
    }
}
