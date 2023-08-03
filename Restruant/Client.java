package Restruant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Items.Item;
import Items.Drinks.Cola;
import Items.Drinks.Water;
import Items.Foods.Burgers.*;
import Items.Foods.HotDogs.*;

import java.util.ArrayList;

public class Client extends JFrame {

    private ArrayList<Item> burgerList = new ArrayList();
    private ArrayList<Item> hotdogList = new ArrayList();
    private ArrayList<Item> drinkList = new ArrayList();

    JLabel display = new JLabel();

    public Client(String title) {
        super(title);
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

        JMenuItem viewOrder = new JMenuItem("View Order");

        theOG.addActionListener(event -> onItemSelect("OG"));
        theSwiss.addActionListener(event -> onItemSelect("Swiss"));

        ballPark.addActionListener(event -> onItemSelect("Ball Park"));
        basicB.addActionListener(event -> onItemSelect("Basic B"));

        cola.addActionListener(event -> onItemSelect("Cola"));
        water.addActionListener(event -> onItemSelect("Water"));

        viewOrder.addActionListener(event -> printOrder());

        burgers.add(theOG);
        burgers.add(theSwiss);

        hotdogs.add(ballPark);
        hotdogs.add(basicB);

        drinks.add(cola);
        drinks.add(water);

        menubar.add(burgers);
        menubar.add(hotdogs);
        menubar.add(drinks);
        menubar.add(viewOrder);

        setJMenuBar(menubar);

        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        setVisible(true);

    }

    protected void onItemSelect(String s) {
        if (s.equals("OG"))
            burgerList.add(new TheOG());
        if (s.equals("Swiss"))
            burgerList.add(new TheSwiss());

        if (s.equals("Ball Park"))
            hotdogList.add(new BallPark());
        if (s.equals("Basic B"))
            hotdogList.add(new BasicB());

        if (s.equals("Cola"))
            drinkList.add(new Cola());
        if (s.equals("Water"))
            drinkList.add(new Water());
    }

    protected void printOrder() {
        StringBuilder sb = new StringBuilder("<HTML><p><font size = +2> MENU </font</br></br><ol>");
        for (Item i : burgerList) {
            sb.append("<li>" + i.toString().replaceAll("\n", "<br/>") + "</li>");
        }
        for (Item i : hotdogList) {
            sb.append("<li>" + i.toString().replaceAll("\n", "<br/>") + "</li>");
        }
        for (Item i : drinkList) {
            sb.append("<li>" + i.toString().replaceAll("\n", "<br/>") + "</li>");
        }
        sb.append("</ol></HTML>");
        display.setText(sb.toString());

    }
}
