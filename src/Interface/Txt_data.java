package Interface;

public class Txt_data {
    private final String greeting = "Приветствуем вас в магазине игрушек";
    private final String rules_info = "Просто загадайте число, лототрон все сделает за вас";
    private final String enter = "Учавствуем? ( y/n ) ";
    private final String you_enter = "Выберите число от 1 до 100";
    private final String exit = "Выйти?";
    private final String yes_no = "y/n? ";
    private final String current_money = "Баланс";
    private final String no_credit = "Некорректный ввод";
    private final String no_toys = "Вы пока не выйграли ни одной игрушки!";

    private final String tablo = "Витрина";
    private final String game = "Сыграем?";
    private final String last_exit = "Ждем вас снова";
    private final String now_exit = "Всего хорошего!";
    private final String menu = "\n1. Внести 1 монету на баланс. /" +
            "\n2. Внести 5 монет на баланс. /" +
            "\n3. Внести 10 монет на баланс. /" +
            "\n4. Положить другое количество монет: /" +
            "\n5. Изменить вероятность выпадения игрушек/" +
            "\n6. Посмотреть Выйгранные игрушки /" +
            "\n7. Посмотреть на разыгрываемые игрушки /" +
            "\n8. Уйти";

    private final String change_chance = "\n1. Изменить вероятность для Fancy_toy /" +
            "\n2. Soft_toy/" +
            "\n3. Car_toy/" +
            "\n4. Super_toy/" +
            "\n5. Exit";
    private final String pg_close = "Программа завершена";
    private final String you_bet_money = "Введите целое число";

    private final String you_win = "\nПоздравляем с победой!" +
            "\nЗабирайте ваш выйгрыш: ";

    private final String bonus = "Можем предоставить бонусные монеты";

    private final String you_loose = "Закончились монеты.";

    private final String uoy_looser = "Некорректный ввод";
    private final String error_input = "Нет такого пункта";

    public String getTablo() {
        return tablo;
    }

    public String getCurrent_money() {
        return current_money;
    }

    public String getNo_credit() {
        return no_credit;
    }

    public String getBonus() {
        return bonus;
    }

    public String getYou_bet_money() {
        return you_bet_money;
    }

    public String getUoy_looser() {
        return uoy_looser;
    }

    public String getChange_chance() {
        return change_chance;
    }

    public String getError_input() {
        return error_input;
    }

    public String getPg_close() {
        return pg_close;
    }

    public String getExit() {
        return exit;
    }

    public String getLast_exit() {
        return last_exit;
    }

    public String getYes_no() {
        return yes_no;
    }

    public String getEnter() {
        return enter;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getRules_info() {
        return rules_info;
    }

    public String getGame() {
        return game;
    }

    public String getNo_toys() {
        return no_toys;
    }

    public String getNow_exit() {
        return now_exit;
    }

    public String getYou_enter() {
        return you_enter;
    }

    public String getYou_win() {
        return you_win;
    }

    public String getYou_loose() {
        return you_loose;
    }

    public String getMenu() {
        return menu;
    }
}