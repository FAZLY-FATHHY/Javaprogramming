import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server
{


    public static void main(String[] args) throws IOException
    {
       try
       {
        ServerSocket socket = new ServerSocket(8081);
        System.out.println("Server is listening on port 8080");
   
   Socket clinetsocket = socket.accept();
        
       BufferedReader in = new BufferedReader(new InputStreamReader(clinetsocket.getInputStream()));

     
        String message = in.readLine(); 
        System.out.println("Received message: " + message);
       }catch(Exception e)
       {
        e.printStackTrace();
       }

}



}