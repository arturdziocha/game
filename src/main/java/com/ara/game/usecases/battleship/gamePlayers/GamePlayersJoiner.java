package com.ara.game.usecases.battleship.gamePlayers;

import com.ara.game.usecases.battleship.gamePlayers.dto.GamePLayersJoinDTO;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;
import io.vavr.control.Option;

final class GamePlayersJoiner {
    private final GamePlayersGateway gamePlayersGateway;
    private final GamePlayersValidator validator;

    GamePlayersJoiner(final GamePlayersGateway gamePlayersGateway) {
        this.gamePlayersGateway = gamePlayersGateway;
        this.validator = new GamePlayersValidator();
    }

    Either<Error, GamePLayersJoinDTO> join(GamePLayersJoinDTO inputData) {
        Option<Error> validated = validator.validate(inputData);
        if (validated.isDefined()) {
            return Either.left(validated.get());
        }
        // TODO
        return null;
    }
}
