package ClientSide;

import java.util.Scanner;

public class ClientRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your IP adress.");
        String IP = s.nextLine();
        System.out.println("Enter your first and last name");
        String clientName = s.nextLine();
        s.close();
        new Client(IP, clientName);
    }

}
