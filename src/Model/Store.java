package Model;

import Abstract.Toy;
import Abstract.Toy_store;
import Model.Toy.Car_toy;
import Model.Toy.Fancy_toy;
import Model.Toy.Soft_toy;
import Model.Toy.Super_toy;
import Printer.Printer_txt;
import Interface.Txt_data;

import java.util.*;

public class Store<T extends Toy> extends Toy_store {

    private HashSet<Integer> chance_drop;

    public Store() {
        super();
    }


    @Override  // розыгрыш
    public LinkedList<T> drawing_of_toys(Gamer gamer, int bet, int step_user) {
        LinkedList<T> temp = new LinkedList<>();
        ArrayList<Integer> cats_big_boss = generate_chance_drop(gamer, new Fancy_toy(), bet);
        ArrayList<Integer> mila_bear = generate_chance_drop(gamer, new Soft_toy(), bet);
        ArrayList<Integer> snake_losk = generate_chance_drop(gamer, new Car_toy(), bet);
        ArrayList<Integer> giraffe_iron = generate_chance_drop(gamer, new Super_toy(), bet);
        HashSet<Integer> cats = generate_chance_random(cats_big_boss);
        HashSet<Integer> mila = generate_chance_random(mila_bear);
        HashSet<Integer> snake = generate_chance_random(snake_losk);
        HashSet<Integer> giraffe = generate_chance_random(giraffe_iron);
        if (cats.contains(step_user)) {
            new Printer_txt(new Txt_data().getYou_win()).print();
            temp.add((T) this.getFancy_toy().peekFirst());

            this.getInfo_store_fancy().set(1, cats_big_boss.get(1) - 1);
        } else if (mila.contains(step_user)) {
            new Printer_txt(new Txt_data().getYou_win()).print();
            temp.add((T) this.getSoft_toy().peekFirst());

            this.getInfo_store_soft().set(1, mila_bear.get(1) - 1);
        }
        if (snake.contains(step_user)) {
            new Printer_txt(new Txt_data().getYou_win()).print();
            temp.add((T) this.getCar_toy().peekFirst());
            this.getInfo_store_car().set(1, snake_losk.get(1) - 1);
        } else if (giraffe.contains(step_user)) {
            new Printer_txt(new Txt_data().getYou_win()).print();
            temp.add((T) this.getSuper_toy().peekFirst());

            this.getInfo_store_super().set(1, giraffe_iron.get(1) - 1);
        }
        return temp;
    }

    /**
     * генерация иного шанса выпадения, зависящая от ставки и удачи пользователя, но основывающаяся на игзначальном шансе установленным магазином.
     *
     * @param gamer игрок, для получения его удачи
     * @param toy   - игрушка , для получения шанса установленного магазином
     * @param bet   - ставка игрока, для реализации ее влияния на шанс выпадения.
     * @return новые "временные" шансы выпадения игрушки (действуют одну ставку).
     */
    @Override
    public ArrayList<Integer> generate_chance_drop(Gamer gamer, Toy toy, int bet) {
        ArrayList<Integer> temp = this.search_toy_info(toy);
        int pont = 0;
        ArrayList<Integer> new_chance = new ArrayList<>(Arrays.asList(temp.get(0), temp.get(1), temp.get(2)));
        if (gamer.getLuck() == 0 || new_chance.get(2) <= 0) {
            new_chance.set(2, 0);
        } else if (gamer.getLuck() == 100) {
            new_chance.set(2, 75);
        } else {
            pont = (new_chance.get(2) + (gamer.getLuck() + bet / 2) / 10) * 2; //решил пока без логорифмов
            if (pont > 75) {
                new_chance.set(2, 75);
            } else {
                new_chance.set(2, pont);
            }
        }
        return new_chance;
    }


    public HashSet<Integer> generate_chance_random(ArrayList<Integer> data) {
        HashSet<Integer> chance_toy = new HashSet<>();
        Random rnd = new Random();
        while (chance_toy.size() <= data.get(2)) {
            int temp = rnd.nextInt(1, 101);
            chance_toy.add(temp);
        }
        return chance_toy;
    }


    public void generate_toys() {
        Fancy_toy cat1 = new Fancy_toy();
        Fancy_toy cat2 = new Fancy_toy();
        Fancy_toy cat3 = new Fancy_toy();
        Soft_toy mila1 = new Soft_toy();
        Soft_toy mila2 = new Soft_toy();
        Soft_toy mila3 = new Soft_toy();
        Car_toy snake1 = new Car_toy();
        Car_toy snake2 = new Car_toy();
        Car_toy snake3 = new Car_toy();
        Car_toy snake4 = new Car_toy();
        Car_toy snake5 = new Car_toy();
        Super_toy giraffe1 = new Super_toy();
        Super_toy giraffe2 = new Super_toy();
        this.add_toy(cat1);
        this.edit_toy_price(cat1);
        this.edit_toy_quantity(cat2);
        this.edit_toy_chance(cat1);
        this.add_toy(cat2);
        this.add_toy(cat3);
        this.add_toy(mila1);
        this.edit_toy_price(mila1);
        this.edit_toy_quantity(mila2);
        this.edit_toy_chance(mila3);
        this.add_toy(mila2);
        this.add_toy(mila3);
        this.add_toy(snake1);
        this.edit_toy_price(snake1);
        this.edit_toy_quantity(snake2);
        this.edit_toy_chance(snake5);
        this.add_toy(snake2);
        this.add_toy(snake3);
        this.add_toy(snake4);
        this.add_toy(snake5);
        this.add_toy(giraffe1);
        this.edit_toy_price(giraffe1);
        this.edit_toy_quantity(giraffe1);
        this.edit_toy_chance(giraffe2);
        this.add_toy(giraffe2);
    }


    public HashSet<Integer> getChance_drop() {
        return chance_drop;
    }

    public void setChance_drop(HashSet<Integer> chance_drop) {
        this.chance_drop = chance_drop;
    }


}