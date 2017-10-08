import java.net.*;

public class UDP_server{

	public static void main(String[] args) throws Exception {
		
	DatagramSocket dss=new DatagramSocket(9999);
	byte[] br=new byte[1024];
	DatagramPacket dps=new DatagramPacket(br,br.length);
	dss.receive(dps);
	String str1=new String(dps.getData());
	System.out.println("server side:"+str1);
	
	InetAddress iaa=InetAddress.getLocalHost();
	String str2="this msg is from server";
	byte[]  bsn=str2.getBytes();
	DatagramPacket dpss=new DatagramPacket(bsn,bsn.length,iaa,dps.getPort());
	dss.send(dpss);
	
	
	}
}
