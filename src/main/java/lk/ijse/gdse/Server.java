package lk.ijse.gdse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){

        try {
            //Server Socket
            System.out.println("Server Starting....");
            ServerSocket serverSocket = new ServerSocket(5000);

            //local Socket
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            while (true) {
                //Message
                String message = in.readUTF();
                System.out.println("Client : " + message);

                //Response
                if (message.equalsIgnoreCase("bye")) {
                    break;
                }

                System.out.println("Server : ");
                message = sc.nextLine();
                out.writeUTF(message);
                out.flush();

                if (message.equalsIgnoreCase("bye")) {
                    break;
                }
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}