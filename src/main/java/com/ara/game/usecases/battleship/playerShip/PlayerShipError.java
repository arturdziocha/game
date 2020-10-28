package com.ara.game.usecases.battleship.playerShip;

import com.ara.game.usecases.common.Error;

public enum PlayerShipError implements Error {
    DATA_CANNOT_BE_EMPTY("Data cannot be empty"),
    PLAYER_ID_CANNOT_BE_EMPTY("Player id cannot be empty"),
    SHIP_ID_CANNOT_BE_EMPTY("Ship id cannot be empty");
    private final String cause;

    PlayerShipError(final String cause) {
        this.cause = cause;
    }

    @Override
    public String getCause() {
        return cause;
    }
}
