package com.ara.game.usecases.battleship.game;

import com.ara.game.usecases.battleship.game.dto.GameCreateDTO;
import com.ara.game.usecases.battleship.game.dto.GameDTO;
import com.ara.game.usecases.battleship.game.port.GameGateway;
import com.ara.game.usecases.common.Error;
import com.ara.game.usecases.common.port.IdGenerator;
import io.vavr.control.Either;
import io.vavr.control.Option;

final class GameCreator {
    private final GameGateway gameGateway;
    private final IdGenerator idGenerator;
    private final GameValidator validator;
    private final GameMapper mapper;

    public GameCreator(final GameGateway gameGateway, final IdGenerator idGenerator) {
        this.gameGateway = gameGateway;
        this.idGenerator = idGenerator;
        this.validator = new GameValidator();
        this.mapper = new GameMapper();
    }

    Either<Error, GameDTO> create(GameCreateDTO inputData) {
        Option<Error> validated = validator.validate(inputData);
        if (validated.isDefined()) {
            return Either.left(validated.get());
        }
        Game game = Game.builder().playerId(inputData.getPlayerId()).id(idGenerator.generate()).boardSize(inputData.getBoardSize()).build();
        return Either.right(gameGateway.create(mapper.mapToDTO(game)));

    }

}
