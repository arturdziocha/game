package com.ara.game.usecases.battleship.playerType;

import com.ara.game.usecases.common.Error;

enum PlayerTypeError implements Error {
    DATA_CANNOT_BE_EMPTY("DATA CANNOT_BE_EMPTY"),
    CANNOT_FIND_TYPE_OF_PLAYER("Cannot find player type");
    private final String cause;

    PlayerTypeError(final String cause) {
        this.cause = cause;
    }

    @Override
    public String getCause() {
        return cause;
    }
}
