package com.Maxim.crud_app;

import java.util.Scanner;

public class Runner {
    public static void run() {
        UserCommandHandler userController = new UserCommandHandler();
        Scanner scanner = new Scanner(System.in);

        userController.getCommandConsole();

        while (true) {
            System.out.println("Для выхода введите exit, для продолжения введите любой символ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            } else {
                userController.getCommandConsole();
            }
        }
    }

}

