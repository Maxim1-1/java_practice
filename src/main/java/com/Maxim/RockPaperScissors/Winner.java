package com.Maxim.RockPaperScissors;

import java.util.*;

public class Winner {
    protected static ArrayList<Player> determineWinner(ArrayList<Player> players) {

        ArrayList<Player> winnerPlayers = new ArrayList<>();

        for (Player player : players) {
            player.setNamePlayer(player.getNamePlayer().toLowerCase());
        }

        if (players.size() == 2) {
            String winnerElement = returnWinnerElement(players.get(0).getPlayerElement(), players.get(1).getPlayerElement());

            if (players.get(0).getPlayerElement().equals(winnerElement) & players.get(1).getPlayerElement().equals(winnerElement)) {
                winnerPlayers.add(players.get(0));
                winnerPlayers.add(players.get(1));
            } else if (players.get(0).getPlayerElement().equals(winnerElement)) {
                winnerPlayers.add(players.get(0));
            } else {
                winnerPlayers.add(players.get(1));
            }
            return winnerPlayers;

        } else {
            return returnWinnerFromSetUsers(players);

        }
    }

    private static ArrayList<Player> returnWinnerFromSetUsers(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();
        Set<String> uniqueElements = new HashSet<>();
        HashMap<Player, String> playersAndElements = new HashMap<>();


        for (int i = 0; i < players.size(); i++) {
            uniqueElements.add(players.get(i).getPlayerElement());
            playersAndElements.put(players.get(i), players.get(i).getPlayerElement());
        }

//        for (int i = 0; i < players.size(); i++) {
//            playersAndElements.put(players.get(i), players.get(i).getPlayerElement());
//        }

        ArrayList<String> uniqueElementsList = new ArrayList<>(uniqueElements);

        if (uniqueElementsList.size() == 2) {
            String winnersElement = returnWinnerElement(uniqueElementsList.get(0), uniqueElementsList.get(1));
            for (Map.Entry<Player, String> player : playersAndElements.entrySet()) {
                if (player.getValue().equals(winnersElement)) {
                    winners.add(player.getKey());
                }
            }
        } else if (uniqueElementsList.size() == 1) {
            return players;
        } else {
            winners = null;
            System.out.println("ничья, игра окончена");
        }
        return winners;
    }


    private static String returnWinnerElement(String firstElement, String secondElement) {

        if (firstElement.equals("камень") & secondElement.equals("бумага")) {
            return secondElement;
        } else if (firstElement.equals("бумага") & secondElement.equals("камень")) {
            return firstElement;
        } else if (firstElement.equals("бумага") & secondElement.equals("ножницы")) {
            return secondElement;
        } else if (firstElement.equals("ножницы") & secondElement.equals("бумага")) {
            return firstElement;
        } else if (firstElement.equals("камень") & secondElement.equals("ножницы")) {
            return firstElement;
        } else if (firstElement.equals("ножницы") & secondElement.equals("камень")) {
            return secondElement;
        } else {
            return secondElement;
        }
    }
}
