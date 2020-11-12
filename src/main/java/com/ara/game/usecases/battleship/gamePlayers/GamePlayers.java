package com.ara.game.usecases.battleship.gamePlayers;

import lombok.Builder;
import lombok.Getter;

@Builder
public class GamePlayers {
    @Getter
    private final String firstPlayer;
    @Getter
    private final String secondPlayer;
    @Getter
    private final String currentPlayer;
}
