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

}
