import java.net.*;
import java.io.*;
class UdpSend2{
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket();
		
		BufferedReader br = new BufferedReader(
		new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine())!=null){
			if("886".equals(line)){
				break;
			}
			byte[] bytes = line.getBytes();
			DatagramPacket dp = new DatagramPacket(
			bytes,bytes.length,Inet4Address.getByName
			("192.168.2.124"),10001);
			ds.send(dp);
		}
		ds.close();
	}
}

class UdpRece2{
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(10001);
		while(true){
			byte[] bytes = new byte[1024];
			DatagramPacket dp = new DatagramPacket(
			bytes,bytes.length);
			ds.receive(dp);
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(),0,dp.getLength());
			System.out.println(ip+": "+data);
		}
		
	}
}