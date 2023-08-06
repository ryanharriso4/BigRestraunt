package ServerSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 9000;
    private static ArrayList<ClientHandler> clients = new ArrayList();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        Restraunt restraunt = new Restraunt();

        ServerSocket listener = new ServerSocket(PORT);

        while (true) {
            System.out.println("[SERVER] Waiting for client connection...");
            Socket client = listener.accept();
            System.out.println("[SERVER] Connected to client!");
            ClientHandler clientThread = new ClientHandler(client, restraunt);
            clients.add(clientThread);

            pool.execute(clientThread);
        }
    }
}
