import java.io.*;
import java.net.*;
public class TCP_client { 
    public static void main(String[] args) throws Exception{
    	Socket socket = new Socket(InetAddress.getByName("localhost"), 5000);
        byte[] contents = new byte[10000];
        BufferedReader serverside = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
        String msg =serverside.readLine();
        outToServer.writeBytes(msg + '\n');
        FileOutputStream fos = new FileOutputStream("d:\\data1.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = socket.getInputStream();
        int bytesRead = 0; 
        while((bytesRead=is.read(contents))!=-1)
            bos.write(contents, 0, bytesRead); 
        bos.flush(); 
        socket.close(); 
        System.out.println("File saved successfully!");
    }
}