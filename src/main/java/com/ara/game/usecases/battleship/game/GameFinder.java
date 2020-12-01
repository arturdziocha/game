package com.ara.game.usecases.battleship.game;

import com.ara.game.usecases.battleship.game.dto.GameDTO;
import com.ara.game.usecases.battleship.game.port.GameGateway;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

final class GameFinder {
    private final GameGateway gameGateway;

    GameFinder(final GameGateway gameGateway) {
        this.gameGateway = gameGateway;
    }
    Either<Error, GameDTO> find(String id ){
        return gameGateway.find(id).toEither(GameError.CANNOT_FIND_GAME);
    }
}
