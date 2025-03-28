package lk.ijse.gdse;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
            String message = in.readUTF();
            System.out.println(message);

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}