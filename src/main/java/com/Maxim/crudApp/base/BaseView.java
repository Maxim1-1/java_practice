package com.Maxim.crud_app.base;

import java.util.Scanner;

public interface BaseView {
     default Integer getIdFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id сущности");
        return scanner.nextInt();
    }
}
