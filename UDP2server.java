
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP2Server{
    public static void main(String[] args)  {

        DatagramSocket socket = null;
        try{
            socket = new DatagramSocket(8080);
            byte[] buffer = new byte[256];

            System.out.println("Server is waitiing for clinet packet");

            while(true){
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length);

                socket.receive(packet);
                String recieved  = new String(packet.getData(),0, packet.getLength());
                System.out.println("From client "+recieved);

                Thread.sleep(10000);

                String response  = "Hello ";
                byte[] reponseData = response.getBytes();

                DatagramPacket responsePacket = new DatagramPacket(reponseData,reponseData.length,packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
                System.out.println("Response sent to client ");
            }

        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                System.out.println("Server closed");
            }
        }

    }
}