package com.ara.game.usecases.battleship.gamePlayers;

import com.ara.game.usecases.common.Error;

enum GamePlayersError implements Error {
    DATA_CANNOT_BE_EMPTY("Data cannot be empty"),
    NOT_ALL_PLAYERS_SET("Not all players set");

    private final String cause;

    GamePlayersError(String cause) {
        this.cause = cause;
    }

    @Override
    public String getCause() {
        return cause;
    }
}
