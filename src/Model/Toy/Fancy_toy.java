package Model.Toy;

import Abstract.Toy;

public class Fancy_toy extends Toy {

    public Fancy_toy(String name, int popularity, int size) {
        super(name, popularity, size);
    }

    public Fancy_toy() {
        super();
        this.setName("Fancy_toy");
        this.setPopularity(6);
        this.setSize(5);
    }
}