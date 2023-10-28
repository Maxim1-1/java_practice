package com.Maxim.RockPaperScissors;

import java.util.ArrayList;

public class PlayerFactory {

    public ArrayList<Player> createPlayers (int countPlayers) {
        ArrayList<Player> listPlayers = new ArrayList<>();

        for (int i=0;i<countPlayers;i++) {
            listPlayers.add(new Player());
        }
        return listPlayers;
    }
}
