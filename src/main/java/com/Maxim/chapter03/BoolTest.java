package com.Maxim.chapter03;

public class BoolTest {
    public static void main(String[] args) {
        boolean b;
        b = false;
        System.out.println("Ь равно " + b);
        b = true;
        System.out.println("b равно " + b);

        if (b) System.out.println("Этo выполняется . ");
        b = false;
        if (b) System.out.println("Этo не выполняется . ");

        System.out.println("lO > 9 равно " + (10 > 9));
    }

}

