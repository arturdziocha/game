package com.ara.game.usecases.battleship.playerShip;

import com.ara.game.usecases.common.Error;

public enum PlayerShipError implements Error {
    DATA_CANNOT_BE_EMPTY("Data cannot be empty"),
    PLAYER_ID_CANNOT_BE_EMPTY("Player id cannot be empty"),
    SHIP_ID_CANNOT_BE_EMPTY("Ship id cannot be empty"),
    ALL_SHIP_PLACED("All ships already placed"),
    CANNOT_FIND_RELATED_PLAYER("Cannot find related player"),
    CANNOT_FIND_RELATED_SHIP("Cannot find related ship"),
    SHIP_IS_ALREADY_PLACED("Ship is already placed");
    private final String cause;

    PlayerShipError(final String cause) {
        this.cause = cause;
    }

    @Override
    public String getCause() {
        return cause;
    }
}
