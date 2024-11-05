import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class client
{
    public static void main(String[] args) throws IOException
    {
        Socket s = new Socket("localhost", 8081);
        
        PrintWriter client = new PrintWriter(s.getOutputStream(), true);
        
        Scanner sc = new Scanner(System.in);
        
        

    }

}