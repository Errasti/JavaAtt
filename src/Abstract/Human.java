package Abstract;

import java.util.Objects;

public abstract class Human {
    private String name;
    private int luck;
    private int money;

    public Human(String name, int luck, int money) {
        this.name = name;
        this.luck = luck;
        this.money = money;
    }

    public Human() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return luck == human.luck && money == human.money && Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, luck, money);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", luck=" + luck +
                ", money=" + money +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public abstract boolean play(int bet);
}
