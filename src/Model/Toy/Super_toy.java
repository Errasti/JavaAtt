
package Model.Toy;

import Abstract.Toy;

public class Super_toy extends Toy {

    public Super_toy() {
        super();
        this.setName("Super_toy");
        this.setPopularity(8);
        this.setSize(10);
    }

    public Super_toy(String name, int popularity, int size) {
        super(name, popularity, size);
    }
}