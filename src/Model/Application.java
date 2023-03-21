package Model;

import Abstract.Toy;
import Model.Toy.Car_toy;
import Model.Toy.Fancy_toy;
import Model.Toy.Soft_toy;
import Model.Toy.Super_toy;
import Printer.Printer_toy;
import Printer.Printer_txt;
import Interface.Input_user;
import Interface.Txt_data;

public class Application {
    private Gamer<Toy> user;
    private Store<Toy> my_store;
    private Input_user enter_gamer;

    public Application() {
        this.user = new Gamer<Toy>();
        this.my_store = new Store<Toy>();
        this.enter_gamer = new Input_user();
    }

    public Gamer<Toy> getUser() {
        return user;
    }

    public void setUser(Gamer<Toy> user) {
        this.user = user;
    }

    public Store getMy_store() {
        return my_store;
    }

    public void setMy_store(Store my_store) {
        this.my_store = my_store;
    }

    public Input_user getEnter_gamer() {
        return enter_gamer;
    }

    public void setEnter_gamer(Input_user enter_gamer) {
        this.enter_gamer = enter_gamer;
    }


    public void run_() {
        this.getMy_store().generate_toys();
        this.getUser().full_data_user();
        new Printer_txt(new Txt_data().getEnter()).print();
        this.getEnter_gamer().get_input(new Txt_data().getYes_no());
        if (this.getEnter_gamer().getInput().equals("y")) {
            new Printer_txt(new Txt_data().getGame()).print();
            this.getEnter_gamer().get_input(new Txt_data().getYes_no());
            if (this.getEnter_gamer().getInput().equals("y")) {
                new Printer_txt(new Txt_data().getGreeting()).print();
                new Printer_txt(new Txt_data().getRules_info()).print();
                while (true) {

                    new Printer_txt(new Txt_data().getTablo()).print();
                    new Printer_txt(this.getMy_store().getInfo_store_fancy().toString()).print();
                    new Printer_txt(this.getMy_store().getInfo_store_soft().toString()).print();
                    new Printer_txt(this.getMy_store().getInfo_store_car().toString()).print();
                    new Printer_txt(this.getMy_store().getInfo_store_super().toString()).print();
                    this.getEnter_gamer().get_input(new Txt_data().getMenu());
                    if (this.getEnter_gamer().getInput().equals("1")) {
                        this.getUser().setStep(this.getUser().play(1));
                        if (this.getUser().isStep()) {
                            this.getEnter_gamer().get_input(new Txt_data().getYou_enter());
                            if (this.getEnter_gamer().is_number_less_than_100()) {
                                this.getUser().getWon().addAll(this.getMy_store().drawing_of_toys(this.getUser(), 1, Integer.parseInt(this.getEnter_gamer().getInput())));
                            } else {
                                new Printer_txt(new Txt_data().getUoy_looser()).print();
                            }
                        } else {
                            this.offer_credit();
                        }
                    } else if (this.getEnter_gamer().getInput().equals("2")) {
                        this.getUser().setStep(this.getUser().play(5));
                        if (this.getUser().isStep()) {
                            this.getEnter_gamer().get_input(new Txt_data().getYou_enter());
                            if (this.getEnter_gamer().is_number_less_than_100()) {
                                this.getUser().getWon().addAll(this.getMy_store().drawing_of_toys(this.getUser(), 5, Integer.parseInt(this.getEnter_gamer().getInput())));
                            } else {
                                new Printer_txt(new Txt_data().getUoy_looser()).print();
                            }
                        } else {
                            this.offer_credit();
                        }
                    } else if (this.getEnter_gamer().getInput().equals("3")) {
                        this.getUser().setStep(this.getUser().play(10));
                        if (this.getUser().isStep()) {
                            this.getEnter_gamer().get_input(new Txt_data().getYou_enter());
                            if (this.getEnter_gamer().is_number_less_than_100()) {
                                this.getUser().getWon().addAll(this.getMy_store().drawing_of_toys(this.getUser(), 10, Integer.parseInt(this.getEnter_gamer().getInput())));
                            } else {
                                new Printer_txt(new Txt_data().getUoy_looser()).print();
                            }
                        } else {
                            this.offer_credit();
                        }
                    } else if (this.getEnter_gamer().getInput().equals("4")) {
                        this.getEnter_gamer().get_input(new Txt_data().getYou_bet_money());
                        if (this.getEnter_gamer().is_number()) {
                            this.getUser().setStep(this.getUser().play(Integer.parseInt(this.getEnter_gamer().getInput())));
                            if (this.getUser().isStep()) {
                                this.getEnter_gamer().get_input(new Txt_data().getYou_enter());
                                if (this.getEnter_gamer().is_number_less_than_100()) {
                                    this.getUser().getWon().addAll(this.getMy_store().drawing_of_toys(this.getUser(), Integer.parseInt(this.getEnter_gamer().getInput()), Integer.parseInt(this.getEnter_gamer().getInput())));
                                } else {
                                    new Printer_txt(new Txt_data().getUoy_looser()).print();
                                }
                            } else {
                                this.offer_credit();
                            }
                        } else {
                            new Printer_txt("Вы ввели не число!");
                        }
                    } else if (this.getEnter_gamer().getInput().equals("5")) {
                        while (true) {
                            this.getEnter_gamer().get_input(new Txt_data().getChange_chance());
                            if (this.getEnter_gamer().getInput().equals("1")) {
                                this.getMy_store().edit_toy_chance(new Fancy_toy());
                            } else if (this.getEnter_gamer().getInput().equals("2")) {
                                this.getMy_store().edit_toy_chance(new Soft_toy());
                            } else if (this.getEnter_gamer().getInput().equals("3")) {
                                this.getMy_store().edit_toy_chance(new Car_toy());
                            } else if (this.getEnter_gamer().getInput().equals("4")) {
                                this.getMy_store().edit_toy_chance(new Super_toy());
                            } else if (this.getEnter_gamer().getInput().equals("5")) {
                                break;
                            } else {
                                new Printer_txt(new Txt_data().getError_input()).print();
                            }
                        }
                    } else if (this.getEnter_gamer().getInput().equals("6")) {
                        if (this.getUser().getWon().size() > 0) {
                            new Printer_toy<Toy>(this.getUser().getWon()).print_linked();
                        } else {
                            new Printer_txt(new Txt_data().getNo_toys()).print();
                        }
                    } else if (this.getEnter_gamer().getInput().equals("7")) {
                        new Printer_toy<Toy>(this.getMy_store().getFancy_toy()).print_linked();
                        new Printer_toy<Toy>(this.getMy_store().getSoft_toy()).print_linked();
                        new Printer_toy<Toy>(this.getMy_store().getCar_toy()).print_linked();
                        new Printer_toy<Toy>(this.getMy_store().getSuper_toy()).print_linked();
                    } else if (this.getEnter_gamer().getInput().equals("8")) {
                        new Printer_txt(new Txt_data().getPg_close()).print();
                        break;
                    } else {
                        new Printer_txt(new Txt_data().getError_input()).print();
                    }
                }

            } else {
                new Printer_txt(new Txt_data().getNow_exit()).print();
                new Printer_txt(new Txt_data().getPg_close()).print();
            }
        } else {
            new Printer_txt(new Txt_data().getNow_exit()).print();
            new Printer_txt(new Txt_data().getPg_close()).print();
        }
    }

    private void offer_credit() {
        new Printer_txt(new Txt_data().getCurrent_money() + this.getUser().getMoney()).print();
        new Printer_txt(new Txt_data().getYou_loose()).print();
        this.getEnter_gamer().get_input(new Txt_data().getYes_no());
        if (this.getEnter_gamer().getInput().equals("y") || this.getEnter_gamer().getInput().equals("yes")) {
            this.getEnter_gamer().get_input(new Txt_data().getBonus());
            if (this.getEnter_gamer().is_number()) {
                this.getUser().setMoney(Integer.parseInt(this.getEnter_gamer().getInput()));
            } else {
                new Printer_txt(new Txt_data().getNo_credit()).print();
            }
        }
    }
}