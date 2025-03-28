package lk.ijse.gdse;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client Starting....");

        // Remote Socket
        try{
            Socket socket = new Socket("localhost", 5000);

            //String message = "HI.. I am from Client";
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(message);
            out.flush();

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
