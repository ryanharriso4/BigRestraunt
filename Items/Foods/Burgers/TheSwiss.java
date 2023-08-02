package Items.Foods.Burgers;

import Items.Foods.Food;
import Items.Toppings.*;

public class TheSwiss extends Food {
    public TheSwiss() {
        setName("The Swiss");
        addToppings(new PotatoBread());
        addToppings(new SwissCheese());
        addToppings(new AngusBeef());
        addToppings(new Mushroom());
        addToppings(new Jalapeno());
        setPrice();
    }
}