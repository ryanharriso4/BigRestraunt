package Items;

import java.util.ArrayList;

public abstract class Item {
    private String name;
    private int price = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price += price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + ": " + String.format("%.2f", ((double) price / 100)) + "\n\t");

        return sb.toString();
    }
}
