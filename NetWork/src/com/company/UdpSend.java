//package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend {
    public static void main(String[] args) throws Exception{
        // 通过DataGramSocket对象创建udp服务
        DatagramSocket datagramSocket = new DatagramSocket();
        // 确定数据，将数据封装到数据包中
		int time = 0;
		while(time <= 50){
			 byte[] data = "udp is coming".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length,
                InetAddress.getByName("192.168.2.124"),10000);
        // 发送数据包
        datagramSocket.send(datagramPacket);
		time++;
		}
       
        // 关闭资源
        //datagramSocket.close();
    }
}
