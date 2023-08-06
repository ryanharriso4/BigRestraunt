package Items;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Items.Drinks.Cola;
import Items.Drinks.Water;
import Items.Foods.Burgers.TheOG;
import Items.Foods.Burgers.TheSwiss;
import Items.Foods.HotDogs.BallPark;
import Items.Foods.HotDogs.BasicB;

public class Order {
    private String clientName;
    private ArrayList<Item> burgerList = new ArrayList();
    private ArrayList<Item> hotdogList = new ArrayList();
    private ArrayList<Item> drinkList = new ArrayList();

    public Order(String clientName) {
        this.clientName = clientName;
    }

    public void addItem(String s) {
        if (s.equals("TheOG"))
            burgerList.add(new TheOG());
        if (s.equals("TheSwiss"))
            burgerList.add(new TheSwiss());

        if (s.equals("BallPark"))
            hotdogList.add(new BallPark());
        if (s.equals("BasicB"))
            hotdogList.add(new BasicB());

        if (s.equals("Cola"))
            drinkList.add(new Cola());
        if (s.equals("Water"))
            drinkList.add(new Water());
    }

    public void convertToJSON(PrintWriter out) {
        out.println(clientName);
        out.println(burgerList.toString());
        out.println(hotdogList.toString());
        out.println(drinkList.toString());

    }

    public static Order JSONToOrder(BufferedReader in) throws IOException {
        Order order = new Order(in.readLine());
        String line;
        while ((line = in.readLine()) != null) {
            if (!line.equals("[]")) {
                line = line.replace("[", "");
                line = line.replace("]", "");
                for (String s : line.split(","))
                    order.addItem(s.trim());
            }
        }
        return order;
    }

    public String printOrder() {
        StringBuilder sb = new StringBuilder("<HTML><p><font size = +2> MENU </font</br></br><ol>");
        int itemTotal = 0;
        for (Item i : burgerList) {
            sb.append("<li>" + i.printItem().replaceAll("\n", "<br/>") + "</li>");
            itemTotal += i.getPrice();
        }
        for (Item i : hotdogList) {
            sb.append("<li>" + i.printItem().replaceAll("\n", "<br/>") + "</li>");
            itemTotal += i.getPrice();
        }
        for (Item i : drinkList) {
            sb.append("<li>" + i.printItem().replaceAll("\n", "<br/>") + "</li>");
            itemTotal += i.getPrice();
        }
        sb.append(String.format("Final Price: %.2f", (double) itemTotal / 100) + "</ol></HTML>");

        return sb.toString();
    }

}
