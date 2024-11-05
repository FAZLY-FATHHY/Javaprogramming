
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class UDP2client{
//    public static void main(String[] args) {
//        DatagramSocket socket = null;
//        try{
//            socket = new DatagramSocket();
//
//           String message = "Hello World";
//           byte[] buffer = message.getBytes();
//
//            DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getByName("localhost"),8080);
//            socket.send(packet);
//            byte[] receiveData = new byte[1024];
//            DatagramPacket recpacket = new DatagramPacket(receiveData,receiveData.length);
//            socket.receive(recpacket);
//            String msg = new String(recpacket.getData(),0,recpacket.getLength());
//            System.out.println("FResponse "+msg);
//        }catch (Exception e){
//            System.out.println("Error: " + e.getMessage());
//            ;
//        }finally {
//            if(socket != null && !socket.isClosed()){
//                socket.close();
//            }
//        }
//    }
public static void main(String[] args) {
    DatagramSocket socket = null;
    try{
        socket = new DatagramSocket();
        socket.setSoTimeout(3000);

        String message = "Hello World";
        byte[] buffer = message.getBytes();

        DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getByName("localhost"),8080);

        int attempts = 0;
        boolean response = false;
        while (attempts < 3 && !response) {
            socket.send(packet);
            System.out.println("Sent to server "+ message);

            byte[] receiveData = new byte[1024];
            DatagramPacket recpacket = new DatagramPacket(receiveData,receiveData.length);

            try{
                socket.receive(recpacket);
                String msg = new String(recpacket.getData(),0,recpacket.getLength());
                System.out.println("FResponse "+msg);
                response = true;


            }catch(SocketTimeoutException e){
                attempts++;
                System.out.println("No response from server, retrying (" + attempts + "/3)...");
            }

        }
        if(!response){
            System.out.println("No response from server after 3 attempts");
        }


    }catch (Exception e){
        System.out.println("Error: " + e.getMessage());
        ;
    }finally {
        if(socket != null && !socket.isClosed()){
            socket.close();
        }
    }
}

}