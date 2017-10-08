import java.io.*;
import java.net.*;
public class TCP_server { 
    public static void main(String[] args)  {
       try{
    	ServerSocket ssock = new ServerSocket(5000);
        Socket socket = ssock.accept();
        BufferedReader clientside=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String rmsg=clientside.readLine();
        System.out.println("ya i have i will send:-  " + rmsg);
        String fil="d:\\"+rmsg;
        InetAddress IA = InetAddress.getByName("localhost"); 
        File file = new File(fil);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis); 
        OutputStream os = socket.getOutputStream();
        byte[] contents;
        long fileLength = file.length(); 
        System.out.print("Sending file ...");
        os.flush(); 
        socket.close();
        ssock.close();
        System.out.println("File sent succesfully!");
       	}catch(Exception e){
    	   System.out.println("Oh ho file not found/Error...!!!");
       }
    }
}