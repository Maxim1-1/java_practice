package com.Maxim.RockPaperScissors.console_utils;
import java.util.Scanner;

public class Reader {
    public String getValueFromConsole () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
