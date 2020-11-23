package com.ara.game.usecases.battleship.game;

import com.ara.game.usecases.battleship.game.dto.GameDTO;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Option;

final class GameValidator {
    Option<Error> validate(GameDTO inputData) {
        if (inputData == null) {
            return Option.some(GameError.DATA_CANNOT_BE_NULL);
        }
        if (inputData.getBoardSize() == null) {
            return Option.some(GameError.BOARD_SIZE_CANNOT_BE_NULL);
        }
        if (inputData.getBoardSize() <= 8) {
            return Option.some(GameError.TO_SMALL_BOARD_SIZE);
        }
        return Option.none();
    }
}