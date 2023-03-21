package Printer;


public class Printer_txt {
    private String text;


    public Printer_txt(String text) {
        this.text = text;
    }


    public void print() {
        System.out.println(this.text);
    }
}