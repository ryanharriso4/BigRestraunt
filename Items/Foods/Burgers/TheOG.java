package Items.Foods.Burgers;

import Items.Foods.Food;
import Items.Toppings.*;

public class TheOG extends Food {
    public TheOG() {
        setName("TheOG");
        addToppings(new PotatoBread());
        addToppings(new AmericanCheese());
        addToppings(new AngusBeef());
        addToppings(new Mustard());
        addToppings(new Ketchup());
        setPrice();
    }
}
