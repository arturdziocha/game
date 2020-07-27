package com.ara.game.usecases.battleship.ship;

import com.ara.game.usecases.common.Error;

public enum ShipError implements Error {
    DATA_CANNOT_BE_NULL("Data cannot be null"),
    SHIP_CLASS_CANNOT_BE_EMPTY("Class of ship cannot be empty");
    private final String cause;

    ShipError(final String cause) {
        this.cause = cause;
    }

    @Override
    public String getCause() {
        return cause;
    }

}
