import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPserver
{
    public static void main(String[] args)
    {
   while(true)
   {
     try
    {
        DatagramSocket data = new DatagramSocket(9090);

        byte[] buffer = new byte[256];

        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
        data.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength());

        System.out.println("Received message: " + received);

        String senddata = "heelo from server";
        byte[] buffer2 = senddata.getBytes();

     DatagramPacket senddata2 = new DatagramPacket(buffer2,buffer2.length,packet.getAddress(),packet.getPort());
     data.send(senddata2);

    }

    catch(Exception e)
        {
            System.out.println(e);
        }

    }
   }
        
 
}