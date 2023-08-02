package Items.Foods.Burgers;

import Items.Foods.Food;
import Items.Toppings.*;

public class TheOG extends Food {
    public TheOG() {
        setName("The OG");
        addToppings(new PotatoBread());
        addToppings(new AmericanCheese());
        addToppings(new AngusBeef());
        addToppings(new Mustard());
        addToppings(new Ketchup());
        setPrice();
    }
}
