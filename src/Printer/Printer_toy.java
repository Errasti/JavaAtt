package Printer;

import Abstract.Toy;

import java.util.LinkedList;


public class Printer_toy<T extends Toy> extends Toy {
    private LinkedList<T> toys;

    public Printer_toy(LinkedList<T> toys) {
        this.toys = toys;
    }

    public Printer_toy(String name, int popularity, int size) {
        super(name, popularity, size);
    }


    public void print_linked() {
        for (Toy a :
                this.getToys()) {
            new Printer_txt(a.toString()).print();
            new Printer_txt(" ").print();
        }
    }

    public void print_toy() {
        new Printer_txt(this.toString()).print();
        new Printer_txt(" ").print();
    }


    public LinkedList<T> getToys() {
        return toys;
    }

    public void setToys(LinkedList<T> toys) {
        this.toys = toys;
    }
}