package com.ara.game.usecases.battleship.game;

import com.ara.game.usecases.common.Error;

enum GameError implements Error {
    DATA_CANNOT_BE_NULL("Data cannot be null"),
    BOARD_SIZE_CANNOT_BE_NULL("Board size cannot be null"),
    TO_SMALL_BOARD_SIZE("To small board size");

    private final String cause;

    GameError(String cause) {
        this.cause = cause;
    }

    @Override
    public String getCause() {
        return cause;
    }

}
