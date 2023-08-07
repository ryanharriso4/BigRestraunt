package ClientSide;

import java.awt.BorderLayout;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Items.Order;

import java.util.ArrayList;

public class Client extends JFrame {

    private String serverIP;
    private final int PORT = 9000;
    private Order order;

    private JLabel display = new JLabel();

    public Client(String ip) {

        serverIP = ip;
        order = new Order("name");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        // getContentPane().setBackground(Color.BLACK);

        // MENU

        JMenuBar menubar = new JMenuBar();

        JMenu burgers = new JMenu("Burgers");
        JMenuItem theOG = new JMenuItem("The OG");
        JMenuItem theSwiss = new JMenuItem("The Swiss");

        JMenu hotdogs = new JMenu("Hot Dogs");
        JMenuItem ballPark = new JMenuItem("The Ball Park");
        JMenuItem basicB = new JMenuItem("Basic B");

        JMenu drinks = new JMenu("Drinks");
        JMenuItem cola = new JMenuItem("Cola");
        JMenuItem water = new JMenuItem("Water");

        JMenu order = new JMenu("Order Details");
        JMenuItem viewOrder = new JMenuItem("View Order");
        JMenuItem placeOrder = new JMenuItem("Place Order");

        theOG.addActionListener(event -> onItemSelect("TheOG"));
        theSwiss.addActionListener(event -> onItemSelect("TheSwiss"));

        ballPark.addActionListener(event -> onItemSelect("BallPark"));
        basicB.addActionListener(event -> onItemSelect("BasicB"));

        cola.addActionListener(event -> onItemSelect("Cola"));
        water.addActionListener(event -> onItemSelect("Water"));

        viewOrder.addActionListener(event -> printOrder());
        placeOrder.addActionListener(event -> finishOrder());

        burgers.add(theOG);
        burgers.add(theSwiss);

        hotdogs.add(ballPark);
        hotdogs.add(basicB);

        drinks.add(cola);
        drinks.add(water);

        order.add(viewOrder);
        order.add(placeOrder);

        menubar.add(burgers);
        menubar.add(hotdogs);
        menubar.add(drinks);
        menubar.add(order);

        setJMenuBar(menubar);

        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        setVisible(true);

    }

    protected void onItemSelect(String s) {
        order.addItem(s);
    }

    protected void printOrder() {
        StringBuilder sb = new StringBuilder("<HTML><p><font size = +2> MENU </font</br></br><ol>");
        sb.append(order.printOrder());
        sb.append("</ol></HTML>");
        display.setText(sb.toString());
    }

    protected void finishOrder() {
        int button = JOptionPane.showConfirmDialog(this, "Do you want to complete your order", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (button == JOptionPane.NO_OPTION)
            return;

        Socket socket;
        try {
            socket = new Socket(serverIP, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            order.convertToJSON(out);
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        System.exit(0);

    }
}
