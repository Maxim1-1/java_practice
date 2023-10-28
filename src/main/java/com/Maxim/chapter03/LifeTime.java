package com.Maxim.chapter03;

public class LifeTime {
    public static void main(String[] args) {
        int x;
        for (x = 0; x < 3; x++) {
            int y = -1; // переменная у инициализируе тся
            System.out.println(" Знaчeниe у равно " + y);
            y = 100;

            System.out.println("Teпepь значение у равно " + y);

        }
    }
}