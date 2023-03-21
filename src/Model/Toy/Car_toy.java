package Model.Toy;

import Abstract.Toy;

public class Car_toy extends Toy {

    public Car_toy(String name, int popularity, int size) {
        super(name, popularity, size);
    }

    public Car_toy() {
        super();
        this.setName("Car_toy");
        this.setPopularity(4);
        this.setSize(9);
    }

}