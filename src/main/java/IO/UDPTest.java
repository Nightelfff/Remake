package IO;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
*
* UDP网络编程
*
* */
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = "UDP导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9999);

        socket.send(packet);

        socket.close();
    }

    //接收端
    @Test
    public void receiver() throws IOException {

        DatagramSocket soket = new DatagramSocket(9999);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        soket.receive(packet);
        System.out.println(new java.lang.String(packet.getData(), 0, packet.getLength()));

        soket.close();
    }

}






