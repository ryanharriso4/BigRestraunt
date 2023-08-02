package Items.Foods;

import Items.Item;
import java.util.ArrayList;
import Items.Toppings.*;

public abstract class Food extends Item {

    private ArrayList<Topping> toppings = new <Topping>ArrayList();

    public void addToppings(Topping t) {
        toppings.add(t);
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setPrice() {
        for (Topping topping : toppings) {
            super.setPrice(topping.getPrice());
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + ": " + String.format("%.2f", ((double) getPrice() / 100)) + "\n\t\t   ");
        for (Topping t : toppings) {
            sb.append(t.toString() + "\n\t\t   ");
        }

        return sb.toString();
    }
}
