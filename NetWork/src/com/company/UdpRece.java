//package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpRece {
    public static void main(String[] args) throws Exception{
        // ����udp��socket���񣬽����˵�,����һ���˿�
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        // �������ݰ������ڴ洢����
		//while(true){
			byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        // ͨ�������receive�������յ������ݴ������ݰ���
        datagramSocket.receive(datagramPacket);
        //  ͨ�����ݰ��ķ�������ȡ���е�����
        String ipadd = datagramPacket.getAddress().getHostAddress();
        String data = new String(datagramPacket.getData(),0,datagramPacket.getLength());
        int port = datagramPacket.getPort();
        System.out.println("ip: "+ipadd+"data: "+data+"port: "+port);
		//}
        
        // �ر���Դ
        //datagramSocket.close();
    }
}
