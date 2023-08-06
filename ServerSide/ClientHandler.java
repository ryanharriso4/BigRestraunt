package ServerSide;

import Items.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private Restraunt restraunt;

    public ClientHandler(Socket clientSocket, Restraunt restraunt) throws IOException {
        this.client = clientSocket;
        this.restraunt = restraunt;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            Order.JSONToOrder(in);
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
