package Model.Toy;

import Abstract.Toy;

public class Soft_toy extends Toy {

    public Soft_toy(String name, int popularity, int size) {
        super(name, popularity, size);
    }

    public Soft_toy() {
        super();
        this.setName("Soft_toy");
        this.setPopularity(10);
        this.setSize(7);
    }
}