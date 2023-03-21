package Interface;

import Printer.Printer_txt;

import java.util.Scanner;

public class Input_user {
    private String command;
    private Scanner scanner;
    private String input;

    public Input_user() {
        this.scanner = new Scanner(System.in);
    }


    public void get_input(String command) {
        this.command = command;
        new Printer_txt(this.getCommand()).print();
        this.setInput(this.scanner.nextLine());
    }

    public boolean is_number() {
        return this.getInput().matches("^\\d+$");
    }


    public boolean is_number_less_than_100() {
        if (this.is_number()) {
            if (Integer.parseInt(this.getInput()) <= 100 && Integer.parseInt(this.getInput()) >= 0) {
                return true;
            }
            return false;
        }
        return false;
    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}