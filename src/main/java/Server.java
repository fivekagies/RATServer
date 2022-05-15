import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args){
        try{
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();//establishes connection
            DataInputStream dis=new DataInputStream(s.getInputStream());
            String  str=(String)dis.readUTF();
            System.out.println("message= "+str);

            Thread.sleep(3000);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF("B3d mnnni ! x1");
            //dout.flush();

            Thread.sleep(2000);
            dout.writeUTF("B3d mnnni ! x2");
            //dout.flush();
            dout.close();

            ss.close();
        }catch(Exception e){System.out.println(e);}
    }
}