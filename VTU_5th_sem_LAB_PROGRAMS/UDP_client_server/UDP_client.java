import java.net.*;

public class UDP_client {

	public static void main(String[] args) throws Exception {
		DatagramSocket ds=new DatagramSocket();
		String h="this msg from clint";
		byte[] b=h.getBytes();
		InetAddress ia=InetAddress.getLocalHost();
		DatagramPacket dp=new DatagramPacket(b,b.length,ia,9999);
		ds.send(dp);
		
	byte[] b1=new byte[1024];
		DatagramPacket dp1=new DatagramPacket(b1,b1.length);
		ds.receive(dp1);
		String str=new String(dp1.getData());
		System.out.println("client side:"+str);
		
	}

}
