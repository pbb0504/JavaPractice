//package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend {
    public static void main(String[] args) throws Exception{
        // ͨ��DataGramSocket���󴴽�udp����
        DatagramSocket datagramSocket = new DatagramSocket();
        // ȷ�����ݣ������ݷ�װ�����ݰ���
		int time = 0;
		while(time <= 50){
			 byte[] data = "udp is coming".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length,
                InetAddress.getByName("192.168.2.124"),10000);
        // �������ݰ�
        datagramSocket.send(datagramPacket);
		time++;
		}
       
        // �ر���Դ
        //datagramSocket.close();
    }
}
