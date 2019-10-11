//package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpRece {
    public static void main(String[] args) throws Exception{
        // 创建udp的socket服务，建立端点,监听一个端口
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        // 定义数据包，用于存储数据
		//while(true){
			byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        // 通过服务的receive方法将收到的数据存入数据包中
        datagramSocket.receive(datagramPacket);
        //  通过数据包的方法，获取其中的数据
        String ipadd = datagramPacket.getAddress().getHostAddress();
        String data = new String(datagramPacket.getData(),0,datagramPacket.getLength());
        int port = datagramPacket.getPort();
        System.out.println("ip: "+ipadd+"data: "+data+"port: "+port);
		//}
        
        // 关闭资源
        //datagramSocket.close();
    }
}
