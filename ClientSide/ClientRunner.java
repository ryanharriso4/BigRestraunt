package ClientSide;

import java.util.Scanner;

public class ClientRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your IP adress.");
        String input = s.nextLine();
        s.close();
        new Client(input);
    }

}
