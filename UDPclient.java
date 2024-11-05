import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
public class UDPclient
{
    public static void main(String args[])
    {
        while(true)
        {
            try
        {
            DatagramSocket data = new DatagramSocket();

            String dataorg = "hello";

           byte[] buffer = dataorg.getBytes();

            DatagramPacket senddata = new  DatagramPacket(buffer,buffer.length,InetAddress.getByName("localhost"),9090);

            data.send(senddata);

            byte[] receivebuffer = new byte[1024];

            DatagramPacket receivepacket = new DatagramPacket(receivebuffer, receivebuffer.length);

            data.receive(receivepacket);

            String receivedata = new String(receivepacket.getData(), 0, receivepacket.getLength());

            System.out.println("Received from server: " + receivedata);
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        
    }   
}