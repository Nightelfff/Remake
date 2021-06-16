package IO;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
*
* 网络编程
*
* 1.IP和端口号
*    InetAddress类
* 2.TCPTest/IP协议
*
* 3.通信要素
* IP是计算机的唯一标识
* InetAddress：IP类
* 4.域名
* www.baidu.com
* DNS:域名解析服务器
* 5.本地回路地址：127.0.0.1  对应着localhost
*
* 6.实例化InetAddress类, getByName(), getLocalHost()
*
* 7.端口号：16位，区分进程
*
* 8.端口号与IP地址的组合得出一个网络套接字：Socket
* */
public class InetAddressTest {

    public static void main(String[] args){
        try {
            //
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);
            //
            System.out.println(InetAddress.getLocalHost());
            System.out.println(inet2.getHostName());
            System.out.println(inet2.getAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
