package Model;

import Abstract.Human;
import Abstract.Toy;
import Printer.Printer_txt;
import Interface.Input_user;

import java.util.LinkedList;
import java.util.Objects;


public class Gamer<T extends Toy> extends Human {
    private LinkedList<T> won;
    private boolean step;

    public Gamer(String name, int luck, int money) {
        super(name, luck, money);
        this.setWon(new LinkedList<T>());
    }

    public Gamer() {
        super();
        this.setWon(new LinkedList<>());
    }

    public LinkedList<T> getWon() {
        return won;
    }

    public void setWon(LinkedList<T> won) {
        this.won = won;
    }


    public void full_data_user() {
        Input_user i_am_new_user = new Input_user();
        while (true) {
            i_am_new_user.get_input("Как вас зовут?");
            this.setName(i_am_new_user.getInput());
            i_am_new_user.get_input("Введите стартовый баланс: ");
            if (i_am_new_user.is_number()) {
                this.setMoney(Integer.parseInt(i_am_new_user.getInput())); //
            } else {
                new Printer_txt("Некорректный ввод. Введите число").print();
                continue;
            }
            i_am_new_user.get_input("Введите стартовую 'удачу' (1 - 100): ");
            if (i_am_new_user.is_number_less_than_100()) {
                this.setLuck(Integer.parseInt(i_am_new_user.getInput()));
            } else {
                new Printer_txt("Некорректный ввод").print();
                continue;
            }
            break;
        }
        new Printer_txt("Добро пожаловать, " + this.getName() + " !").print();
    }

    @Override
    public boolean play(int bet) {
        if (this.getMoney() > bet) {
            this.setMoney(this.getMoney() - bet);
            return true;
        } else {
            new Printer_txt("Ставка превышает баланс").print();
        }
        return false;
    }

    public boolean isStep() {
        return step;
    }

    public void setStep(boolean step) {
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gamer<?> gamer)) return false;
        if (!super.equals(o)) return false;
        return isStep() == gamer.isStep() && Objects.equals(getWon(), gamer.getWon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWon(), isStep());
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "won=" + won +
                ", step=" + step +
                '}';
    }
}