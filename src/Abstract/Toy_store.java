package Abstract;

import Model.Gamer;
import Model.Toy.Fancy_toy;
import Model.Toy.Soft_toy;
import Model.Toy.Car_toy;
import Model.Toy.Super_toy;
import Printer.Printer_txt;
import Interface.Input_user;

import java.util.*;

public abstract class Toy_store<T extends Toy> {

    private ArrayList<Integer> info_store_fancy; // ArrayList<Integer> = [price,quantity,chance_drop]
    private ArrayList<Integer> info_store_soft; // ArrayList<Integer> = [price,quantity,chance_drop]
    private ArrayList<Integer> info_store_car; // ArrayList<Integer> = [price,quantity,chance_drop]
    private ArrayList<Integer> info_store_super; // ArrayList<Integer> = [price,quantity,chance_drop]
    private LinkedList<T> fancy_toy;
    private LinkedList<T> soft_toy;
    private LinkedList<T> car_toy;
    private LinkedList<T> super_toy;
    private LinkedList<T> other;


    public Toy_store() {
        this.info_store_fancy = new ArrayList<>(Arrays.asList(0, 0, 0));
        this.info_store_soft = new ArrayList<>(Arrays.asList(0, 0, 0));
        this.info_store_car = new ArrayList<>(Arrays.asList(0, 0, 0));
        this.info_store_super = new ArrayList<>(Arrays.asList(0, 0, 0));
        this.fancy_toy = new LinkedList<>();
        this.soft_toy = new LinkedList<>();
        this.car_toy = new LinkedList<>();
        this.super_toy = new LinkedList<>();
        this.other = new LinkedList<>();
    }

    public void add_toy(T rt) {
        if (rt instanceof Fancy_toy) {
            this.getFancy_toy().add(rt);
            this.info_store_fancy.set(1, this.getFancy_toy().size());
        } else if (rt instanceof Soft_toy) {
            this.getSoft_toy().add(rt);
            this.info_store_soft.set(1, this.getSoft_toy().size());
        } else if (rt instanceof Car_toy) {
            this.getCar_toy().add(rt);
            this.info_store_car.set(1, this.getCar_toy().size());
        } else if (rt instanceof Super_toy) {
            this.getSuper_toy().add(rt);
            this.info_store_super.set(1, this.getSuper_toy().size());
        } else {
            this.getOther().add(rt);
        }
    }


    public ArrayList<Integer> search_toy_info(T toy) {
        ArrayList<Integer> toy1 = new ArrayList<>();
        if (toy instanceof Fancy_toy) {
            toy1 = this.info_store_fancy;
        } else if (toy instanceof Soft_toy) {
            toy1 = this.info_store_soft;
        } else if (toy instanceof Car_toy) {
            toy1 = this.info_store_car;
        } else if (toy instanceof Super_toy) {
            toy1 = this.info_store_super;
        }
        return toy1;
    }

    public void edit_toy_price(T toy) {
        ArrayList<Integer> search = search_toy_info(toy);
        if (search != null) {
            Input_user input_gamer = new Input_user();
            int price = 0;
            while (true) {
                new Printer_txt("Введите новую цену для игрушек: " + toy.getName()).print();
                input_gamer.get_input("Введите целое число");
                if (input_gamer.is_number()) {
                    price = Integer.parseInt(input_gamer.getInput());
                    break;
                } else {
                    new Printer_txt("Некорректный ввод").print();
                }
            }
            search.set(0, price);
        } else {
            new Printer_txt("Такой игрушки нет").print();
        }
    }

    public void edit_toy_quantity(T toy) {
        ArrayList<Integer> search = search_toy_info(toy);
        if (search != null) {
            Input_user input_gamer = new Input_user();
            int quantity = 0;
            while (true) {
                new Printer_txt("Введите новое кол-во " + toy.getName()).print();
                input_gamer.get_input("Введите целое число");
                if (input_gamer.is_number()) {
                    quantity = Integer.parseInt(input_gamer.getInput());
                    break;
                } else {
                    new Printer_txt("Некорректный ввод").print();
                }
            }
            search.set(1, quantity);
        } else {
            new Printer_txt("Такой игрушки нет").print();
        }
    }

    public void edit_toy_chance(T toy) {
        ArrayList<Integer> search = search_toy_info(toy);
        if (search != null) {
            Input_user input_gamer = new Input_user();
            int chance = 0;
            while (true) {
                new Printer_txt("Введите новую вероятность выпадения " + toy.getName()).print();
                input_gamer.get_input("Введите целое число");
                if (input_gamer.is_number_less_than_100()) {
                    chance = Integer.parseInt(input_gamer.getInput());
                    break;
                } else {
                    new Printer_txt("Вы ввели неизвестную вероятность =) ").print();
                }
            }
            search.set(2, chance);
        } else {
            new Printer_txt("Некорректный ввод").print();
        }
    }


    public abstract LinkedList<T> drawing_of_toys(Gamer<T> gamer, int bet, int user_step);

    public abstract ArrayList<Integer> generate_chance_drop(Gamer<T> gamer, Toy toy, int bet);

    public LinkedList<T> getFancy_toy() {
        return fancy_toy;
    }

    public void setFancy_toy(LinkedList<T> fancy_toy) {
        this.fancy_toy = fancy_toy;
    }

    public LinkedList<T> getSoft_toy() {
        return soft_toy;
    }

    public void setSoft_toy(LinkedList<T> soft_toy) {
        this.soft_toy = soft_toy;
    }

    public LinkedList<T> getCar_toy() {
        return car_toy;
    }

    public void setCar_toy(LinkedList<T> car_toy) {
        this.car_toy = car_toy;
    }

    public LinkedList<T> getSuper_toy() {
        return super_toy;
    }

    public void setSuper_toy(LinkedList<T> super_toy) {
        this.super_toy = super_toy;
    }

    public LinkedList<T> getOther() {
        return other;
    }

    public void setOther(LinkedList<T> other) {
        this.other = other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy_store<?> toy_store)) return false;
        return Objects.equals(getInfo_store_fancy(), toy_store.getInfo_store_fancy()) && Objects.equals(getInfo_store_soft(), toy_store.getInfo_store_soft()) && Objects.equals(getInfo_store_car(), toy_store.getInfo_store_car()) && Objects.equals(getInfo_store_super(), toy_store.getInfo_store_super()) && Objects.equals(getFancy_toy(), toy_store.getFancy_toy()) && Objects.equals(getSoft_toy(), toy_store.getSoft_toy()) && Objects.equals(getCar_toy(), toy_store.getCar_toy()) && Objects.equals(getSuper_toy(), toy_store.getSuper_toy()) && Objects.equals(getOther(), toy_store.getOther());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfo_store_fancy(), getInfo_store_soft(), getInfo_store_car(), getInfo_store_super(), getFancy_toy(), getSoft_toy(), getCar_toy(), getSuper_toy(), getOther());
    }

    @Override
    public String toString() {
        return "Toy_store{" +
                "info_store_fancy=" + info_store_fancy +
                ", info_store_soft=" + info_store_soft +
                ", info_store_car=" + info_store_car +
                ", info_store_super=" + info_store_super +
                ", fancy_toy=" + fancy_toy +
                ", soft_toy=" + soft_toy +
                ", car_toy" + car_toy +
                ", super_toy" + super_toy +
                ", other=" + other +
                '}';
    }

    public ArrayList<Integer> getInfo_store_fancy() {
        return info_store_fancy;
    }

    public void setInfo_store_fancy(ArrayList<Integer> info_store_fancy) {
        this.info_store_fancy = info_store_fancy;
    }

    public ArrayList<Integer> getInfo_store_soft() {
        return info_store_soft;
    }

    public void setInfo_store_soft(ArrayList<Integer> info_store_soft) {
        this.info_store_soft = info_store_soft;
    }

    public ArrayList<Integer> getInfo_store_car() {
        return info_store_car;
    }

    public void setInfo_store_car(ArrayList<Integer> info_store_car) {
        this.info_store_car = info_store_car;
    }

    public ArrayList<Integer> getInfo_store_super() {
        return info_store_super;
    }

    public void setInfo_store_super(ArrayList<Integer> info_store_super) {
        this.info_store_super = info_store_super;
    }
}