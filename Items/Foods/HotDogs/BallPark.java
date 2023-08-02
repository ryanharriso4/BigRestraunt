package Items.Foods.HotDogs;

import Items.Foods.Food;
import Items.Toppings.*;

public class BallPark extends Food {
    public BallPark() {
        setName("Ball Park");
        addToppings(new PotatoBread());
        addToppings(new Relish());
        addToppings(new Hotlink());
        addToppings(new Ketchup());
        addToppings(new Mustard());
        setPrice();
    }
}
