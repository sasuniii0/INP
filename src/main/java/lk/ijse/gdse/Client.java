package lk.ijse.gdse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client Starting....");

        // Remote Socket
        try {
            Socket socket = new Socket("localhost", 5000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            //String message = "HI.. I am from Client";
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Client : ");
                String message = sc.nextLine();
                out.writeUTF(message);
                out.flush();

                if (message.equalsIgnoreCase("bye")) {
                    break;
                }
                String receivedMessage = in.readUTF();
                System.out.println("Server : " + receivedMessage);

                if (receivedMessage.equalsIgnoreCase("bye")) {
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
