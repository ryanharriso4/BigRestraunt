package Restruant;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Items.*;

public class Client extends JFrame {
    public Client(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        getContentPane().setBackground(Color.BLACK);

        // MENU

        JMenuBar menubar = new JMenuBar();

        JMenu burgers = new JMenu("Burgers");
        JMenuItem theOG = new JMenuItem("The OG");
        JMenuItem theSwiss = new JMenuItem("The Swiss");

        JMenu hotDogs = new JMenu("Hot Dogs");
        JMenuItem ballPark = new JMenuItem("The Ball Park");
        JMenuItem basicB = new JMenuItem("Basic B");

        JMenu drinks = new JMenu("Drinks");
        JMenuItem cola = new JMenuItem("Cola");
        JMenuItem water = new JMenuItem("Water");

        theOG.addActionListener(event -> onItemSelect("OG"));
        theSwiss.addActionListener(event -> onItemSelect("Swiss"));

        ballPark.addActionListener(event -> onItemSelect("Ball Park"));
        basicB.addActionListener(event -> onItemSelect("Basic B"));

        cola.addActionListener(event -> onItemSelect("Cola"));
        water.addActionListener(event -> onItemSelect("Water"));

        burgers.add(theOG);
        burgers.add(theSwiss);

        hotDogs.add(ballPark);
        hotDogs.add(basicB);

        drinks.add(cola);
        drinks.add(water);

        menubar.add(burgers);
        menubar.add(hotDogs);
        menubar.add(drinks);

        setJMenuBar(menubar);
        setVisible(true);

    }

    protected void onItemSelect(String s) {

    }
}
