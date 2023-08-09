package ServerSide;

import Items.Order;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Restraunt extends JFrame {

    private JLabel display = new JLabel();
    private Queue<Order> customerQueue = new ArrayDeque<Order>();

    public Restraunt() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JMenuBar menubar = new JMenuBar();
        JMenuItem viewOrders = new JMenuItem("View Orders");
        JMenuItem bumpOrder = new JMenuItem("Bump Order");

        viewOrders.addActionListener(event -> viewCustomerOrders());
        bumpOrder.addActionListener(event -> removeOrder());

        menubar.add(viewOrders);
        menubar.add(bumpOrder);
        setJMenuBar(menubar);

        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        setVisible(true);

    }

    protected void viewCustomerOrders() {

        display.setText("Viewing customer orders");
        StringBuilder sb = new StringBuilder("<HTML><p><font size = +2> MENU </font></p><br/>");
        for (Order o : customerQueue) {
            sb.append(o.printOrder());
            sb.append("</br></br>");
            sb.append("<hr>");
        }
        sb.append("</HTML>");
        display.setText(sb.toString());
    }

    public void removeOrder() {

        JComboBox<Object> cb = new JComboBox<>(customerQueue.toArray());

        int button2 = JOptionPane.showConfirmDialog(this, cb, "Which order do you want to bump?",
                JOptionPane.OK_CANCEL_OPTION);
        if (button2 == JOptionPane.CANCEL_OPTION)
            return;
        customerQueue.remove(cb.getSelectedItem());

    }

    protected synchronized void updateOrders(Order order) {
        customerQueue.add(order);
    }
}