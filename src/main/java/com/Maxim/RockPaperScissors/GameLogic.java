package com.Maxim.RockPaperScissors;

import com.Maxim.RockPaperScissors.console_utils.Reader;
import com.Maxim.RockPaperScissors.console_utils.Writer;

import java.util.*;

public class GameLogic {

    public void start() {
        Writer startMessage = new Writer();
        startMessage.outputValueConsole("Для начала игры введите start, при вводе любого другого слова игра завершиться");
    }

    public ArrayList<Player> inputAndCreatePlayers() {
        Reader readerConsole = new Reader();
        Writer writerConsole = new Writer();
        PlayerFactory playersFactory = new PlayerFactory();
        ArrayList<Player> players;

        writerConsole.outputValueConsole("Введите цифрой количество участников");
        players = playersFactory.createPlayers(Integer.parseInt(readerConsole.getValueFromConsole()));

        for (int i = 0; i < players.size(); i++) {
            writerConsole.outputValueConsole(String.format("Введите имя участника №%d", i + 1));
            players.get(i).setNamePlayer(readerConsole.getValueFromConsole());
        }
        return players;
    }

    public void chooseElements(ArrayList<Player> players) {
        Writer writerConsole = new Writer();
        Reader readerConsole = new Reader();

        for (Player player : players) {
            writerConsole.outputValueConsole(String.format("%s, выбери свой элемент", player.getNamePlayer()));
            player.setPlayerElement(readerConsole.getValueFromConsole());
        }
    }

}
