import java.io.*;
import java.net.*;

class ChatDemo{
	public static void main(String[] args) throws Exception{
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10002);
		new Thread(new Send(sendSocket)).start();
		new Thread(new Rece(receSocket)).start();
	}
}
class Send implements Runnable{
	private DatagramSocket ds;
    Send(DatagramSocket ds){
		this.ds = ds;
	}
	public void run(){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while((line = br.readLine())!=null){
				if("886".equals(line)){
					break;
				}
				byte[] bytes = line.getBytes();
				DatagramPacket dp = 
				new DatagramPacket(bytes,bytes.length,Inet4Address.getByName("192.168.2.124"),10002);
				ds.send(dp);
			}
				
		}catch(Exception e){
			throw new RuntimeException("发送失败");
		}
	}
}

class Rece implements Runnable{
	private DatagramSocket ds;
	Rece(DatagramSocket ds){
		this.ds = ds;
	}
	public void run(){
		try{
			while(true){
				byte[] bytes = new byte[1024];
				DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(),0,dp.getLength());
				System.out.println(ip+": "+data);
			}
		}catch(Exception e){
			throw new RuntimeException("接收失败");
		}
	}
}