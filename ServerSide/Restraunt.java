package ServerSide;

import Items.Order;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Restraunt extends JFrame {

    private JLabel display = new JLabel();
    private Queue<Order> customerQueue = new ArrayDeque<Order>();

    public Restraunt() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JMenuBar menubar = new JMenuBar();
        JMenuItem viewOrders = new JMenuItem("View Orders");

        viewOrders.addActionListener(event -> viewCustomerOrders());

        menubar.add(viewOrders);
        setJMenuBar(menubar);

        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        setVisible(true);

    }

    protected void viewCustomerOrders() {
        display.setText("Viewing customer orders");
        for (Order o : customerQueue) {
            display.setText(o.printOrder());
        }
    }

    protected void updateOrders(Order order) {
        customerQueue.add(order);
    }
}